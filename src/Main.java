import java.util.ArrayList;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    ArrayList<Product> productInventory = getProducts();

    int simulatedId = productInventory.size() + 1;
    int menuOptions;

    System.out.println("""
        
        Te damos la bienvenida a:
        
        ----- Casa de Guitarras Clásicas -----
        
        Seleccione una opción:""");
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
        case 1 -> displayAllProducts(productInventory);
        case 2 -> searchProductByName(productInventory);
        case 3 -> {
          createNewProduct (productInventory, simulatedId);
        simulatedId += 1;
        }
        case 4 -> updateProductPrice(productInventory);
        case 5 -> deleteProduct(productInventory);
        case 0 -> exitApplication(); // TODO ver como implementar
    }
  }

    public static void crearProducto(int id, ArrayList<Producto> productos) {
      Scanner entrada = new Scanner(System.in);
      System.out.println("Creando Nuevo Producto");
      System.out.print("Ingrese el nombre del nuevo producto: ");
      String nombre = entrada.nextLine();

      // TODO: cambiarlo cuando veamos static
      productos.add(new Producto(id, nombre));

      // TODO: agregar un mensaje de confirmación cuando se crea el producto
      pausa();
    }


  public static ArrayList<Product> getProducts() {
    ArrayList<Product> products = new ArrayList<>();
    products.add(new Product(1, "Guitarra Fonseca 31p", 25500.99));

    return products;
  }


}
