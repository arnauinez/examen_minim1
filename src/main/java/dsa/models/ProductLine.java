package dsa.models;

public class ProductLine {
    private int quantity;
    private int id;

    public ProductLine(int quantity, int id) {
        this.quantity = quantity;
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
