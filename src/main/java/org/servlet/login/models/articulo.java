package org.servlet.login.models;

public class articulo {
    private Integer idarticulo;
    private categoria idcategoria;
    private int codigo;
    private String nombre;
    private int stock;
    private String descripcion;
    private int condicion;
    private String imagen;
    private double precio;

    public articulo() {}
    public articulo(Integer idarticulo,categoria categoria,int codigo, String nombre, int stock, String descripcion, int condicion, String imagen, double precio){
        this.idarticulo = idarticulo;
        this.idcategoria = categoria;
        this.codigo = codigo;
        this.nombre = nombre;
        this.stock = stock;
        this.descripcion = descripcion;
        this.condicion = condicion;
        this.imagen = imagen;
        this.precio = precio;
    }

    public Integer getIdarticulo() {
        return idarticulo;
    }

    public void setIdarticulo(Integer idarticulo) {
        this.idarticulo = idarticulo;
    }

    public categoria getIdcategoria() {
        return idcategoria;
    }

    public void setIdcategoria(categoria idcategoria) {
        this.idcategoria = idcategoria;
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

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCondicion() {
        return condicion;
    }

    public void setCondicion(int condicion) {
        this.condicion = condicion;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
