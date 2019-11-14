package dsa.project;

public interface GameManager {
    public int size();
    public void addUser(int user_id, String user_name, String user_surname);
    public void rmvUser(int user_id);
    public void modUser(int user_id, boolean nameORsurname, String modified_string);
    public int getUsersHMAPnum();

    public void addObj(int id, String name, boolean obj_type, double score);
    public void  rmvObj(int obj_id);

}
