package org.servlet.login.services;

import org.servlet.login.models.Producto;
import org.servlet.login.models.categoria;

import java.util.List;
import java.util.Optional;

//interfas es una plantilla
public interface ProductoService {
    //listar productos
    List<Producto> Listar();
    //implementamos un metodo para obtener el producto por id
    //busca un producto por el id
    Optional<Producto>porId(Integer id);
    //implementamos un metodo para guardar
    void guardar (Producto producto);

    //implementamos un metodo para eliminar
    void eliminar(Integer id);
    List<categoria> ListarCategoria();
    //implementamos un metodo par obtener el ide de la categoria
    Optional<categoria> buscarCategoria(Integer id);
}
