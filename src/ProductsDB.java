import java.util.ArrayList;

public class ProductsDB {

  public static ArrayList<Product> getProducts() {
    ArrayList<Product> products = new ArrayList<>();
    products.add(new Product(1, "Guitarra Fonseca 31p", 254999.99));
    products.add(new Product(1, "Guitarra Fonseca 25", 209000.00));
    products.add(new Product(3, "Guitarra Clásica Alhambra", 189999.00));
    products.add(new Product(4, "Guitarra Flamenca Manuel Reyes", 320000.50));
    products.add(new Product(5, "Guitarra Yamaha C40", 89999.99));
    products.add(new Product(6, "Guitarra Cordoba C5", 145000.00));
    products.add(new Product(7, "Guitarra Takamine GC1", 178000.00));
    products.add(new Product(8, "Guitarra La Patrie Etude", 132500.00));
    products.add(new Product(9, "Guitarra Fender CN-140S", 167800.00));
    products.add(new Product(10, "Guitarra Ibanez GA3TM", 156000.00));
    return products;
  }
}


