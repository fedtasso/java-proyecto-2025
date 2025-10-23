import java.util.Scanner;

public class ProductService {

  public static void editProductMenu(Product product, Scanner input) {
    int option;

    do {
      Utilities.displayProducts(product, input, "EDITANDO PRODUCTO");

      System.out.println("""
          ¿Qué desea editar?
          1 - Nombre
          2 - Precio
          0 - Salir del editor
          """);

      option = Validations.validateMenuOption(input);

      switch (option) {
        case 1 -> editProductName(product, input);
        case 2 -> editProductPrice(product, input);
        case 0 -> System.out.println("Saliendo del editor...");
        default -> System.out.println("Opción no válida, vuelva a intentar");
      }

    } while (option != 0);
  }


  public static void editProductName(Product product, Scanner input) {
    System.out.println("Nombre actual: " + product.name);
    System.out.print("Ingrese el nuevo nombre: ");
    String newName = Validations.validateText(input);

    product.name = newName;
    System.out.println("¡Nombre actualizado correctamente!");
    Utilities.pause(input);
  }

  public static void editProductPrice(Product product, Scanner input) {
    System.out.printf("Precio actual: $%.2f%n", product.price);
    double newPrice = Validations.validatePrice(input);

    product.price = newPrice;
    System.out.println("¡Precio actualizado correctamente!");
    Utilities.pause(input);
  }

}
