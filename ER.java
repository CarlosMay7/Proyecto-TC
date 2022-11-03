import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ER {

    public static boolean identificadores (String palabraRevisar){

        Pattern patron = Pattern.compile("^[a-zA-Z].[a-zA-Z0-9_-]{0,15}");
        Matcher matcher = patron.matcher(palabraRevisar);

        boolean coincidencia = matcher.matches();

        return coincidencia;
    }

    public static boolean literalesDeTexto(String palabraRevisar){
        char comilla = '"';
        String erSinLaCosaEsa = "^[“].[a-zA-Z0-9\\s+]*["+comilla+"]";
        Pattern patron = Pattern.compile(erSinLaCosaEsa);
        Matcher matcher = patron.matcher(palabraRevisar);

        boolean coincidencia = matcher.matches();

        return coincidencia;
    }

    
    public static boolean literalesNumericasDecimales(String palabraRevisar){

        Pattern patron = Pattern.compile("[0-9-.].+");
        Matcher matcher = patron.matcher(palabraRevisar);

        boolean coincidencia = matcher.matches();

        return coincidencia; 
    }

    public static boolean literalesNumericasHexadecimales(String palabraRevisar){
        
        Pattern patron = Pattern.compile("^0x[0-9A-F]{1,15}");
        Matcher matcher = patron.matcher(palabraRevisar);

        boolean coincidencia = matcher.matches();

        return coincidencia;
    }

    public static boolean operadoresNumericos(String palabraRevisar){
       
        Pattern patron = Pattern.compile("[*|/|+|-]");
        Matcher matcher = patron.matcher(palabraRevisar);

        boolean coincidencia = matcher.matches();

        return coincidencia;
    }

    public static boolean palabrasReservadas(String palabraRevisar){
        
        boolean coincidencia = false;
        String [] palabrasReservadas = {"PROGRAMA","FINPROG","IMPRIME","LEE"};

        for (String palabra : palabrasReservadas){
            if (palabraRevisar.equals(palabra)){
                coincidencia = true;
                break;
            }
            //caso especial imprime
        }

        return coincidencia;
    }

    public static boolean asignacion(String palabraRevisar){

        Pattern patron = Pattern.compile("=");
        Matcher matcher = patron.matcher(palabraRevisar);

        boolean coincidencia = matcher.matches();

        return coincidencia;
    }

    public static boolean comentario(String palabraRevisar){

        Pattern patron = Pattern.compile("^#.*");
        Matcher matcher = patron.matcher(palabraRevisar);

        boolean coincidencia = matcher.matches();

        return coincidencia;
    }

    public static boolean verificarER(String palabraRevisar){

        boolean validar = false;

        if(identificadores(palabraRevisar) || literalesDeTexto(palabraRevisar) || literalesNumericasDecimales(palabraRevisar)
        || literalesNumericasHexadecimales(palabraRevisar) || operadoresNumericos(palabraRevisar)
        || palabrasReservadas(palabraRevisar) || asignacion(palabraRevisar) || comentario(palabraRevisar) == true){
            validar = true;
        }  else{
            validar = false;
        }

        return validar;
    }

}
