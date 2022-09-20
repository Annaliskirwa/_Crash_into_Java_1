import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {
//    For formatting the double to two decimal places
    private static final DecimalFormat df = new DecimalFormat("0.00");
    public static void main(String[] args) {
        Repository[] repositories = {
                new Repository("Oranges", 10, 2.99, 500),
                new Repository("Eggs", 12, 1.69, 1000),
                new Repository("Apples", 3, 1.0, 600),
                new Repository("Watermelons", 1, 4.39, 100),
                new Repository("Bagels", 6, 3.0, 150)
        };

//        update oranges
        repositories[0].setGroupCount(10);
        repositories[0].setGroupPrice(3.99);

//        update bagels
        repositories[4].setGroupCount(5);
        repositories[4].setGroupPrice(3.00);

        displayRepository(repositories);
        Shopping customer1 = readUserInput();
        displayShoppingBill(customer1, repositories);
//        calling update stock
        updateStock(customer1, repositories);
//        calling the updated repository method
        displayUpdatedRepository(repositories);

    }

    public static void displayRepository(Repository[] repositories){
        System.out.println("Welcome to the store! List of items in the repository:");
        int index = 0;
        for (int i = 0; i < repositories.length; i++) {
            index = i+1;
            Repository repository = repositories[i];
            String message = index + "\t " + repository.getItemName() + ": " + repository.getGroupCount() + " for $" +
             repository.getGroupPrice() + ".\t\t The store has " + repository.getNumAvailable() + " in stock.";

            System.out.println(message);

        }
        System.out.println(index+1 + "\t Exit");

    }

//    method for reading  and storing inputs
    public static Shopping readUserInput(){
        int itemNumber;
        int quantity;

        //  shopping class instance/object
        Scanner scanner = new Scanner(new InputStreamReader(System.in));
        Shopping customer1 = new Shopping();
        while(true){
            System.out.println("Enter the item number followed by purchased quantity. Enter 6 to exit");
            itemNumber = scanner.nextInt();
//            check for item 6
            if (itemNumber == 6){

                break;
            }
            quantity = scanner.nextInt();
           customer1.addItem(itemNumber-1, quantity);
        }
        return customer1;
    }

    public static void displayShoppingBill(Shopping shopping, Repository[] repository){
        int[] items = shopping.getItems();
        System.out.println("Your shopping receipt");
        System.out.println("----------------------");
        System.out.println("Item name \t\tQuantity \t\tCost");
        double total = 0;
        for (int i = 0; i < items.length; i++) {
            if(items[i] == 0){
                continue;
            }

            double price = computePrice(repository[i].getGroupCount(), repository[i].getGroupPrice(), items[i]);
//            updates the price
            total += price;
            System.out.println(repository[i].getItemName() +"\t\t\t"+ items[i] +"\t\t\t"+ df.format(price));
        }
        String message = "Total shopping cost: "+ df.format(total);
        System.out.println(message);

    }
    //        method to do the computations
    public static double computePrice(int groupCount, double groupPrice, int quantity){
        return  ((double)quantity)/groupCount*groupPrice;
    }

    public static void updateStock(Shopping shopping, Repository[] repositories){
        int[] items = shopping.getItems();
        for (int i = 0; i < items.length; i++) {
//            compute the remaining stock
            repositories[i].setNumAvailable(repositories[i].getNumAvailable()-items[i]);
        }

    }
    public static void displayUpdatedRepository(Repository[] repositories){
        System.out.println("Our updated repository:");
        System.out.println("---------------------");
        System.out.println("Items available");
        int index = 0;
        for (int i = 0; i < repositories.length; i++) {
            index = i+1;
            Repository repository = repositories[i];
            String message = index + "\t " + repository.getItemName() + ": " + repository.getGroupCount() + " for $" +
                    repository.getGroupPrice() + ".\t\t The store has " + repository.getNumAvailable() + " in stock.";

            System.out.println(message);

        }

    }
}