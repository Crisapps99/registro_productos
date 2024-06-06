<%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 30/5/2024
  Time: 8:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Iniciar sesión</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <link rel="stylesheet" href="estiloslogin.css">
</head>
<body>
<nav class="navbar navbar-expand-lg  navbar-light bg-transparent ">
    <div class="container-fluid">
        <a class="navbar-brand text-white" href="index.jsp">Skrapy dj </a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse justify-content-end"  id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link active text-white fs-5" aria-current="page" href="index.jsp">Inicio</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link text-white fs-5" href="/login_war_exploded/productos" >Carrito de compras</a>
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
                    </ul>
                </li>
                <li class="nav-item">
                    <a class="nav-link disabled" aria-disabled="true">Disabled</a>
                </li>
            </ul>

        </div>
    </div>
</nav>
<form action="Servletlogin" method="post">
    <h3>Inicio de sesión</h3>
    <div class="usuario">
        <label for="username">Ingrese el nombre de usuario</label>
        <input type="text" name="username" id="username">
    </div>
    <div class="usuario">
        <label for="password">Ingrese la contraseña</label>
        <input type="password" name="password" id="password">
    </div>
    <div class="btn" >
        <input style="background:#0fbdd9" type="submit" value="Ingresar" name="accion">
    </div>
</form>
</body>
</html>
