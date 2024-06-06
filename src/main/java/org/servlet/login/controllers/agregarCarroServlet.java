    package org.servlet.login.controllers;

    import jakarta.servlet.ServletException;
    import jakarta.servlet.annotation.WebServlet;
    import jakarta.servlet.http.HttpServlet;
    import jakarta.servlet.http.HttpServletRequest;
    import jakarta.servlet.http.HttpServletResponse;
    import jakarta.servlet.http.HttpSession;
    import org.servlet.login.models.Carro;
    import org.servlet.login.models.Producto;
    import org.servlet.login.models.itemCarro;
    import org.servlet.login.services.ProductoService;
    import org.servlet.login.services.ProductoServiceImplement;
    import org.servlet.login.services.productoServicejdbcImplement;

    import java.sql.Connection;

    import java.io.IOException;
    import java.sql.Connection;
    import java.util.Optional;

    //aqui vamos agregar los items al carro
    @WebServlet("/agregar-carro")
    public class agregarCarroServlet extends HttpServlet {

        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            //primero obtengo el parametro id y lo transformamos a intenger
            Integer idProducto =Integer.parseInt(req.getParameter("id"));
            Connection conn=(Connection) req.getAttribute("conn");
            //creo un nuevo objeto de tipo prodcuto servides
            ProductoService service = new productoServicejdbcImplement(conn);
            //optengo en una variable Oprtional y guardo lo que estoy obteniendo
            Optional<Producto> producto = service.porId(idProducto);
            if (producto.isPresent()){
                //añade y crea elobjeto
                itemCarro item = new itemCarro(1, producto.get());
                //obtenemos la sesion
                HttpSession session=req.getSession();
                //creamos variable de tipo carro
                Carro carro;
                if (session.getAttribute("carro")==null){
                    //creo un nuevo objteo
                    carro=new Carro();
                    //y seteneo el atributo
                    session.setAttribute("carro", carro);
                }else{
                    //si hay algo añadimos lso productos y obtenemos los atributos de la session
                    carro=(Carro) session.getAttribute("carro");
                }
            //añado lso items
                carro.addItemCarro(item);
            }
            //cuadno de clic en añadir al carrito se va a ver carrito
            resp.sendRedirect(req.getContextPath()+"/ver-carro");
        }
    }
