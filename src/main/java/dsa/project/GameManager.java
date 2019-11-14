package dsa.project;

import dsa.models.User;

import java.util.List;

public interface GameManager {
    public int size();
    public void addUser(int user_id, String user_name, String user_surname);
    public void rmvUser(int user_id);
    public void modUser(int user_id, boolean nameORsurname, String modified_string);
    public int getUsersHMAPnum();
    public List<User> getSortedUsersList();

    public void addObj(int user_id, int id, String name, boolean obj_type, double score);
    public void rmvObj(int user_id, int obj_id);
    public int numObj(int user_id);
    public String objList_ofUSer(int user_id);

}
