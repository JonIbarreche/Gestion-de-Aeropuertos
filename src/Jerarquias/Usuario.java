package Jerarquias;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class Usuario {
    
    protected int id;
    protected String username;
    protected String password;
    
    public Usuario(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public Usuario() {
        this.id = 0;
        this.username = "";
        this.password = "";
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Usuario id(int id) {
        setId(id);
        return this;
    }

    public Usuario username(String username) {
        setUsername(username);
        return this;
    }

    public Usuario password(String password) {
        setPassword(password);
        return this;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", username='" + getUsername() + "'" +
            ", password='" + getPassword() + "'" +
            "}";
    }
    

}