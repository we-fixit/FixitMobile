/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author Safsaf
 */
public class User {
    private int id;
    private String username;
    private String mail;
    private String name;
    private String lastName;
    private String Password;
    private String role;
    private int view;

    
    public User() {
    }

    public User(int id, String username, String mail, String name, String lastName, String Password, String role,int view) {
        this.id = id;
        this.username = username;
        this.mail = mail;
        this.name = name;
        this.lastName = lastName;
        this.Password = Password;
        this.role = role;
        this.view=view;
    }
public int getView() {
        return view;
    }

    public void setView(int view) {
        this.view = view;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = "ROLE_USER";
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", username=" + username + ", mail=" + mail + ", name=" + name + ", lastName=" + lastName + ", Password=" + Password + ", role=" + role + ", view=" + view + '}';
    }

    
}
