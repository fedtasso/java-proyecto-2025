import java.util.ArrayList;
import java.util.Scanner;

public class Utilities {

  public static void displayProducts(ArrayList<Product> products, Scanner input,
      String title) {
    System.out.println();
    System.out.println("        " + title);
    System.out.println("---------------------------------------");

    if (products == null || products.isEmpty()) {
      System.out.println("No hay productos para mostrar.");
    } else {
      for (Product product : products) {
        System.out.printf(" %2d. %-25s $%.2f%n", product.id, product.name, product.price);
      }
    }

    System.out.println("---------------------------------------");
    System.out.println();
  }

  public static void displayProducts(Product product, Scanner input, String title) {
    System.out.println("        " + title);
    System.out.println("---------------------------------------");

    if (product == null) {
      System.out.println("No hay producto para mostrar.");
    } else {
      System.out.printf(" ID: %d%n", product.id);
      System.out.printf(" Nombre: %s%n", product.name);
      System.out.printf(" Precio: $%.2f%n", product.price);
    }

    System.out.println("---------------------------------------");
  }

  public static ArrayList<Product> searchProductsByName(ArrayList<Product> products,
      Scanner input) {
    System.out.println("Ingrese el nombre del producto: ");
    String userSearch = input.nextLine();
    ArrayList<Product> foundProducts = new ArrayList<>();

    for (Product product : products) {
      if (Utilities.ifIncluded(product.name, userSearch)) {
        foundProducts.add(product);
      }
    }
    return foundProducts;
  }

  public static void pause(Scanner input) {
    System.out.println(" Pulse ENTER para continuar...");
    input.nextLine();

    // "Limpiar" pantalla
    for (int i = 0; i < 30; ++i) {
      System.out.println();
    }
  }

  public static boolean ifIncluded(String productName, String userSearch) {
    String formattedProductName = formatText(productName);
    String formattedSearch = formatText(userSearch);
    return formattedProductName.contains(formattedSearch);
  }

  public static String formatText(String text) {
    return text.trim().toLowerCase();
  }

  public static void exitApplication() {
    System.out.println("""
        --------------------------------------
        ¡Gracias por visitar Casa de Guitarras Clásicas!
        --------------------------------------""");
    System.out.println("Saliendo de la aplicación...");
  }

}