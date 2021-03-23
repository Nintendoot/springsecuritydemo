package by.nintendo.springsecuritydemo.entity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

public class MyUser  {

  @NotBlank(message = "The field \"name\" must not be empty")
    private String name;


   @NotBlank(message = "The field \"surname\" must not be empty")
    private String surname;


    @NotBlank(message = "The field \"login\" must not be empty")
    @Size(min = 4,max = 10,message = "size min = 4,max = 10")
    private String login;


    @NotBlank(message = "The field \"password\" must not be empty")
    @Size(min = 4,max = 10,message = "size min = 4,max = 10")
    private String password;
private boolean active;
    private int id;

    private Role role;

    private  List<Calculator> list=new ArrayList<>();

    public MyUser() {
    }

    public MyUser(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public MyUser(String name, String surname, String login, String password) {
        this.name = name;
        this.surname=surname;
        this.login = login;
        this.password = password;
    }

    public MyUser(String name, String login, String password, int id) {
        this.name = name;
        this.login = login;
        this.password = password;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public List<Calculator> getList() {
        return list;
    }

    public void addList(Calculator calculator){
        list.add(calculator);
    }

    public void setList(List<Calculator> list) {
        this.list = list;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

}
