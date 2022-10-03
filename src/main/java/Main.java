import datos.DB_Init;
import interfaces_graficas.LogIn;


public class Main {
    
    public static void main(String[] args) {
        LogIn logIn = new LogIn();
        logIn.setVisible(true);
        
        try {
            DB_Init.createTables();
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("caca");
        }
        
        
        

    }


}