/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author PC_OFERTAS
 */
public class DetalleVenta {
    private int id;
    private int codPro;
    private int cantidad;
    private double precio;
    private int productoid;
    private int ventaid;

    public DetalleVenta() {
    }

    public DetalleVenta(int id, int codPro, int cantidad, double precio, int productoid, int ventaid) {
        this.id = id;
        this.codPro = codPro;
        this.cantidad = cantidad;
        this.precio = precio;
        this.productoid = productoid;
        this.ventaid = ventaid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCodPro() {
        return codPro;
    }

    public void setCodPro(int codPro) {
        this.codPro = codPro;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getProductoid() {
        return productoid;
    }

    public void setProductoid(int productoid) {
        this.productoid = productoid;
    }

    public int getVentaid() {
        return ventaid;
    }

    public void setVentaid(int ventaid) {
        this.ventaid = ventaid;
    }
    
    
    


    
}
