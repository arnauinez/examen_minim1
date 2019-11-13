package test.java;

import dsa.models.Order;
import dsa.models.Product;
import dsa.models.User;
import dsa.project.ProductManager;
import dsa.project.ProductManagerImp;
import dsa.project.ProductManager;
import dsa.project.ProductManagerImp;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.*;
import static org.junit.Assert.*;

public class ProductManagerTest {
    private ProductManager pm = null;

    @Before
    public void setUp() {
        this.pm = ProductManagerImp.getInstance();

        pm.addUser(000, "Toni");
        pm.addUser(111, "Ivan");
        pm.addUser(222, "Arnau");

        this.pm.addProduct(001, "COCACOLA",4, 4.5);
        this.pm.addProduct(002, "FANTA",5, 3.2);
        this.pm.addProduct(003, "BEER",10, 12.99);

        Order _order = new Order(900, 222,"Arnau");
        _order.setProductLines(001, 5);
        _order.setProductLines(002, 7);

        pm.placeOrder(222, "Arnau", _order);
    }


    @Test
    public void Testing() {
        pm.serveOrder();
        List<Order> _placedOrders_ofUser = pm.placedOrders_ofUser(222);
        assertEquals(_placedOrders_ofUser.get(0).getAuthor(), "Arnau", "Arnau");

        pm.getProductList_byPrice(0);

        List<Product> _productList_byPrice = pm.getProductList_byPrice(1);
        assertEquals(_productList_byPrice.get(0).getId(), 003, 003);
        assertEquals(_productList_byPrice.get(1).getId(), 001, 001);
        assertEquals(_productList_byPrice.get(0).getId(), 002, 002);
        //pm.getProductList_bySold();

    }
}