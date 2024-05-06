
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class ProveedorDAO {
    Connection con;
    Conexion cn = new  Conexion();
    PreparedStatement ps;
    ResultSet rs;
    
    
    public  boolean registrarProveedor(Proveedor pro){
        String sql="INSERT INTO  proveedor(  nit, nombre,telefono, direccion )VALUES (?, ?, ?, ?)";
        try{
            
            con= cn.getConnection();
            ps= con.prepareStatement(sql);
            ps.setInt   (1, pro.getNit());
            ps.setString(2, pro.getNombre());
            ps.setInt(3, pro.getTelefono());
            ps.setString  (4, pro.getDireccion());
            
       
            ps.execute();
            return true;
            
    }catch (SQLException e){
        
        System.out.println( e.toString());
        
        return false ;
        
        
    }finally{
            try{
                
            con.close();
            
            }catch(SQLException e){
                System.out.println(e.toString());
            }
            
        } 
    
}
    
    public List ListarProveedor(){
        List <Proveedor> Listapro=new ArrayList();
     String sql = "SELECT * FROM proveedor";
       try{
           con= cn.getConnection();
           ps = con.prepareStatement(sql);
           rs=ps.executeQuery();
           
           while(rs.next()){
               Proveedor pro=new Proveedor();
               pro.setId(rs.getInt("id"));
               pro.setNit(rs.getInt("nit"));
               pro.setNombre(rs.getString("nombre"));
               pro.setTelefono(rs.getInt("telefono"));
               pro.setDireccion(rs.getString("direccion"));
               
               Listapro.add(pro);

           }
           
           
       }catch (SQLException e){
           System.out.println(e.toString());
        
       }
       return Listapro;
    }
    
    public boolean EliminarProveedor(int id){
        String sql = "DELETE  FROM proveedor WHERE id = ?";
        try{
            con=cn.getConnection();
            ps= con.prepareStatement(sql);
            ps.setInt(1, id );
            
            ps.execute();
            return true;
            
        }catch (SQLException e) {
            System.out.println(e.toString());
            return false;
            
        }finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
        }
    }
    
    public boolean ModificarProveedor(Proveedor pro){
        
     String sql="UPDATE proveedor  SET  nit=?, nombre=?, telefono=?, direccion=? WHERE id=?";
        try
        {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            
            
            ps.setInt(1, pro.getNit());
            ps.setString(2, pro.getNombre());
            ps.setInt(3, pro.getTelefono());
            ps.setString(4, pro.getDireccion());
            ps.setInt(5, pro.getId());
            
            ps.execute();
            return true;
            
        }catch(SQLException e){
            System.out.println(e.toString());
            return false;
       
        }finally {
            try{
                con.close();
                
            }catch(SQLException e){
                
                System.out.println(e.toString());
            }
        }
    }

}
