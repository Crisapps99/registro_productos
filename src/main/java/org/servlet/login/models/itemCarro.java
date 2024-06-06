package org.servlet.login.models;

import java.util.Objects;

//este  modelo inicialisa los valores que vamos a ingresar al carrito de compras
//el producto y la cantidad
public class itemCarro {
    //declaramos variables del itemCarro
    //son prodcutos que voy añadir al carrito
    private int cantidad;
    //de tipo producto que estan guardado todos los datos del prodcuto
    private Producto producto;
    public itemCarro(){

    }
    public itemCarro(int cantidad, Producto producto){
        this.cantidad = cantidad;
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
//si en la lista del carrito aparece dos objetos del mismo tipo
    //lo compara y lo pone en una sola y aumentar la cantidad
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        itemCarro itemCarro = (itemCarro) o;
        //aqui obtengo el id del producto y obtengo el item que ingreso y le comparo con el producto
        return Objects.equals(producto.getIdProducto(), itemCarro.producto.getIdProducto())
                && Objects.equals(producto.getNombre(), itemCarro.producto.getNombre());
    }

    @Override
    public int hashCode() {
        return Objects.hash(cantidad, producto);
    }

    public double getImporte(){
        //este metodo obtiene el subtotal
        return cantidad*producto.getPrecio();
    }
}
