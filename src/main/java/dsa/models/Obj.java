package dsa.models;

public class Obj {
    private int id;
    private String name;
    private boolean obj_type; //Ataque0 o defensa1
    private double score;

    public Obj(int id, String name, boolean obj_type, double score) {
        this.id = id;
        this.name = name;
        this.obj_type = obj_type;
        this.score = score;
    }
    public Obj() {

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

    public boolean isObj_type() {
        return obj_type;
    }

    public void setObj_type(boolean obj_type) {
        this.obj_type = obj_type;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

}
