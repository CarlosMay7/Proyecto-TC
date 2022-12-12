import java.util.Scanner;

public class Analisis {
    public static void main(String[] args) {
        /*Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el nombre del archivo");
        String archivo = scanner.nextLine();

        AnalizadorLexico.analisisL(archivo);
        scanner.close();
*/
        AnalizadorSintactico.analisisS("programa.lex");
    }
}
