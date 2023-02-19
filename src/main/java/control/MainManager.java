
package control;

import model.Customers;
import view.MainMenu;

import java.util.Scanner;

public class MainManager {
    private final CustomersManager customersManager = new CustomersManager();
    private final ProductsManager productsManager = new ProductsManager();
    private final OrdersManager ordersManager = new OrdersManager(customersManager,productsManager);
    private final MainMenu mainMenu;
    public MainManager(MainMenu mainMenu) throws Exception {
        this.mainMenu = mainMenu;
    }

    public void control(int option) throws Exception {
        switch (option) {
            case 1->{
                try {
                    mainMenu.listFrame(productsManager.toString(ProductsManager.READ_IN_FILE_PRODUCT));
                }
                catch (Exception e){
                    mainMenu.errorFrame(e);
                }
                finally {
                    boolean check;
                    do {
                        try {
                            checkLoop(mainMenu.returnFrame());
                            check = false;
                        }
                        catch (Exception ex){
                            if(ex.getMessage().equals("no loop")){
                                throw ex;
                            }
                            mainMenu.errorFrame(ex);
                            check = true;
                        }

                    } while (check);
                }
            }
            case 2->{
                try {
                    mainMenu.listFrame(customersManager.toString(ProductsManager.READ_IN_STACK_PRODUCT));
                }
                catch (Exception e){
                    mainMenu.errorFrame(e);
                }
                finally {
                    boolean check;
                    do {
                        try {
                            checkLoop(mainMenu.returnFrame());
                            check = false;
                        }
                        catch (Exception ex){
                            if(ex.getMessage().equals("no loop")){
                                throw ex;
                            }
                            mainMenu.errorFrame(ex);
                            check = true;
                        }

                    } while (check);
                }
            }
            case 3->{
                try {
                    mainMenu.listFrame(customersManager.search(mainMenu.searchFrame()).toString());
                }
                catch (Exception e){
                    mainMenu.errorFrame(e);
                }
                finally {
                    boolean check;
                    do {
                        try {
                            checkLoop(mainMenu.returnFrame());
                            check = false;
                        }
                        catch (Exception ex){
                            if(ex.getMessage().equals("no loop")){
                                throw ex;
                            }
                            mainMenu.errorFrame(ex);
                            check = true;
                        }

                    } while (check);
                }
            }
            case 4->{
                try {
                    if(mainMenu.autoIdFrame(customersManager.idAuto())){
                        customersManager.add(new Customers(mainMenu.addCustomerFrame(customersManager.idAuto())));
                    }
                    else {
                        customersManager.add(new Customers(mainMenu.addCustomerFrame()));
                    }
                }
                catch (Exception e){
                    mainMenu.errorFrame(e);
                }
                finally {
                    boolean check;
                    do {
                        try {
                            checkLoop(mainMenu.returnFrame());
                            check = false;
                        }
                        catch (Exception ex){
                            if(ex.getMessage().equals("no loop")){
                                throw ex;
                            }
                            mainMenu.errorFrame(ex);
                            check = true;
                        }

                    } while (check);
                }
            }
            case 5->{
                try {
                    customersManager.update(mainMenu.addCustomerFrame());
                    mainMenu.listFrame("Update success.");
                }
                catch (Exception e){
                    mainMenu.errorFrame(e);
                }
                finally {
                    checkLoop(mainMenu.returnFrame());
                }
            }
            case 6->{
                try {
                    customersManager.writeFile();
                    mainMenu.listFrame("Save data to file\"customers.txt\" success.");
                }
                catch (Exception e){
                    mainMenu.errorFrame(e);
                }
                finally {
                    boolean check;
                    do {
                        try {
                            checkLoop(mainMenu.returnFrame());
                            check = false;
                        }
                        catch (Exception ex){
                            if(ex.getMessage().equals("no loop")){
                                throw ex;
                            }
                            mainMenu.errorFrame(ex);
                            check = true;
                        }

                    } while (check);
                }
            }
            case 7->{
                try{
                    mainMenu.listFrame(ordersManager.toString(OrdersManager.FILE_STRING));
                }
                catch (Exception e){
                    mainMenu.errorFrame(e);
                }
                finally {
                    boolean check;
                    do {
                        try {
                            checkLoop(mainMenu.returnFrame());
                            check = false;
                        }
                        catch (Exception ex){
                            if(ex.getMessage().equals("no loop")){
                                throw ex;
                            }
                            mainMenu.errorFrame(ex);
                            check = true;
                        }

                    } while (check);
                }
            }
            case 8-> {
                try {
                    mainMenu.listFrame(ordersManager.toString(OrdersManager.FILE_STRING_FALSE));
                } catch (Exception e) {
                    mainMenu.errorFrame(e);
                } finally {
                    boolean check;
                    do {
                        try {
                            checkLoop(mainMenu.returnFrame());
                            check = false;
                        }
                        catch (Exception ex){
                            if(ex.getMessage().equals("no loop")){
                                throw ex;
                            }
                            mainMenu.errorFrame(ex);
                            check = true;
                        }

                    } while (check);
                }
            }
            case 9->{
                try {
                    if(mainMenu.autoIdFrame(ordersManager.idAuto())){
                        ordersManager.add(mainMenu.addOrderFrame(ordersManager.idAuto(),
                                customersManager.toString(CustomersManager.READ_IN_FILE_PRODUCT),
                                productsManager.toString(ProductsManager.READ_IN_FILE_PRODUCT)));
                    }
                    else {
                        ordersManager.add(mainMenu.addOrderFrame(customersManager.toString(CustomersManager.READ_IN_FILE_PRODUCT),
                                productsManager.toString(ProductsManager.READ_IN_FILE_PRODUCT)));
                    }
                }
                catch (Exception e){
                    mainMenu.errorFrame(e);
                }
                finally {
                    boolean check;
                    do {
                        try {
                            checkLoop(mainMenu.returnFrame());
                            check = false;
                        }
                        catch (Exception ex){
                            if(ex.getMessage().equals("no loop")){
                                throw ex;
                            }
                            mainMenu.errorFrame(ex);
                            check = true;
                        }

                    } while (check);
                }
            }
            case 10->{
                mainMenu.subMenuFrame();
                Scanner sc = new Scanner(System.in);
                int tmp = sc.nextInt();
                try {
                    switch (tmp) {
                        case 1 -> ordersManager.update(mainMenu.addOrderFrame(
                                customersManager.toString(CustomersManager.READ_IN_FILE_PRODUCT),
                                productsManager.toString(ProductsManager.READ_IN_FILE_PRODUCT)
                        ));
                        case 2 -> ordersManager.delete(mainMenu.deleteFrame());
                    }
                }
                catch (Exception e){
                    mainMenu.errorFrame(e);
                }
                finally {
                    boolean check;
                    do {
                        try {
                            checkLoop(mainMenu.returnFrame());
                            check = false;
                        }
                        catch (Exception ex){
                            if(ex.getMessage().equals("no loop")){
                                throw ex;
                            }
                            mainMenu.errorFrame(ex);
                            check = true;
                        }

                    } while (check);
                }
            }
            case 11->{
                try {
                    ordersManager.writeFile();
                    mainMenu.listFrame("Save data to file\"orders.txt\" success.");
                }
                catch (Exception ex){
                    mainMenu.errorFrame(ex);
                }
                finally {
                    boolean check;
                    do {
                        try {
                            checkLoop(mainMenu.returnFrame());
                            check = false;
                        }
                        catch (Exception ex){
                            if(ex.getMessage().equals("no loop")){
                                throw ex;
                            }
                            mainMenu.errorFrame(ex);
                            check = true;
                        }

                    } while (check);
                }
            }
            default -> throw new Exception("no loop");

        }
    }
    private void checkLoop(boolean check) throws Exception {
        if(!check){
            throw new Exception("no loop");
        }
    }
}
