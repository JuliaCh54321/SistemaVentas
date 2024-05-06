
package modelo;


public class ComboBox {
    private int id;
    private String valor;

    public ComboBox(int id, String valor) {
        this.id = id;
        this.valor = valor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
    @Override
  public String toString ()
  {
      return this.getValor();
  }
    
}
