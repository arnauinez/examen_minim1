package dsa.models;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class User {
    private int id;
    private String name;
    private String surname;
    private List<Order> objList;

    public User(int user_id, String user_name,String user_surname) {
        this.id = user_id;
        this.name = user_name;
        this.surname = user_surname;
        objList = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public List<Order> getObjList() {
        return objList;
    }

    public void setObjList(List<Order> objList) {
        this.objList = objList;
    }
}
