package com.tecsup.apaza.healmepaciente.Class;

public class Paciente {

    private String email;
    private String password;

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

    @Override
    public String toString() {
        return "Paciente{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
