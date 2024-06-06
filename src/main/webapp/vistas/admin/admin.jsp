<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <link rel="stylesheet" href="../stilos/stilosindex.css">
   </head>
<body>
<nav class="navbar navbar-expand-lg  navbar-light bg-transparent ">
    <div class="container-fluid">
        <a class="navbar-brand text-white" href="admin.jsp">Skrapy dj </a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse justify-content-end"  id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link active text-white fs-5" aria-current="page" href="admin.jsp">Inicio</a>
                </li>
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
<form action="">
<c:choose>
<c:when test="${sessionScope.usuario != null}">
            <h3> Sistema de Logeo Bienvenido ${sessionScope.usuario}</h3>
            <div class="imagen">
                <img src="../../agregar-usuario.png" alt="">
            </div>

        </c:when>
        <c:otherwise>
            <h1>LO SENTIMOS DEBE LOGEARSE PRIMERAMENTE</h1>
            <li><a class="btn btn-secondary" style="list-style-type: none;" href="/login_war_exploded/logouth">SALIR</a></li>
        </c:otherwise>
</c:choose>
</form>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>
