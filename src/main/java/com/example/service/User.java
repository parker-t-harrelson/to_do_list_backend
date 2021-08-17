package com.example.service;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private final String username;
    private final byte[] password;
    private final String email;

    public User(String username, String email, String password) throws NoSuchAlgorithmException {
        this.username = username;
        this.password = getPasswordHash(password);
        this.email = email;
        System.out.println("NEW USER CREATED: " + this.toString());
    }

    public User() {
        this.username = "";
        this.email = "";
        this.password = null;
    }

    public long getId () {
        return this.id;
    }

    public String getUsername () {
        return this.username;
    }

    public String getEmail () {
        return this.email;
    }

    public byte[] getPassword () {
        return this.password;
    }

    private byte[] getPasswordHash (String pass) throws NoSuchAlgorithmException {

        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        return digest.digest(pass.getBytes(StandardCharsets.UTF_8));
    }

    @Override
    public String toString () {
        return "User {username = " + this.username + ", id: " + this.id + ", email: " + this.email + "}";
    }
}
