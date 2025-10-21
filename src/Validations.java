import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Validations {

  // 1. Validación para opciones de menú
  public static int validateMenuOption(Scanner input) {
    while (true) {
      try {
        System.out.print("Su opción: ");
        int option = input.nextInt();
        input.nextLine();

        if (option >= 0 && option <= 5) {
          return option;
        } else {
          System.out.println("Error: Opción debe ser entre 0 y 5");
        }

      } catch (InputMismatchException e) {
        System.out.println("Error: Debe ingresar un número válido");
        input.nextLine();
      }
    }
  }

  // 2. Validación para precios (números positivos)
  public static double validatePrice(Scanner input, String message) {
    while (true) {
      try {
        System.out.print(message);
        double price = input.nextDouble();
        input.nextLine();

        if (price > 0) {
          return price;
        } else {
          System.out.println("Error: El precio debe ser mayor a 0");
        }

      } catch (InputMismatchException e) {
        System.out.println("Error: Debe ingresar un precio válido (ej: 299.99)");
        input.nextLine();
      }
    }
  }

  // 3. Validación para texto no vacío
  public static String validateNonEmptyText(Scanner input, String message) {
    while (true) {
      System.out.print(message);
      String text = input.nextLine().trim();

      if (!text.isEmpty()) {
        return text;
      } else {
        System.out.println("Error: Este campo no puede estar vacío");
      }
    }
  }

  // 4. Validación para IDs existentes
  public static int validateExistingId(Scanner input, String message, ArrayList<Product> products) {
    while (true) {
      try {
        System.out.print(message);
        int id = input.nextInt();
        input.nextLine();

        // Verificar si el ID existe en la lista
        boolean idExists = products.stream().anyMatch(p -> p.id == id);
        if (idExists) {
          return id;
        } else {
          System.out.println("Error: ID no encontrado en el inventario");
        }

      } catch (InputMismatchException e) {
        System.out.println(" Error: Debe ingresar un número de ID válido");
        input.nextLine();
      }
    }
  }
}