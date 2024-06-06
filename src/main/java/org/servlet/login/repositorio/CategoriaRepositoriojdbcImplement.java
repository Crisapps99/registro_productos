package org.servlet.login.repositorio;


import  org.servlet.login.models.categoria;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoriaRepositoriojdbcImplement implements repositorio <categoria>{
    private Connection conn;

    public CategoriaRepositoriojdbcImplement(Connection conn) {
        this.conn = conn;
    }
    @Override
    public List<categoria> listar() throws SQLException {
        List<categoria> Categoria = new ArrayList<>();
        try(Statement stmt = conn.createStatement()){
            ResultSet rs = stmt.executeQuery("select * from categoria ");
            while (rs.next()) {
                categoria cat = getcategoria(rs);
                Categoria.add(cat);
            }
        }
        return Categoria;
    }

    @Override
    public categoria porId(Integer id) throws SQLException {
        categoria Categoria = null;
        try(PreparedStatement stmt = conn.prepareStatement("select * from categoria where idcategoria=?")){
            stmt.setInt(1, id);
            try(ResultSet rs = stmt.executeQuery()){
                if(rs.next()){
                    Categoria = getcategoria(rs);
                }
            }
        }
        return Categoria;
    }

    @Override
    public List<categoria> ListarCategoria() throws SQLException {
        List<categoria> categorias = new ArrayList<>();
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT idcategoria, nombre FROM categoria")) {
            while (rs.next()) {
                categoria c = new categoria();
                c.setIdcategoria(rs.getInt("idcategoria"));
                c.setNombre(rs.getString("nombre"));
                categorias.add(c);
            }
        }
        return categorias;
    }
    @Override
    public void actualizar(categoria categoria) throws SQLException {
        String sql = "UPDATE articulo SET nombre = ? WHERE idarticulo = ?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, categoria.getNombre());
            stmt.setInt(2, categoria.getIdcategoria());
            stmt.executeUpdate();
        }
    }
    @Override
    public void guardar(categoria categoria) throws SQLException {

    }

    @Override
    public void eliminar(Integer id) throws SQLException {

    }

    @Override
    public categoria activar(Integer id) throws SQLException {
        return null;
    }

    @Override
    public categoria desactivar(Integer id) throws SQLException {
        return null;
    }
    private categoria getcategoria(ResultSet rs) throws SQLException {
        categoria categoria = new categoria();
        categoria.setNombre(rs.getString("nombre"));
        categoria.setDescripcion(rs.getString("descripcion"));
        return categoria;
    }
}
