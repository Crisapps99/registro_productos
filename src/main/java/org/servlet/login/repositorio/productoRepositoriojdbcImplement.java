package org.servlet.login.repositorio;

import org.servlet.login.models.Producto;
import org.servlet.login.models.categoria;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

//esta clase va a interactuar coin la base de datos
public class productoRepositoriojdbcImplement implements repositorio<Producto>{
    //se obtiene la conecion de tipo privado
    private Connection conn;
    //este cosntructor es para tener conecxion a la base de datos
    public productoRepositoriojdbcImplement(Connection conn) {
        this.conn = conn;
    }

    @Override
    public List<Producto> listar() throws SQLException {
        //sobre escribimos el metodo
        List<Producto> productos  = new ArrayList<>();
        //primero perparo la consulta y luego realizo la constula
        try(Statement smt = conn.createStatement();
            ResultSet rs = smt.executeQuery("SELECT articulo.idarticulo,categoria.nombre AS nombre_categoria,articulo.idcategoria,articulo.codigo,articulo.nombre,articulo.stock, articulo.descripcion,articulo.imagen,articulo.condicion,articulo.precio FROM articulo INNER JOIN categoria ON articulo.idcategoria = categoria.idcategoria;")){
            //mientras el resulset tenga datos y si hay tiene que generarme o realizarme un nuevo objeto de tipo producto
            while(rs.next()){
                //aqui traemos lso datos de la tabla producto
                Producto p = getProducto(rs);
                productos.add(p);
            }

        }

        return productos;
    }
    @Override
    public Producto porId(Integer id) throws SQLException {
        Producto producto=null;
        try (PreparedStatement smt = conn.prepareStatement("SELECT  p.*, c.nombre AS categoria FROM articulo AS p INNER JOIN categoria AS c ON p.idcategoria = c.idcategoria WHERE p.idarticulo=?;")){
            //seteamos el id
            smt.setInt(1,id);
            try(ResultSet rs = smt.executeQuery()){
                if (rs.next()) {
                    producto=getProducto(rs);
                }
            }
        }
        return producto;
    }

    @Override
    public void guardar(Producto producto) throws SQLException {
        String sql;
        if(producto.getIdProducto() != null && producto.getIdProducto() > 0) {
            sql = "UPDATE articulo SET codigo=?, nombre=?, stock=?, descripcion=?, imagen=?, condicion=?, precio=?, idcategoria=? WHERE idarticulo=?";
        } else {
            sql = "INSERT INTO articulo(codigo, nombre, stock, descripcion, imagen, condicion, precio, idcategoria) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        }

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, producto.getCodigo());
            stmt.setString(2, producto.getNombre());
            stmt.setInt(3, producto.getStock());
            stmt.setString(4, producto.getDescripcion());
            stmt.setString(5, producto.getImagen());
            stmt.setInt(6, producto.getCondicion());
            stmt.setDouble(7, producto.getPrecio());
            stmt.setInt(8, producto.getCategoria().getIdcategoria());

            if (producto.getIdProducto() != null && producto.getIdProducto() > 0) {
                stmt.setInt(9, producto.getIdProducto());
            }

            stmt.executeUpdate();
            //catch para controlar erroresy exepciones
        }catch (SQLException e){
            //aqui se maneja la excepcion del segistro segun sea necesario
            //imprime el stacktrace para depurar la consulta
            e.printStackTrace();
        }
    }
    @Override
    public void actualizar(Producto producto) throws SQLException {
        String sql;
            sql = "UPDATE articulo SET codigo=?, nombre=?, stock=?, descripcion=?, imagen=?, condicion=?, precio=? WHERE idarticulo=?";


        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, producto.getCodigo());
            stmt.setString(2, producto.getNombre());
            stmt.setInt(3, producto.getStock());
            stmt.setString(4, producto.getDescripcion());
            stmt.setString(5, producto.getImagen());
            stmt.setInt(6, producto.getCondicion());
            stmt.setDouble(7, producto.getPrecio());
            // Establece el ID del producto para la cláusula WHERE
            stmt.setInt(8, producto.getIdProducto());
            stmt.executeUpdate();

        } catch(SQLException e){
            throw new RuntimeException("Error al actualizar el producto con ID " + producto.getIdProducto(), e);
        }
    }
    //meotodo para eliminar un producto
    @Override
    public void eliminar(Integer id) throws SQLException {
        //definimos la consulta para elimianr un producto mediante el id
        String sql="DELETE FROM articulo WHERE idarticulo=?";
        //utilizamos un try para la libreacion de recursos
        try(PreparedStatement stmt = conn.prepareStatement(sql)){
            //establecemos el parametro id
            stmt.setInt(1,id);
            stmt.executeUpdate();
        }
    }

    @Override
    public Producto activar(Integer id) throws SQLException {
        return null;
    }


    @Override
    public Producto desactivar(Integer id) throws SQLException {
        return null;
    }
    //metodo de productos
    private static Producto getProducto(ResultSet rs) throws SQLException {
        //sete los datos de la base de datos
        Producto p = new Producto();
        p.setIdProducto(rs.getInt("idarticulo"));
        p.setCodigo(rs.getInt("codigo"));
        p.setNombre(rs.getString("nombre"));
        p.setDescripcion(rs.getString("descripcion"));
        p.setCondicion(rs.getInt("condicion"));
        p.setStock(rs.getInt("stock"));
        p.setImagen(rs.getString("imagen"));
        p.setPrecio(rs.getInt("precio"));

        categoria c = new categoria();
        c.setIdcategoria(rs.getInt("idcategoria"));
        return p;
    }

    //implementamos este metodo para agregar un oproducto
    public List<categoria> ListarCategoria()  {
        List<categoria> categorias = new ArrayList<>();
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT idcategoria, nombre FROM categoria")) {
            while (rs.next()) {
                categoria c = new categoria();
                c.setIdcategoria(rs.getInt("idcategoria"));
                c.setNombre(rs.getString("nombre"));
                categorias.add(c);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return categorias;
    }
}
