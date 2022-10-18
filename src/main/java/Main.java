import datos.DB_Init;
import interfaces_graficas.menus.LogIn;


public class Main {
    
    public static void main(String[] args) {

        try {
            DB_Init.dropAllTables();
            DB_Init.createTables();
            DB_Init.initTables();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            System.out.println(e);
        }
        LogIn logIn = new LogIn();
        logIn.setVisible(true);

    }


}