import control.MainManager;
import view.MainMenu;

public class Main {
    public static void main(String[] args) {
        MainMenu mainMenu = new MainMenu();
        MainManager mainManager = null;

        try {
            mainManager = new MainManager(mainMenu);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        while (true) {
            try {
                assert mainManager != null;
                mainManager.control(mainMenu.mainFrame());
            }
            catch (Exception e) {
                if(e.getMessage().equals("no loop")){
                    break;
                }
                else {
                    e.printStackTrace();
                }
            }
        }
    }
}
