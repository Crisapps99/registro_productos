<%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 13/6/2024
  Time: 9:34
  To change this template use File | Settings | File Templates.
importamos la libreria de modelos
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" import="org.servlet.login.models.*" %>
<%--obtenemos la sesion enforma de vector y transfomr o a tipo carro --%>
<% Carro carro = (Carro)session.getAttribute("carro");%>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <link rel="stylesheet" href="vistas/stilos/stiloscarritoser.css"> >
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
                    <a class="nav-link text-white fs-5" href="/login_war_exploded/productos">Carrito de compras</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link text-white fs-5" href="/login_war_exploded/ver-carro" >Ver Carro</a>
                </li>
                <li class="nav-item dropdown ">
                    <a class="nav-link dropdown-toggle text-white  fs-5" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                        Perfil
                    </a>
                    <ul class="dropdown-menu navbar-light bg-transparent">
                        <li><a class="dropdown-item text-white" href="/login_war_exploded/Servletlogin">Iniciar Session</a></li>
                        <li><hr class="dropdown-divider"></li>
                        <li><a class="dropdown-item text-white" href="/login_war_exploded/logouth">Cerrar Session</a></li>

                    </ul>
                </li>

            </ul>

        </div>
    </div>
</nav>
<div class="form">
    <div class="title">

    </div>
    <div class="container">
        <div class="factura">
            <h1>Factura</h1>
            <%--verificamos si esta logeado --%>
            <%
                if (carro==null || carro.getItems().isEmpty()){
            %>
            <p>No se agregado ningun producto¡</p>
                <a class="btn" style="width: 50%" href="<%=request.getContextPath()%>/productos">Comprar</a>
            <%
            }else {
            %>

            <table>

                <tr>
                    <th>ID PRODUCTO</th>
                    <th>CODIGO</th>
                    <th>NOMBRE</th>
                    <th>PRECIO</th>
                    <th>CANTIDAD</th>
                    <th>SUBTOTAL</th>
                </tr>

                <%
                    //de la variable item carro me trae todos los items
                    for(itemCarro item : carro.getItems()){%>
                <tr>
                    <td><%=item.getProducto().getIdProducto()%></td>
                    <td><%=item.getProducto().getCodigo()%></td>
                    <td><%=item.getProducto().getNombre()%></td>
                    <td><%=item.getProducto().getPrecio()%></td>
                    <td><%=item.getCantidad()%></td>
                    <td>$<%=item.getImporte()%></td>

                </tr>
                <%}%>
                <tr>
                    <td content="4"> total :</td>
                    <td>$<%=carro.getTotal()%></td>
                </tr>
            </table>
            <a class="btn" style="width: 50%" href="<%=request.getContextPath()%>/productos">Seguir comprando </a>
            <a class="btn" style="width: 50%" href="<%=request.getContextPath()%>/vistas/user/user.jsp">volver</a>
            <%
                }
            %>
        </div>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>

</body>
</html>
