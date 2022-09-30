package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;


public class DB_BasicQuerys {

    private static DB_BasicQuerys instance;

    private DB_BasicQuerys() {
        // Empty Constructor
    }

    public static DB_BasicQuerys getInstance() {
        if (instance == null) instance = new DB_BasicQuerys();
        return instance;
    }

    // A partir de una query: "select * from table where cod = x"
    // retorna true si existe, false si no. Se puede usar al querer dar de baja una tupla, primero hacer un if (!tupleExists(...)).
    // nota: como usa createStatement, no permitir que el usuario la use, puede generar problemas de seguridad.
    public static boolean tupleExists(String query, Connection conn) {
        try {
            Statement statement = conn.createStatement();
            ResultSet resul = statement.executeQuery(query);
            return resul.next();
        } catch (SQLException ex) {
            return false;
        }
    }

    // retorna true si actualizó el valor de las tuplas, o false si hubo un error.
    public static boolean updateTuple(String attribute, String newValue, String condition, String tableName, Connection conn) {
        // nombre del atributo a modificar, el nuevo valor, la condicion (ej: codigo = x) y el nombre de la tabla a la que pertenece
        try {
            if (conn == null) throw new SQLException("Connection error");
            if (attribute.isEmpty() || newValue.isEmpty()) throw new SQLException("Missing attribute/values");


            PreparedStatement p_query = null;

            if (condition.isEmpty()) p_query = conn.prepareStatement("UPDATE "+tableName+" SET "+attribute+" = ?"); // actualiza a toda la tabla
            else p_query = conn.prepareStatement("UPDATE "+tableName+" SET "+attribute+" = ? WHERE "+condition); // actualiza tuplas que cumplan condition


            if (newValue.matches("\\d+")) p_query.setInt(1, Integer.parseInt(newValue));
            else if (newValue.matches("\\d+\\.\\d+")) p_query.setFloat(1, Float.parseFloat(newValue));
            else p_query.setString(1, newValue);

            p_query.executeUpdate();

            return true;

        } catch (SQLException ex) {
            //ex.printStackTrace();
            System.out.println(ex.getMessage());
            return false;
        }
    }

    public static boolean insertTuple(List<String> keyNames, List<String> attributeValues, String tableName, Connection conn) {
        // keyNames son los nombres de las primary keys de la tupla, attributeValues los valores de la tupla (incluyendo las primary keys)
        // Es primordial que en la definición de tablas, las primary keys estén primero, es decir, que coincida el orden de las keyNames
        // con los primeros valores de attributeValues.
        try {
            if (conn == null) throw new SQLException("Connection error");
            if (keyNames.isEmpty() || attributeValues.isEmpty()) throw new SQLException("Missing attributes/columns");
            if (keyNames.size() != attributeValues.size()) throw new SQLException("Not matching attributes quantities");

            String query = "SELECT * FROM "+tableName+" WHERE "+keyNames.get(0)+" = "+Integer.parseUnsignedInt(attributeValues.get(0));
            for (int i = 1; i < keyNames.size(); i++) {
                query += " AND "+keyNames.get(i)+" = "+Integer.parseUnsignedInt(attributeValues.get(i));
            }

            if (!tupleExists(query, conn)) {
                String insert_query = "INSERT INTO "+tableName+" VALUES (?";
                for (int i = 1; i < attributeValues.size(); i++) {
                    insert_query += ", ?";
                }
                insert_query += ")";

                PreparedStatement p_query = conn.prepareStatement(insert_query);

                p_query.setInt(1, Integer.parseUnsignedInt(attributeValues.get(0)));
                for (int i = 1; i < attributeValues.size(); i++) {
                    if (attributeValues.get(i).matches("\\d+")) p_query.setInt((i+1), Integer.parseUnsignedInt(attributeValues.get(i)));
                    else if (attributeValues.get(i).matches("\\d+\\.\\d+")) p_query.setFloat((i+1), Float.parseFloat(attributeValues.get(i)));
                    else p_query.setString((i+1), attributeValues.get(i));
                }

                p_query.executeUpdate();
                return true;
            }
            else return false;


        } catch (SQLException ex) {
            //ex.printStackTrace();
            System.out.println(ex.getMessage());
            return false;
        }
    }

    public static boolean deleteTuple(List<Integer> keys, List<String> keyNames, String tableName, Connection conn) {
        // keys es la lista de las primary keys de la tupla a eliminar, y keyNames los nombres de los atributos de esas keys. 
        try {
            if (conn == null) throw new SQLException("Connection error");
            if (keys.isEmpty() || keyNames.isEmpty()) throw new SQLException("Missing keys");
            if (keys.size() != keyNames.size()) throw new SQLException("Not matching key quantities");


            String query = "SELECT * FROM "+tableName+" WHERE "+keyNames.get(0)+" = "+keys.get(0);
            for (int i = 1; i < keys.size(); i++) {
                query += " AND "+keyNames.get(i)+" = "+keys.get(i);
            }
            
            if (tupleExists(query, conn)) {
                String query_delete = "DELETE FROM "+tableName+" WHERE "+keyNames.get(0)+" = ?";
                for (int i = 1; i < keyNames.size(); i++) {
                    query_delete += " AND "+keyNames.get(i)+" = ?";
                }

                PreparedStatement p_query = conn.prepareStatement(query_delete);

                p_query.setInt(1, keys.get(0));
                for (int i = 1; i < keys.size(); i++) {
                    p_query.setInt((i+1), keys.get(i));
                }


                p_query.executeUpdate();
                
                return true;
            }
            else return false;

        } catch (SQLException ex) {
            //ex.printStackTrace();
            System.out.println(ex.getMessage());
            return false;
        }
    }

}