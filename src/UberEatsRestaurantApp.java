import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;




public class UberEatsRestaurantApp { 
    public static Scanner scan = new Scanner(System.in);
    public static String userinput;
    private static void printOrders(String RestaurantName) throws IOException {
        String line = "";
        String cvsSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader("orders.csv"))) {
            int lineNum = 0;
            boolean found  = false;
            while ((line = br.readLine()) != null) {
                if (lineNum == 0) {
                    lineNum++;
                    continue;
                }

                // use comma as separator
                String[] item= line.split(cvsSplitBy);
                String val =item[0];
                // checks for specific restaurant name 
                if (val.contains(RestaurantName)){
                    String[] orderList = item[1].split(";");
                    for (int i =0 ; i < orderList.length;i++){
                    System.out.println(i+1+"." + orderList[i].toString()+ " from "+ item[2]);
                    }
                    found = true;
                }
        
            }

            if(found == false){
                System.out.println("Restaurant not found");
            
            }
            
        } catch (IOException e) {
            System.out.println("Not found");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        System.out.println("Welcome to UberEatsApp - signature dish edition FOR RESTAURANTS\n");

        System.out.println("Enter restaurant name (KFC, McDonalds, Burger King)\n");
        // takes user input
        userinput= scan.nextLine();


        System.out.println("Loading all orders placed...\n");
        // load list of orders
        /**
         * 1. Zinger burger & Chips from rondebosch 2. Wings & Chips from rondebosch 3.
         * Zinger burger & Chips from rondebosch
         */
        printOrders(userinput);
        
        
    }
    


}