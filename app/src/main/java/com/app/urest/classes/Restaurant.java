package com.app.urest.classes;

/**
 * Created by Mariexi on 08/04/16.
 */
public class Restaurant {
    private String logo;
    private String tipo;
    private String nombre;
    private String promedio;
    private String horario;
    private String favoritos;

    public Restaurant(String logo, String tipo, String nombre, String promedio, String horario, String favoritos) {
        this.logo = logo;
        this.tipo = tipo;
        this.nombre = nombre;
        this.promedio = promedio;
        this.horario = horario;
        this.favoritos = favoritos;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPromedio() {
        return promedio;
    }

    public void setPromedio(String promedio) {
        this.promedio = promedio;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getFavoritos() {
        return favoritos;
    }

    public void setFavoritos(String favoritos) {
        this.favoritos = favoritos;
    }

}
