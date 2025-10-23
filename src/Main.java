import java.util.ArrayList;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    ArrayList<Product> productInventory = ProductsDB.getProducts();

    int simulatedId = productInventory.size() + 1;
    int menuOptions;

    System.out.println("""
        
        Te damos la bienvenida a:
        
        ----- Casa de Guitarras Clásicas -----
        """);
    label:

    while (true) {
      System.out.println(
          """
              Ingrese la opción deseada:
              1 - Listar Productos
              2 - Búsqueda por nombre
              3 - Crear un Producto
              4 - Editar precio de producto
              5 - Borrar producto
              0 - Salir
              """
      );

      menuOptions = Validations.validateMenuOption(input);

      switch (menuOptions) {
        case 1 -> displayAllProducts(productInventory, input);
        case 2 -> searchProductByName(productInventory, input);
        case 3 -> {
          createNewProduct(simulatedId, productInventory, input);
          simulatedId += 1;
        }
        case 4 -> updateProduct(productInventory, input);
        case 5 -> deleteProduct(productInventory, input);
        case 0 -> {
          Utilities.exitApplication();
          input.close();
          break label;
        }
      }
    }
  }


  public static void displayAllProducts(ArrayList<Product> productInventory, Scanner input) {
    String title = "Todos los Productos";
    Utilities.displayProducts(productInventory, input, title);
    Utilities.pause(input);
  }

  public static void searchProductByName(ArrayList<Product> products, Scanner input) {
    ArrayList<Product> foundProducts = Utilities.searchProductsByName(products, input);
    String title = "Resultado de la búsqueda";
    Utilities.displayProducts(foundProducts, input, title);
    Utilities.pause(input);
  }

  public static void createNewProduct(int id, ArrayList<Product> products, Scanner input) {
    System.out.println("Creando Nuevo Producto");
    String name = Validations.validateText(input);
    double price = Validations.validatePrice(input);
    products.add(new Product(id, name, price));
    System.out.println("""
        --------------------------------------
        Producto agregado satisfactoriamente
        --------------------------------------""");
    Utilities.pause(input);
  }

  public static void updateProduct(ArrayList<Product> products, Scanner input) {

    ArrayList<Product> foundProducts = Utilities.searchProductsByName(products, input);
    if (foundProducts.isEmpty()) {
      System.out.println("No se encontró producto para editar.");
      Utilities.pause(input);
      return;
    }
    Product product = foundProducts.get(0);
    ProductService.editProductMenu(product, input);
  }

  public static void deleteProduct(ArrayList<Product> products, Scanner input) {
    System.out.println("=== ELIMINAR PRODUCTO ===");

    ArrayList<Product> foundProducts = Utilities.searchProductsByName(products, input);

    if (foundProducts.isEmpty()) {
      System.out.println("No se encontró producto para eliminar.");
      Utilities.pause(input);
      return;
    }

    Product product = foundProducts.get(0);
    Utilities.displayProducts(product, input, "PRODUCTO A ELIMINAR");

    // Confirmación de eliminación
    System.out.print("¿Está seguro de que desea eliminar este producto? (s/n): ");
    String confirmation = input.nextLine().trim().toLowerCase();

    if (confirmation.equals("s") || confirmation.equals("si")) {
      products.remove(product);
      System.out.println("""
          --------------------------------------
          ¡Producto eliminado correctamente!
          --------------------------------------""");
    } else {
      System.out.println("Eliminación cancelada.");
    }

    Utilities.pause(input);
  }

}

