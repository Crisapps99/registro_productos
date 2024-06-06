package org.servlet.login.services;

//import com.sun.jdi.connect.spi.Connection;
import org.servlet.login.models.Producto;
import org.servlet.login.models.categoria;
import org.servlet.login.repositorio.CategoriaRepositoriojdbcImplement;
import org.servlet.login.repositorio.productoRepositoriojdbcImplement;
import org.servlet.login.repositorio.repositorio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;


public class productoServicejdbcImplement implements ProductoService{
    private repositorio<Producto> repositorio;
    private repositorio<categoria> categoriaRepositorio;
    private Connection conn;

    public productoServicejdbcImplement(Connection connection){
        this.repositorio = new productoRepositoriojdbcImplement(connection);
        this.categoriaRepositorio= new CategoriaRepositoriojdbcImplement(connection);
    }

    @Override
    public List<categoria> ListarCategoria() {
        try{
            return categoriaRepositorio.listar();
        }catch(SQLException throwables){
            throw  new ServicejdbcException(throwables.getMessage(),throwables.getCause());
        }
    }
    @Override
    public Optional<Producto> porId(Integer id) {
        try{
            return Optional.ofNullable(repositorio.porId(id));
        }catch (SQLException throwables) {
            throw new ServicejdbcException(throwables.getMessage(),throwables.getCause());
        }
    }

    public Optional<categoria> porIdcategoria(Integer id) {
        try{
            return Optional.ofNullable(categoriaRepositorio.porId(id));
        }catch (SQLException throwables) {
            throw new ServicejdbcException(throwables.getMessage(),throwables.getCause());
        }
    }

    @Override
    public List<Producto> Listar() {
        try{
            return repositorio.listar();
        }catch (SQLException throwables){
            throw new ServicejdbcException(throwables.getMessage(),throwables.getCause());
        }
    }

    @Override
    public void guardar(Producto producto) {

    }

    @Override
    public void eliminar(Integer id) {

    }

    @Override
    public Optional<categoria> buscarCategoria(Integer id) {
        return Optional.empty();
    }
}

