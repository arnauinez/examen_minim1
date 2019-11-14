package dsa.project;

import dsa.models.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class GameManagerImp implements GameManager{
    HashMap <Integer, User> usersList;
    private int usersNum;

    private static GameManagerImp instance = new GameManagerImp();

    public static GameManagerImp getInstance() {return instance;}

    private GameManagerImp() {
        this.usersList = new HashMap<>();
    }

    @Override
    public int size() {
        return this.usersList.size();
    }

    @Override
    public void addUser(int user_id, String user_name, String user_surname) {
        this.usersList.put(user_id, new User(user_id, user_name, user_surname));
        this.usersNum = usersNum + 1;
    }

    @Override
    public void rmvUser(int user_id) {
        this.usersList.forEach((id,));
    }

    @Override
    public void modUser(int user_id, boolean nameORsurname, String modified_string) {
        User _user = this.usersList.get(user_id);
        if (!nameORsurname) _user.setName(modified_string);
        else if(nameORsurname) _user.setSurname(modified_string);

        //this.usersList.forEach((id,ul) -> {
          //  if(ul.getId() == user_id) {
            //    if (!nameORsurname) ul.setName(modified_string);
              //  else if(nameORsurname) ul.setSurname(modified_string);
            //}
        //});
    }

    @Override
    public int getUsersHMAPnum () {
        return this.usersNum;
    }

    @Override
    public void addObj(int id, String name, boolean obj_type, double score) {

    }

    @Override
    public void rmvObj(int obj_id) {

    }


}
