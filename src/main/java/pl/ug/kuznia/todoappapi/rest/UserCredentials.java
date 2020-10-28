package pl.ug.kuznia.todoappapi.rest;

import lombok.Data;

@Data
public class UserCredentials {
    private String username;
    private String password;

    public UserCredentials() {

    }
}
