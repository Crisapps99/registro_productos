package org.servlet.login.services;

import org.servlet.login.models.Producto;
import org.servlet.login.models.categoria;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ProductoServiceImplement implements ProductoService {
    @Override
    public Optional<Producto> porId(Integer id) {
        return Listar().stream().filter(p-> p.getIdProducto().equals(id)).findAny();
    }

    @Override
    public void guardar(Producto producto) {

    }

    @Override
    public List<categoria> ListarCategoria() {
        return List.of();
    }

    @Override
    public Optional<categoria> buscarCategoria(Integer id) {
        return Optional.empty();
    }

    @Override
    public void eliminar(Integer id) {

    }

    @Override
    //aqui creamos todos los productos
    public List<Producto> Listar(){
    return Arrays.asList();
    }


}
