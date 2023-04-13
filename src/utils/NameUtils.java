package utils;

import java.util.Scanner;

public class NameUtils {

    public static boolean checkName(String name) {
        boolean faltanRespuestas = true;
        Scanner scanner = new Scanner(System.in);
        while (faltanRespuestas) {
            if (name.contains("0") || name.contains("1") || name.contains("2") || name.contains("3") || name.contains("4")
                    || name.contains("5") || name.contains("6") || name.contains("7") || name.contains("8") ||
                    name.contains("9") || name.contains("?") || name.contains("!") || name.contains(".") || name.contains(",")) {
                System.out.println("Mal, introduce caracteres correctos");
                name = scanner.nextLine();
            } else {
                System.out.printf("Correcto. Se llama "  + name + ". ");
                return true;
            }
        }
        return false;
    }
}
