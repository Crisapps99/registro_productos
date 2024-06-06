package org.servlet.login.models;

public class Producto {
    private Integer idProducto;
    private int codigo;
    private String nombre;
    private int condicion;
    private String descripcion;
    private String imagen;
    private int stock;
    private double precio;
    private categoria categoria;

    // Constructor vacío
    public Producto() {
    }

    // Constructor con todos los atributos
    public Producto(Integer idProducto, int codigo, String nombre, int condicion, String descripcion, String imagen, int stock, double precio, categoria categoria) {
        this.idProducto = idProducto;
        this.codigo = codigo;
        this.nombre = nombre;
        this.condicion = condicion;
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.stock = stock;
        this.precio = precio;
        this.categoria = categoria;
    }

    public Producto(int idProducto, int codigo, String nombre, int stock, String descripcion, String imagen, int condicion, int precio) {


    }

    public Producto(int idProducto, int codigo, String nombre, int stock, String descripcion, String imagen, int condicion, double precio) {

    }

    // Getters y setters para todos los atributos
    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCondicion() {
        return condicion;
    }

    public void setCondicion(int condicion) {
        this.condicion = condicion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(categoria categoria) {
        this.categoria = categoria;
    }
}
