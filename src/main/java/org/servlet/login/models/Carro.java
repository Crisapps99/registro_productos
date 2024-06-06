package org.servlet.login.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//modelo para que inicialise la lista que compramos al carrito
public class Carro {
    //creamos una variable en el cual inicializamos la lsita
    //de productos comprados que van a estar en el carro
    private List<itemCarro> items;
    //este constructor vacio inicialisa la lista
    public Carro(){
        this.items = new ArrayList<>();
    }
    //implementamos un metodo par añadir lso productos a la lista o carrito
    public void addItemCarro(itemCarro itemCarro){
        //si en el items carro hay un producto se v aa ccionar
        if(items.contains(itemCarro)){
            Optional<itemCarro> OptionalitemCarro = items.stream()
                    .filter(i-> i.equals(itemCarro))
                    .findAny();
            //condicion apra verificar si la variable se encuentra ya dentro del item carro
            //obtiene el id y suma la cantidad y no muestra el articulo repetido sino sumado
            if (OptionalitemCarro.isPresent()){
                itemCarro i = OptionalitemCarro.get();
                i.setCantidad(i.getCantidad()+1);
            }
        }else{
            //si ya esta algun dato del carro se va aañadiendo ala lista
            this.items.add(itemCarro);
        }
    }
    //listamos todos los objetos que añadimos al carro
    public List<itemCarro> getItems(){
        return items;
    }
    //aqui obtenemos el total de la compra
    //si ya obtenemos todos los items
    //summa lso items y dice que coja los datos lo mapete y convierta a doble
    //trae el subtotal y lo suma de uno a uno
    public double getTotal(){
        return items.stream().mapToDouble(itemCarro::getImporte).sum();
    }
}
