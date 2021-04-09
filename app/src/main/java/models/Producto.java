package models;

public class Producto {
    private String nombre;
    private int codigo;
    private int valor;
    private String iva;
    private String descripcion;
    private String categoria;

    public Producto() {
    }

    public Producto(String nombre, int codigo, int valor, String iva, String descripcion, String categoria) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.valor = valor;
        this.iva = iva;
        this.descripcion = descripcion;
        this.categoria = categoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public String getIva() {
        return iva;
    }

    public void setIva(String iva) {
        this.iva = iva;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
