
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class LoginDAO {
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Conexion cn=new Conexion();
    
    public Login Loggear(String correo,String pass)
    {
        
        Login login=new Login();
        String sql ="SELECT * FROM usuario WHERE correo=? AND pass=? ";
                try{
                    con=cn.getConnection();
                    ps=con.prepareStatement(sql);
                    ps.setString(1, correo);
                    ps.setString(2, pass);
                   rs= ps.executeQuery();
                   if(rs.next())
                   {
                       //atributos de la base de datos
                       login.setId(rs.getInt("id"));
                       login.setNombres(rs.getString("nombre"));
                       login.setCorreo(rs.getString("correo"));
                       login.setApellidos(rs.getString("Apellidos"));
                       login.setPass(rs.getString("pass"));
                       
                   }
                }
        catch(SQLException e)
        {
            System.out.println("error de consulta login "+ e.toString());
            
        }
                return login;
        
    }
    
    
}
