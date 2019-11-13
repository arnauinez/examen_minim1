package dsa.models;

public class Product {
    private int id;
    private String product_name;
    private int quantity;
    private double price;

    public Product () { } // Constructor for the API
    public Product(int id, String product_name,int quantity ,double price) {
        this.id = id;
        this.product_name = product_name;
        this.price = price;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }
    public String getProduct_name() {
        return product_name;
    }
    public int getQuantity() { return quantity;}

    public void setId(int id) {
        this.id = id;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void setSold_quantity(int increment) {
        this.quantity = this.quantity+increment;
    }
}
