package org.servlet.login.services;

import jakarta.servlet.http.HttpServletRequest;

import org.servlet.login.models.Usuario;

import java.util.Optional;

public interface LoginServices {
    //obtengo los datos de usuario
    //es una plantilla que se peude utilizar en cualquier lado
    //obtenemos el nombre del usuari o
   int loginServices(Usuario usuario);

    Optional<String> getUserName(HttpServletRequest req);
}
