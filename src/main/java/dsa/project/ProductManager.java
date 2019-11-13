package dsa.project;

import dsa.models.Order;
import dsa.models.Product;
import dsa.models.User;

import java.util.List;

public interface ProductManager {
    public int size();
    public void addUser(int id, String username);
    //dsa.models.Product Management

    public void addProduct(int id, String product_name, int quantity ,double price);
    public void popProduct(int id);
    public Product getProduct(int product_id);

    public List<Product> getProductList_byPrice(int order_mode); // 0 for ASC & 1 for DESC
    public List<Product> getProductList_bySold();

    //dsa.models.Order management
    public void placeOrder(int user_id, String username, Order order);
    public void serveOrder();
    public List<Order> placedOrders_ofUser(int user_id);
}
