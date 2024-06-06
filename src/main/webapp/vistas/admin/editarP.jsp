<%@ page import="org.servlet.login.models.Producto" %>
<%@ page import="java.util.Map" %>
<%@ page import="org.servlet.login.models.categoria" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 25/6/2024
  Time: 22:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    List<categoria> categorias = (List<categoria>) request.getAttribute("categorias");
    Map<String, String> errores = (Map<String, String>) request.getAttribute("errores");
    Producto producto = (Producto) request.getAttribute("producto");
%>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <link rel="stylesheet" href="vistas/stilos/stiloseditar.css">

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

            </ul>

        </div>
    </div>
</nav>
<main>
    <div class="contenedor__login-register">
        <!-- sformulario del registro  -->
        <form action="${pageContext.request.contextPath}/actualizar" method="post" class="formulario__registro">
            <h2 >Actualizar Producto</h2>
            <label for="id">ID:</label>
            <input type="number" name="id" id="id" value="${producto.idProducto}">

            <label for="codigo">Código:</label>
            <input type="number" name="codigo" id="codigo" value="${producto.codigo}">

            <br>
            <label for="nombre">Nombre:</label>
            <input type="text" id="nombre" name="nombre" value="${producto.nombre}" required>

            <label for="stock">Stock:</label>
            <input type="text" id="stock" name="stock" value="${producto.stock}" required>

            <label for="descripcion">Descripcion:</label>
            <textarea id="descripcion" name="descripcion" required>${producto.descripcion}</textarea>

            <label for="imagen">imagen:</label>
            <input type="text" id="imagen" name="imagen" value="${producto.imagen}" >
            <br>
            <label for="condicion">Condicion:</label>
            <input type="text" id="condicion" name="condicion" value="${producto.condicion}" required>

            <label for="precio">$Precio:</label>
            <input type="text" id="precio" name="precio" value="${producto.precio}"  required>

            <br>
            <br>
            <input style="cursor: pointer;box-shadow: 0 0 5px black" type="submit" name="accion" value="${producto.idProducto != null && producto.idProducto > 0 ? "Editar" : "Crear"}">
            <input type="hidden" name="id" value="${producto.idProducto}">
           <br>

        </form>
    </div>
</main>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>
