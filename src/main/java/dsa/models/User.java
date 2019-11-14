package dsa.models;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class User {
    private int id;
    private String name;
    private String surname;
    private List<Obj> objList;
    private int objList_num;

    public User(int user_id, String user_name,String user_surname) {
        this.id = user_id;
        this.name = user_name;
        this.surname = user_surname;
        objList = new LinkedList<>();
    }
    public User() {
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

    public int getObjList_num() {
        return objList_num;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
    public void addObj(Obj _obj) {
        this.objList.add(_obj);
    }

    public void rmvObj(int index) {
        this.objList.remove(index);
    }

    public List<Obj> getObjList() {
        return objList;
    }

    public void setObjList(List<Obj> objList) {
        this.objList = objList;
    }

    public void setObjList_num(int objList_num) {
        this.objList_num = objList_num;
    }
}
