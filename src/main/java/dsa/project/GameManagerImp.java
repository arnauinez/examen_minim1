package dsa.project;

import dsa.models.Obj;
import dsa.models.User;
import org.apache.log4j.Logger;
import org.graalvm.compiler.lir.LIRInstruction;

import java.util.*;

public class GameManagerImp implements GameManager{
    final static Logger log = Logger.getLogger(ProductManagerImp.class);
    HashMap <Integer, User> usersList;
    private int usersNum;

    private static GameManagerImp instance = new GameManagerImp();

    public static GameManagerImp getInstance()    {
        if(instance==null)
        {
            instance = new GameManagerImp();
        }
        return instance;
    }

    private GameManagerImp() {
        this.usersList = new HashMap<>();
    }

    @Override
    public int size() {
        return this.usersList.size();
    }

    @Override
    public void addUser(int user_id, String user_name, String user_surname) {
        log.info("addUser -> AddedUser" +user_name+user_surname);
        this.usersList.put(user_id, new User(user_id, user_name, user_surname));
        this.usersNum = usersNum + 1;
    }


    @Override
    public void rmvUser(int user_id) {
        this.usersList.remove(user_id);
    }

    @Override
    public void modUser(int user_id, boolean nameORsurname, String modified_string) {
        log.info("modUser -> modified String" +modified_string);
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
    public List<User> getSortedUsersList() {
        String stringaux0 = "";
        for (User _user : this.usersList.values()) {
            stringaux0 = _user.getName() + "\n";
        }
        log.info("getSortedUsersList -> AFTER:"+ stringaux0);
        List<User> _userList = new ArrayList<User>(this.usersList.values());
        Collections.sort(_userList, Comparator.comparing(User::getName));

        String stringaux1 = "";
        for (User _user : _userList) {
            stringaux1 = _user.getName() + "\n";
        }
        return _userList;
    }

    @Override
    public void addObj(int user_id, int id, String name, boolean obj_type, double score) {
        this.usersList.get(user_id).addObj(new Obj(id, name, obj_type, score));
    }

    @Override
    public void rmvObj(int user_id, int obj_id) {
        List<Obj> _objList = this.usersList.get(user_id).getObjList();
        int index = 0;
        for(Obj _obj : _objList) {
            if (_obj.getId() == obj_id) this.usersList.get(user_id).rmvObj(index);
        }
    }

    @Override
    public int numObj(int user_id) {
        return this.usersList.get(user_id).getObjList_num();
    }

    @Override
    public String objList_ofUSer(int user_id) {
        return null;
    }

}
