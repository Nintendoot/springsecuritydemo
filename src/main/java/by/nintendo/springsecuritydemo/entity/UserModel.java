package by.nintendo.springsecuritydemo.entity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserModel {
    @NotNull(message = "The field \"login\" must not be empty")
    @NotBlank(message = "blank")
    private String login;

    @NotNull(message = "The field \"password\" must not be empty")
    @Size(min = 3,max = 10,message = "MixMax")
    private String password;

    public UserModel() {
    }

    public UserModel(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
