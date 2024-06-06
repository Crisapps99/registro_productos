<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.*, org.servlet.login.models.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    List<categoria> categorias = (List<categoria>) request.getAttribute("categorias");
    Map<String, String> errores = (Map<String, String>) request.getAttribute("errores");
    Producto producto = (Producto) request.getAttribute("producto");
%>
<html>
<head>
    <title>Crear Producto</title>
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
        <form action="${pageContext.request.contextPath}/formulario" method="post">
            <div class="container">
                <h2>Crear Producto</h2>
                <label for="nombre">Nombre:</label>
                <input type="text" id="nombre" name="nombre" value="${producto.nombre}">
                <c:if test="${errores.nombre != null}">
                    <span class="error">${errores.nombre}</span>
                </c:if>
                <br>
                <label for="descripcion">Descripción:</label>
                <textarea id="descripcion" name="descripcion">${producto.descripcion}</textarea>
                <c:if test="${errores.descripcion != null}">
                    <span class="error">${errores.descripcion}</span>
                </c:if>
                <br>
                <label for="categoria">Categoría:</label>
                <select name="categoria" id="categoria">
                    <option value="">Seleccionar</option>
                    <% for (categoria c : categorias) { %>
                    <option value="<%= c.getIdcategoria() %>" <%= producto.getCategoria().getIdcategoria() == c.getIdcategoria() ? "selected" : "" %>><%= c.getNombre() %></option>
                    <% } %>
                </select>

                <br>
                <label for="precio">Precio:</label>
                <input type="number" id="precio" name="precio" value="${producto.precio}">
                <c:if test="${errores.precio != null}">
                    <span class="error">${errores.precio}</span>
                </c:if>
                <br>
                <label for="condicion">Condición:</label>
                <input type="text" id="condicion" name="condicion" value="${producto.condicion}">
                <c:if test="${errores.condicion != null}">
                    <span class="error">${errores.condicion}</span>
                </c:if>
                <br>
                <label for="stock">Stock:</label>
                <input type="number" id="stock" name="stock" value="${producto.stock}">
                <c:if test="${errores.stock != null}">
                    <span class="error">${errores.stock}</span>
                </c:if>
                <br>
                <input type="submit" name="accion" value="${producto.idProducto != null && producto.idProducto > 0 ? "Editar" : "Crear"}">
                <input type="hidden" name="id" value="${producto.idProducto}">
            </div>
        </form>
    </div>
</main>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>
