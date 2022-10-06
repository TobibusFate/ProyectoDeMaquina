package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class DB_BasicQuerys {

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


    public static ResultSet findTuple(List<String> keyNames, List<String> keyValues, String tableName, Connection conn) {
        try {
            ResultSet rs = null;

            if (keyValues != null && keyNames != null) { 
                if (conn == null) throw new SQLException("Connection error");
                if (keyNames.isEmpty() || keyValues.isEmpty()) throw new SQLException("Missing attribute/values");
                if (keyValues.size() != keyNames.size()) throw new SQLException("Not matching key quantities");

                String query = "SELECT * FROM "+tableName+" WHERE "+keyNames.get(0)+" = ";
                switch (matchesType(keyValues.get(0))) {
                    case 1: query += Integer.parseInt(keyValues.get(0)); break;
                    case 2: query += Long.parseLong(keyValues.get(0)); break;
                    case 3: query += Float.parseFloat(keyValues.get(0)); break;
                    case 4: query += Double.parseDouble(keyValues.get(0)); break;
                    case 0: query += "'"+keyValues.get(0)+"'"; break;
                }

                for (int i = 1; i < keyValues.size(); i++) {
                    query += " AND "+keyNames.get(i)+" = ";
                    switch (matchesType(keyValues.get(i))) {
                        case 1: query += Integer.parseInt(keyValues.get(i)); break;
                        case 2: query += Long.parseLong(keyValues.get(i)); break;
                        case 3: query += Float.parseFloat(keyValues.get(i)); break;
                        case 4: query += Double.parseDouble(keyValues.get(i)); break;
                        case 0: query += "'"+keyValues.get(i)+"'"; break;
                    }
                }

                if (tupleExists(query, conn)) {
                    String query_return = "SELECT * FROM "+tableName+" WHERE "+keyNames.get(0)+" = ?";
                    for (int i = 1; i < keyNames.size(); i++) {
                        query_return += " AND "+keyNames.get(i)+" = ?";
                    }

                    PreparedStatement p_query = conn.prepareStatement(query_return);

                    for (int i = 0; i < keyValues.size(); i++) {
                        switch (matchesType(keyValues.get(i))) {
                            case 1: p_query.setInt((i+1), Integer.parseInt(keyValues.get(i)));; break;
                            case 2: p_query.setLong((i+1), Long.parseLong(keyValues.get(i))); break;
                            case 3: p_query.setFloat((i+1), Float.parseFloat(keyValues.get(i))); break;
                            case 4: p_query.setDouble((i+1), Double.parseDouble(keyValues.get(i))); break;
                            case 0: p_query.setString((i+1), keyValues.get(i)); break;
                        }
                    }
                    rs = p_query.executeQuery();

                    return rs;
                }
            }
            else {
                Statement s_query = conn.createStatement();
                rs = s_query.executeQuery("SELECT * FROM "+tableName);
                return rs;
            }

        } catch (SQLException ex) {
            return null;
        }
        return null;
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

            switch (matchesType(newValue)) {
                case 1: p_query.setInt(1, Integer.parseInt(newValue)); break;
                case 2: p_query.setLong(1, Long.parseLong(newValue)); break;
                case 3: p_query.setFloat(1, Float.parseFloat(newValue)); break;
                case 4: p_query.setDouble(1, Double.parseDouble(newValue)); break;
                case 5: //TODO: SetDate
                    ; break;
                case 0: p_query.setString(1, newValue); break;
            }

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

            String query = "SELECT * FROM "+tableName+" WHERE "+keyNames.get(0)+" = ";
            
            
            
            switch (matchesType(attributeValues.get(0))) {
                case 1: query += Integer.parseInt(attributeValues.get(0)); break;
                case 2: query += Long.parseLong(attributeValues.get(0)); break;
                case 3: query += Float.parseFloat(attributeValues.get(0)); break;
                case 4: query += Double.parseDouble(attributeValues.get(0)); break;
                case 0: query += "'"+attributeValues.get(0)+"'"; break;
            }

            for (int i = 1; i < keyNames.size(); i++) {
                query += " AND "+keyNames.get(i)+" = ";
                
                switch (matchesType(attributeValues.get(i))) {
                    case 1: query += Integer.parseInt(attributeValues.get(i)); break;
                    case 2: query += Long.parseLong(attributeValues.get(i)); break;
                    case 3: query += Float.parseFloat(attributeValues.get(i)); break;
                    case 4: query += Double.parseDouble(attributeValues.get(i)); break;
                    case 0: {
                        String[] str = isEnumType(attributeValues.get(i));
                        if (str == null) query += "'"+attributeValues.get(i)+"'";
                        else query += "'"+str[0]+"'";
                        
                    }; break;
                }
            }

            if (!tupleExists(query, conn)) {
                String[] str;
                String insert_query = "INSERT INTO "+tableName+" VALUES (?";
                for (int i = 1; i < attributeValues.size(); i++) {
                    str = isEnumType(attributeValues.get(i)); 
                    if (str == null) insert_query += ", ?";
                    else insert_query += ", ?::"+str[1];
                }
                insert_query += ")";

                PreparedStatement p_query = conn.prepareStatement(insert_query);

                for (int i = 0; i < attributeValues.size(); i++) {
                    str = isEnumType(attributeValues.get(i));
                    switch (matchesType(attributeValues.get(i))) {
                        case 1: p_query.setInt((i+1), Integer.parseInt(attributeValues.get(i)));; break;
                        case 2: p_query.setLong((i+1), Long.parseLong(attributeValues.get(i))); break;
                        case 3: p_query.setFloat((i+1), Float.parseFloat(attributeValues.get(i))); break;
                        case 4: p_query.setDouble((i+1), Double.parseDouble(attributeValues.get(i))); break;
                        case 5: p_query.setDate((i+1), java.sql.Date.valueOf(attributeValues.get(i))); break;
                        case 0: {
                            if (str == null) p_query.setString((i+1), attributeValues.get(i));
                            else p_query.setString((i+1), str[0]);
                            
                        } break;
                    }
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

    public static boolean deleteTuple(List<String> keyNames, List<String> keyValues, String tableName, Connection conn) {
        // keys es la lista de las primary keys de la tupla a eliminar, y keyNames los nombres de los atributos de esas keys. 
        try {
            if (conn == null) throw new SQLException("Connection error");
            if (keyValues.isEmpty() || keyNames.isEmpty()) throw new SQLException("Missing keys");
            if (keyValues.size() != keyNames.size()) throw new SQLException("Not matching key quantities");


            String query = "SELECT * FROM "+tableName+" WHERE "+keyNames.get(0)+" = ";
            switch (matchesType(keyValues.get(0))) {
                case 1: query += Integer.parseInt(keyValues.get(0)); break;
                case 2: query += Long.parseLong(keyValues.get(0)); break;
                case 3: query += Float.parseFloat(keyValues.get(0)); break;
                case 4: query += Double.parseDouble(keyValues.get(0)); break;
                case 0: query += "'"+keyValues.get(0)+"'"; break;
            }

            for (int i = 1; i < keyValues.size(); i++) {
                query += " AND "+keyNames.get(i)+" = ";
                switch (matchesType(keyValues.get(i))) {
                    case 1: query += Integer.parseInt(keyValues.get(i)); break;
                    case 2: query += Long.parseLong(keyValues.get(i)); break;
                    case 3: query += Float.parseFloat(keyValues.get(i)); break;
                    case 4: query += Double.parseDouble(keyValues.get(i)); break;
                    case 0: query += "'"+keyValues.get(i)+"'"; break;
                }
            }
            
            if (tupleExists(query, conn)) {
                String query_delete = "DELETE FROM "+tableName+" WHERE "+keyNames.get(0)+" = ?";
                for (int i = 1; i < keyNames.size(); i++) {
                    query_delete += " AND "+keyNames.get(i)+" = ?";
                }

                PreparedStatement p_query = conn.prepareStatement(query_delete);

                for (int i = 0; i < keyValues.size(); i++) {
                    switch (matchesType(keyValues.get(i))) {
                        case 1: p_query.setInt((i+1), Integer.parseInt(keyValues.get(i)));; break;
                        case 2: p_query.setLong((i+1), Long.parseLong(keyValues.get(i))); break;
                        case 3: p_query.setFloat((i+1), Float.parseFloat(keyValues.get(i))); break;
                        case 4: p_query.setDouble((i+1), Double.parseDouble(keyValues.get(i))); break;
                        case 0: p_query.setString((i+1), keyValues.get(i)); break;
                    }
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

    public static int matchesType(String s) {
        if (s.matches("\\d{1,8}")) return 1; // int
        else if (s.matches("\\d+")) return 2; // long
        else if (s.matches("\\d{1,8}\\.\\d{1,8}")) return 3; // float
        else if (s.matches("\\d+\\.\\d+")) return 4; // double
        else if (s.matches("\\d{2,4}\\-\\d{2}\\-\\d{2,4}")) return 5; // date
        return 0; // string
    }
    
    public static String[] isEnumType(String s) {
        String[] str = s.split("[:]{2}",2);
        
        if (str.length>1) return str;
        else return null;
    }

}