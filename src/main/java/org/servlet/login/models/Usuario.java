package org.servlet.login.models;

public class Usuario {
    private int idusuario;
    private String nombre;
    private String usuario;
    private String email;
    private String password;
    private int condicion;
    private String rol;

    public Usuario(){}
    public Usuario(int idusuario, String nombre,String rol, String usuario, String email, String password, int condicion) {
        this.idusuario = idusuario;
        this.nombre = nombre;
        this.usuario = usuario;
        this.email = email;
        this.password = password;
        this.condicion = condicion;
        this.rol = rol;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getCondicion() {
        return condicion;
    }

    public void setCondicion(int condicion) {
        this.condicion = condicion;
    }
}
