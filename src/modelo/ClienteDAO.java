
package modelo;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane; 


public class ClienteDAO {
    Conexion cn= new  Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    
    public  boolean registrarCliente(Cliente cl){
        String sql= "INSERT INTO  cliente( ci, nombre, direccion, telefono) VALUES (?, ?, ?, ?)";
        try{
            con= cn.getConnection();
            ps= con.prepareStatement(sql);
            
         
            ps.setInt(1, cl.getCi());
            ps.setString(2, cl.getNombre());
            ps.setString(3, cl.getDireccion());
            ps.setInt(4, cl.getTelefono());
            ps.execute();
            return true;
            
    }catch (SQLException e){
        JOptionPane.showMessageDialog(null, e.toString());
        return false ;
        
        
    }finally{
            try{
                
            con.close();
            
            }catch(SQLException e){
                    System.out.println(e.toString());

         
     }
    }
            
  } 
    
    public List ListarCliente(){
       List<Cliente> ListaCl = new ArrayList();
       String sql = "SELECT * FROM cliente";
       try{
           con= cn.getConnection();
           ps = con.prepareStatement(sql);
           rs=ps.executeQuery();
           while(rs.next()){
               Cliente cl=new Cliente();
               
               cl.setId(rs.getInt("id"));
               cl.setCi(rs.getInt("ci"));
               cl.setNombre(rs.getString("nombre"));
               cl.setDireccion(rs.getString("direccion"));
               cl.setTelefono(rs.getInt("telefono"));
               
               
               ListaCl.add(cl);

           }
           
           
       }catch (SQLException e){
           System.out.println(e.toString());
        
       }
       return ListaCl;
    }
    
    public boolean EliminarCliente(int id){
        String sql = "DELETE  FROM cliente WHERE id = ?";
        try{
            ps= con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
            return true;
            
        }catch (SQLException e) {
            System.out.println(e.toString());
            return false;
            
        }finally {
            try {
                con.close();
            } catch (SQLException ex) {
                System.out.println(ex.toString());
            }
        }
    }
    
    public boolean ModificarCliente(Cliente cl){
        String sql="UPDATE cliente  SET  ci=?, nombre=?, direccion=?, telefono=? WHERE id=?";
        try
        {
        ps=con.prepareStatement(sql);
           
            ps.setInt(1, cl.getCi());
            ps.setString(2, cl.getNombre());
            ps.setString(3, cl.getDireccion());
            ps.setInt(4, cl.getTelefono());
            ps.setInt(5, cl.getId());
            
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
    
      public Cliente Buscarcliente(int ci){
       Cliente cl=new Cliente();
       String sql = "SELECT * FROM cliente WHERE ci = ?";
       try {
           con = cn.getConnection();
           ps = con.prepareStatement(sql);
           ps.setInt(1,ci);
           rs = ps.executeQuery();
           if (rs.next()) {
               
               cl.setNombre(rs.getString("nombre"));
               cl.setTelefono(rs.getInt("telefono"));
               cl.setDireccion(rs.getString("direccion"));
           }
       } catch (SQLException e) {
           System.out.println(e.toString());
       }
       return cl;
   }
}
    

    


