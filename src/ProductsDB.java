import java.util.ArrayList;

public class ProductsDB {

  public static ArrayList<Product> getProducts() {
    ArrayList<Product> products = new ArrayList<>();
    products.add(new Product(1, "Guitarra Fonseca 31p", 254999.99));
    products.add(new Product(1, "Guitarra Fonseca 25", 209000.00));
    return products;
  }
}


