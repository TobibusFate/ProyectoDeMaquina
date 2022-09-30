import datos.DB_Init;
import datos.DatosBase;

public class Main {
    public static void main(String[] args) {
        System.out.println("HOla me llamo celso");
        System.out.println("HOla me llamo fernandez");
        try {
            DB_Init.createTables();
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("caca");
        }

    }


}