package org.servlet.login.repositorio;

import org.servlet.login.models.categoria;

import java.sql.SQLException;
import java.util.List;

// esta interfas va a tener todos los metodos de la aplicacion
//listar añadir elimar y buscar por id
//enlasamos todas las clases a este repositorio
// <T> = de tipo generica
public interface repositorio <T>{
//generamos un metodo de tipo list
    List<T> listar() throws SQLException;
    //generamos el metodo por id
    T porId(Integer id) throws SQLException;
    List<categoria> ListarCategoria() throws SQLException;
    void guardar(T t) throws SQLException;
    void actualizar(T t) throws SQLException;
    void eliminar(Integer id) throws SQLException;
    T activar(Integer id) throws SQLException;
    T desactivar(Integer id) throws  SQLException;
}
