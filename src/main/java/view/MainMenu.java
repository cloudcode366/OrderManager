package view;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class MainMenu {
    private Scanner sc;
    public int mainFrame(){
        System.out.println("""
                ______________________________________________________________
                | 1. List all Products                                       |
                | 2. List all Customers                                      |
                | 3. Search a Customer based on his/her ID                   |
                | 4. Add a Customer                                          |
                | 5. Update a Customer                                       |
                | 6. Save Customers to the file, named customers.txt         |
                | 7. List all Orders in ascending order of Customer name     |
                | 8. List all pending Orders                                 |
                | 9. Add an Order                                            |
                | 10. Update an Order                                        |
                | 11. Save Orders to file, named orders.txt                  |
                | Others- Quit                                               |
                ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~""");
        sc = new Scanner(System.in);
        return sc.nextInt();
    }
    public boolean returnFrame() throws Exception {
        System.out.println("Do you want to return to the main menu(Y/N):");
        sc = new Scanner(System.in);
        String tmp = sc.nextLine();
        if(tmp.equalsIgnoreCase("y")){
            return true;
        }
        else if (tmp.equalsIgnoreCase("n")){
            return false;
        }
        else {
            throw new Exception("error option");
        }
    }
    public void subMenuFrame(){
        System.out.println("" +
                "1.Update an Order based on its ID\n" +
                "2.Delete an Order based on its ID");
    }public String deleteFrame(){
        System.out.print("Enter id:");
        sc = new Scanner(System.in);
        return sc.nextLine();
    }
    public String[] addOrderFrame(String cString, String pString){
        String[] result = new String[6];
        System.out.print("Enter id:");
        sc = new Scanner(System.in);
        result[0] = sc.nextLine();
        String[] tmp = cString.split("\n");
        System.out.println("Customers List:");
        for(int i = 0; i < tmp.length; i++){
            tmp[i] = i + 1 +"."+tmp[i];
            System.out.print(tmp[i]+"\n");
        }
        System.out.print("Please choose Customer:");
        int option = sc.nextInt();
        result[1] = cString.split("\n")[option-1].split(",")[0];
        tmp = pString.split("\n");
        System.out.println("Product List:");
        for(int i = 0; i < tmp.length; i++){
            tmp[i] = i + 1 +"."+tmp[i];
            System.out.print(tmp[i]+"\n");
        }
        System.out.print("Please choose Product:");
        option = sc.nextInt();
        result[2] = pString.split("\n")[option-1].split(",")[0];
        System.out.print("Please enter quantity:");
        sc = new Scanner(System.in);
        result[3] = sc.nextLine();
        System.out.print("Please enter date by format mm/dd/yyyy(If you do not enter any word, date is today):");
        sc = new Scanner(System.in);
        result[4] = sc.nextLine();
        DateFormat format = new SimpleDateFormat("MM/dd/yyyy");
        Date date = new Date();
        if(result[4].isBlank()){
            result[4] = format.format(date);
        }
        System.out.print("Please enter status:");
        sc = new Scanner(System.in);
        result[5] = sc.nextLine();
        return result;
    }
    public String[] addOrderFrame(String id, String cString, String pString){
        String[] result = new String[6];
        sc = new Scanner(System.in);
        result[0] = id;
        String[] tmp = cString.split("\n");
        System.out.println("Customers List:");
        for(int i = 0; i < tmp.length; i++){
            tmp[i] = i + 1 +"."+tmp[i];
            System.out.print(tmp[i]+"\n");
        }
        System.out.print("Please choose Customer:");
        int option = sc.nextInt();
        result[1] = cString.split("\n")[option-1].split(",")[0];
        tmp = pString.split("\n");
        System.out.println("Product List:");
        for(int i = 0; i < tmp.length; i++){
            tmp[i] = i + 1 +"."+tmp[i];
            System.out.print(tmp[i]+"\n");
        }
        System.out.print("Please choose Product:");
        option = sc.nextInt();
        result[2] = pString.split("\n")[option-1].split(",")[0];
        System.out.print("Please enter quantity:");
        sc = new Scanner(System.in);
        result[3] = sc.nextLine();
        System.out.print("Please enter date by format mm/dd/yyyy(If you do not enter any word, date is today):");
        sc = new Scanner(System.in);
        result[4] = sc.nextLine();
        DateFormat format = new SimpleDateFormat("MM/dd/yyyy");
        Date date = new Date();
        if(result[4].isBlank()){
            result[4] = format.format(date);
        }
        System.out.print("Please enter status:");
        sc = new Scanner(System.in);
        result[5] = sc.nextLine();
        return result;
    }
    public String searchFrame(){
        String result;
        System.out.println("Enter id you want to search");
        sc = new Scanner(System.in);
        result = sc.nextLine();
        return result;
    }
    public String[] addCustomerFrame(){
        String[] result = new String[4];
        System.out.print("Enter id:");
        sc = new Scanner(System.in);
        result[0] = sc.nextLine();
        System.out.print("Enter name:");
        sc = new Scanner(System.in);
        result[1] = sc.nextLine();
        System.out.print("Enter address:");
        sc = new Scanner(System.in);
        result[2] = sc.nextLine();
        System.out.print("Enter phone number:");
        sc = new Scanner(System.in);
        result[3] = sc.nextLine();
        return result;
    }
    public String[] addCustomerFrame(String id){
        String[] result = new String[4];
        result[0] = id;
        System.out.print("Enter name:");
        sc = new Scanner(System.in);
        result[1] = sc.nextLine();
        System.out.print("Enter address:");
        sc = new Scanner(System.in);
        result[2] = sc.nextLine();
        System.out.print("Enter phone number:");
        sc = new Scanner(System.in);
        result[3] = sc.nextLine();
        return result;
    }
    public void listFrame(String data){
        System.out.println(data);
    }
    public void errorFrame(Exception e) {
        System.err.println("Have an error:"+e.getMessage());
    }
    public MainMenu() {
        System.out.print(rgbPrint(0,230,0,true));
        System.out.print(rgbPrint(0,0,0,false));
    }
    public boolean autoIdFrame(String id) throws Exception {
        System.out.print("Id auto generate is:"+id+". Do you want to use this Id(Y/N):");
        sc = new Scanner(System.in);
        String value = sc.nextLine();
        if(value.equalsIgnoreCase("y")) return true;
        else if (value.equalsIgnoreCase("n")) return false;
        else throw new Exception("error option");
    }
    public String rgbPrint(int Red,int Green,int Blue,boolean option){
      return option ? "\033[38;2;"+Red+";"+Green+";"+Blue+"m" : "\033[48;2;"+Red+";"+Green+";"+Blue+"m";
    }
}
