import datos.DB_Init;
import datos.dao.implementation.DAO_Venta;
import interfaces_graficas.LogIn;
import objects.Venta;


public class Main {
    
    public static void main(String[] args) {
        LogIn logIn = new LogIn();
        logIn.setVisible(true);

        try {
            DB_Init.dropAllTables();
            DB_Init.createTables();
            DB_Init.initTables();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            System.out.println(e);
        }

    }


}