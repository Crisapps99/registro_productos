<%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 19/6/2024
  Time: 8:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Factura</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <link rel="stylesheet" href="vistas/stilos/estilosP.css">
</head>
<body>
<nav class="navbar navbar-expand-lg  navbar-light bg-transparent ">
    <div class="container-fluid">
        <a class="navbar-brand text-white" >Skrapy dj </a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse justify-content-end"  id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">

                <li class="nav-item">
                    <a class="nav-link text-white fs-5" href="/login_war_exploded/productosadmin">Productos</a>
                </li>
                <li class="nav-item dropdown ">
                    <a class="nav-link dropdown-toggle text-white  fs-5" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                        Perfil
                    </a>
                    <ul class="dropdown-menu navbar-light bg-transparent">
                        <li><hr class="dropdown-divider"></li>
                        <li><a class="dropdown-item text-white" href="/login_war_exploded/logouth">Cerrar Session</a></li>

                    </ul>
                </li>
                <li class="nav-item">
                    <a class="nav-link disabled" aria-disabled="true">Disabled</a>
                </li>
            </ul>

        </div>
    </div>
</nav>

        <div class="form">
            <div class="title">
                <h2><label style="text-align: center;">Administracion de Productos </label></h2>
                <a  class="btn" href="<%=request.getContextPath()%>/formulario">Agregar producto</a>
            </div>
            <div class='container'>
                <div class='factura'>
                    <h1>Factura</h1>
                    <table>
                        <tr>
                            <th>ID Producto</th>
                            <th>Código</th>
                            <th>Nombre</th>
                            <th>Stock</th>
                            <th>Descripción</th>
                            <th>Imagen</th>
                            <th>Condición</th>
                            <th>Precio</th>
                            <th>Acción</th>
                            <th>Acción</th>
                        </tr>
                        <c:forEach var="p" items="${productos}">
                            <tr>
                                <td>${p.idProducto}</td>
                                <td>${p.codigo}</td>
                                <td>${p.nombre}</td>
                                <td>${p.stock}</td>
                                <td>${p.descripcion}</td>
                                <td>Cargando..</td>
                                <td>${p.condicion}</td>
                                <td>$${p.precio}</td>
                                <td><a  class="btn" style="width: 100%" href="${pageContext.request.contextPath}/actualizar?id=${p.idProducto}" >editar </a></td>

                                <!-- //para eliminar creamos un form-->
                                <form  action="${pageContext.request.contextPath}/eliminarP" method="post">
                                 <!--   //creamos un input de tipo hidden para contener el id del producto que se va a eliminar-->
                                    <input class="btn" type="hidden" name="id" id="id" value="${p.idProducto}">
                                    <!-- creamos un boton de tipo submit para activar el formulario al momento de dar clic-->
                                  <td><button class="btn"  style="width: 100%" type="submit" onclick="return confirm('estas seguro que quieres elimianr el prdocto')">eliminar</button></td>

                                </form>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
                <a class="btn" href="<%=request.getContextPath()%>/vistas/admin/admin.jsp">Retroceder</a>
            </div>
        </div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>

