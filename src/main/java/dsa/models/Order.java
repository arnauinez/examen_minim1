package dsa.models;

import java.util.*;

public class Order {
    private int id;
    private String author;
    private int author_id;
    List<ProductLine> productLines;

    public Order(int id, int author_id, String author) {
        this.id = id;
        this.author = author;
        this.author_id = author_id;
        this.productLines = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public int getAuthor_id() {
        return author_id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAuthor_id(int author_id) {
        this.author_id = author_id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public List<ProductLine> getProductLines() {
        return productLines;
    }

    public void setProductLines(int productLine_id, int quantity) {
        this.productLines.add(new ProductLine(productLine_id, quantity));
    }
}
