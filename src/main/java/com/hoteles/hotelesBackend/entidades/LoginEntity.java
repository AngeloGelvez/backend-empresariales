package com.hoteles.hotelesBackend.entidades;

public class LoginEntity {

    private String email;
    private String password;
    private String tipoUsuario;

    public LoginEntity(String email, String password, String tipoUsuario) {
        this.email = email;
        this.password = password;
        this.tipoUsuario = tipoUsuario;
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

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
}
