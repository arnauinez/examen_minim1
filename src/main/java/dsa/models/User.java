package dsa.models;

import java.util.LinkedList;
import java.util.List;

public class User {
    private int id;
    private String username;
    private LinkedList<Order> servedOrders;

    public User(int id, String username) {
        this.id = id;
        this.username = username;
        this.servedOrders = new LinkedList<>();
    }

    public LinkedList<Order> getServedOrders() {
        return this.servedOrders;
    }

    public void setServedOrders(Order order) {
        this.servedOrders.add(order);
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }
}
