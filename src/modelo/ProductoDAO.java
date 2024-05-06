
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class ProductoDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    
    
  public boolean RegistrarProducto(Producto pr) {
        String sql="INSERT INTO producto (codigo, nombre, stock, descripcion, precio, proveedorid) VALUES (?,?,?,?,?,?)";
        try{
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            
            ps.setString(1, pr.getCodigo());
            ps.setString(2, pr.getNombre());
            ps.setInt(   3, pr.getStock());
            ps.setString(4, pr.getDescripcion());
            ps.setDouble(5, pr.getPrecio());
            ps.setInt(   6, pr.getProveedor());
            ps.execute();
            return true;
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.toString()+" Error al registrar producto");
            return false;
        }
    }
  
  public List ListarProducto(){
        List <Producto> Listapr=new ArrayList();
     String sql = "SELECT * FROM producto";
       try{
           con= cn.getConnection();
           ps = con.prepareStatement(sql);
           rs=ps.executeQuery();
           
           while(rs.next()){
               Producto pr=new Producto();
               pr.setId(rs.getInt("id"));
               pr.setCodigo(rs.getString("codigo"));
               pr.setNombre(rs.getString("nombre"));
               pr.setStock(rs.getInt("stock"));
               pr.setDescripcion(rs.getString("descripcion"));
               pr.setPrecio(rs.getDouble("precio"));
               pr.setProveedor(rs.getInt("proveedorid"));
               
               Listapr.add(pr);

           }
           
           
       }catch (SQLException e){
           System.out.println(e.toString());
        
       }
       return Listapr;
    }
  
    public boolean EliminarProducto(int id){
        String sql = "DELETE  FROM producto WHERE id = ?";
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
      
  public boolean ModificarProducto(Producto pr){
        
     String sql="UPDATE producto  SET  codigo=?, nombre=?, stock=?, descripcion=?, precio=?, proveedorid=? WHERE id=?";
        try
        {
           
            ps=con.prepareStatement(sql);
            
            
            ps.setString (1, pr.getCodigo());
            ps.setString(2, pr.getNombre());
            ps.setInt(3, pr.getStock());
            ps.setString(4, pr.getDescripcion());
            ps.setDouble(5,pr.getPrecio());
            ps.setInt(6, pr.getProveedor());
            ps.setInt(7, pr.getId());
            
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
  
public Producto BuscarPr(String cod){
    Producto producto = new Producto();
 String sql = "SELECT * FROM producto WHERE codigo = ?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, cod);
            rs = ps.executeQuery();
            if (rs.next()) {
                producto.setNombre(rs.getString("nombre"));
                producto.setPrecio(rs.getDouble("precio"));
                producto.setStock(rs.getInt("stock"));
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return producto;
    }

public Config BuscarDatos() {
        Config conf = new Config();
        String sql = "SELECT * FROM config";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                conf.setId(rs.getInt("id"));
                conf.setEmpresa(rs.getString("empresa"));
                conf.setNit(rs.getInt("nit"));
                conf.setTelefono(rs.getInt("telefono"));
                conf.setDireccion(rs.getString("direccion"));
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return conf;
    }

 public boolean ModificarDatos(Config conf) {
        String sql = "UPDATE config SET empresa=? ,nit=?, telefono =?, direccion=? WHERE id=?";
        try {
            ps = con.prepareStatement(sql);
            
            ps.setString(1, conf.getEmpresa());
            ps.setInt(2, conf.getNit());
            ps.setInt(3, conf.getTelefono());
            ps.setString(4, conf.getDireccion());
            ps.setInt(5, conf.getId());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                System.out.println(ex.toString());
            }
        }
 }
}

    

