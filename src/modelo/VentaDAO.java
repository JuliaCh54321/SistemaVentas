/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class VentaDAO {




    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    int r;
    
    public int IdVenta(){
        int id = 0;
        String sql = "SELECT MAX(id) FROM venta";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                id = rs.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return id;
    }
    
    public int RegistrarVenta(Venta V){
        String sql = "INSERT INTO venta ( total, vendedorid, clienteid) VALUES (?,?,?)";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setDouble(1, V.getTotal());
            ps.setInt(2, V.getVendedorid());
            ps.setInt(3, V.getClienteid());
            
            ps.execute();
        } catch (SQLException e) {
            System.out.println(e.toString());
        
        }
        return r;
    }
    
     public int RegistrarDetalle(DetalleVenta DV){
        String sql ="INSERT INTO detalleventa(cantidad, precio, productoid, ventaid) VALUES (?,?,?,?)";
        
        try{
            con = cn.getConnection();
            ps= con.prepareStatement(sql);
            ps.setInt(1, DV.getCantidad());
            ps.setDouble(2, DV.getPrecio());
            ps.setInt(3, DV.getProductoid());
            ps.setInt(4, DV.getVentaid());
            ps.setInt(5, DV.getId());
            ps.execute();
        }catch(SQLException e){
            System.out.println(e.toString());
        }finally{
            try{
                con.close();
            }catch(SQLException e){
                System.out.println(e.toString());
            }
        finally{
            try{
                con.close();
            }catch(SQLException e){
                System.out.println(e.toString());
            }
        }
         return r;
    }
     }

   
     public boolean ActualizarStock(int stock, String codigo){
         String sql ="UPDATE producto SET stock = ? WHERE codigo= ?";
         try{
             con = cn.getConnection();
             ps = con.prepareStatement(sql);
             ps.setInt(1, stock);
             ps.setString(2, codigo);
             ps.execute();
             return true;
         }catch(SQLException e){
             return false;
         }
     }
     
     public List ListarVentas() {
        List<Venta> ListarVenta = new ArrayList();
        String sql = "SELECT * FROM venta";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Venta ven = new Venta();
                ven.setId(rs.getInt("id"));
                ven.setTotal(rs.getDouble("total"));
                ven.setVendedorid(rs.getInt("vendedorid"));
                ven.setClienteid(rs.getInt("clienteid"));
                ListarVenta.add(ven);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return ListarVenta;
    }
}



    

