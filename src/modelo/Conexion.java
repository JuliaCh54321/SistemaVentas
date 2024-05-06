
package modelo;
import java.sql.Connection;
import java.sql.DriverManager;




public class Conexion {
   
    Connection con;
    
    public Connection getConnection()
    {
       try{
           String myBD="jdbc:mysql://localhost:3306/sistemaventa1?serverTimezone=UTC";
           con = DriverManager.getConnection(myBD,"root","");
           return con;
       } 
       catch (Exception e){
           System.out.println("Error de conexion bd: " + e.toString());
    }

    return null;
    
}
}
    

