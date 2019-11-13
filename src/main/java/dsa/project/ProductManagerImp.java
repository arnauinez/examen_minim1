package dsa.project;

import java.util.*;

import dsa.models.Order;
import dsa.models.Product;
import dsa.models.ProductLine;
import dsa.models.User;
import org.apache.log4j.Logger;

public class ProductManagerImp implements ProductManager{
    final static Logger log = Logger.getLogger(ProductManagerImp.class);
    private HashMap<Integer, User> usersList;
    private List<Product> productList;
    private LinkedList<Order> pendingOrders;

    private static ProductManagerImp instance = new ProductManagerImp();

    public static ProductManagerImp getInstance() {return instance;}

    private ProductManagerImp() {
        this.usersList = new HashMap<>();
        productList = new ArrayList<>();
        this.pendingOrders = new LinkedList<>();
    }

    public Product getProduct (int product_id) {
        for (Product product: this.productList) {
            if (product.getId() == product_id) return product;
        }
        return null;
    }

    @Override
    public int size() {
        return this.productList.size();
    }

    public void addUser(int id, String username) {
        this.usersList.put(id, new User(id, username));
    }

    public void addProduct(int id, String product_name, int quantity ,double price) {
        productList.add(new Product(id, product_name, quantity, price));
    }


    public void popProduct(int id) {
        productList.remove(id);
    }

    @Override
    public void placeOrder(int user_id, String username, Order order) {
        order.setId(user_id);
        order.setAuthor(username);
        this.pendingOrders.add(order);
    }

    @Override
    public void serveOrder() {
        Order _order = this.pendingOrders.pop();
        log.info("serveOrder -> _order.userID " + _order.getAuthor_id());
        List<ProductLine> productLines = _order.getProductLines();
        log.info("serveOrder -> ServedOrder" +_order);

        int user_id = _order.getAuthor_id();
        // Adding order to servedOrders of the user
        this.usersList.get(user_id).setServedOrders(_order);
        //for each line of products, get q & prod_id so we can find the product in productList & increment quantity
        productLines.forEach(pl -> {
            int increment, product_id;
            increment = pl.getQuantity();
            product_id = pl.getId();
            for (Product product: this.productList) {
                if (product.getId() == product_id) {
                    product.setSold_quantity(increment);
                }
            }
        });

    }

    @Override
    public List<Product> getProductList_byPrice(int order_mode) {
        log.info("getProductList_byPrice -> ProductList Before: " + this.productList);
        if (order_mode == 0)
        {
            Collections.sort(productList, Comparator.comparingDouble(Product::getPrice));
            return productList;
            // List<Employee> List_toReturn = GetEmployees(id_company);
            //List_toReturn.sort((Employee o1, Employee o2)-> (int) (o1.getSalary()-o2.getSalary()));
            // return List_toReturn;
        }
        if (order_mode == 1)
        {
            Collections.sort(productList, new Comparator<Product>() {
                @Override
                public int compare(Product p1, Product p2) {
                    //Ascending order
                    return (int)(p2.getPrice()-p1.getPrice());
                }
            });
            log.info("getProductList_byPrice -> ProductList After: " + this.productList);
            return productList;
        }
        return null;
    }

    @Override
    public List<Product> getProductList_bySold() {
        log.info("getProductList_bySold -> ProductList Before: " + this.productList);
        Collections.sort(this.productList, Collections.reverseOrder());
        log.info("getProductList_bySold -> ProductList After: " + this.productList);
        return this.productList;
    }

    @Override
    public List<Order> placedOrders_ofUser(int user_id) {
        return this.usersList.get(user_id).getServedOrders();
    }

}
