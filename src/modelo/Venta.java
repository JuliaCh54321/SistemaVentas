
package modelo;


public class Venta {
    private int id;
    private double total;
    private int vendedorid;
    private int clienteid;

    public Venta() {
    }

    public Venta(int id, double total, int vendedorid, int clienteid) {
        this.id = id;
        this.total = total;
        this.vendedorid = vendedorid;
        this.clienteid = clienteid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getVendedorid() {
        return vendedorid;
    }

    public void setVendedorid(int vendedorid) {
        this.vendedorid = vendedorid;
    }

    public int getClienteid() {
        return clienteid;
    }

    public void setClienteid(int clienteid) {
        this.clienteid = clienteid;
    }
    
   

   
}
