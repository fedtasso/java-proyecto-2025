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
  public static double validatePrice(Scanner input) {
    while (true) {
      try {
        System.out.print("Ingrese el precio del nuevo producto: ");
        String inputText = input.nextLine().replace(",", ".");
        double price = Double.parseDouble(inputText);

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
  public static String validateText(Scanner input) {
    while (true) {
      System.out.print("Ingrese el nombre del nuevo producto: ");
      String text = input.nextLine().trim();
      if (!text.isEmpty()) {
        return text;
      } else {
        System.out.println("Error: Este campo no puede estar vacío");
      }
    }
  }
}