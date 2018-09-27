package com.example.andre.retrofitexperience;

public class Contact {

    /*
    Passo 2: Esta classe é ulitizada pelo retrofit para enviar e receber requisições
    são recebidos em forma de gsos, jackson, moshi etc.
     */

    private String name;
    private String email;

    public Contact() {
    }

    public Contact(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
