import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ER {

     /*public static boolean verficiarPalabraLenguaje (String palabraRevisar){
        boolean dentro;
        
        return dentro;
    }*/

    public static boolean identificadores (String palabraRevisar){

        Pattern patron = Pattern.compile("^[a-zA-Z].[a-zA-Z0-9_-]{0,15}");
        Matcher matcher = patron.matcher(palabraRevisar);

        boolean coincidencia = matcher.matches();

            /*if(coincidencia == true){
                System.out.println("Hubo coincidencia");
            } else{
                System.out.println("Error");
            }*/

        return coincidencia;
    }

    public static boolean literalesDeTexto(String palabraRevisar){

        Pattern patron = Pattern.compile("^[“].[a-zA-Z0-9\\s+]*[”]");
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
       
        Pattern patron = Pattern.compile(".+[*|/|+|-].+");
        Matcher matcher = patron.matcher(palabraRevisar);

        boolean coincidencia = matcher.matches();

        return coincidencia;
    }

    public static boolean palabrasReservadas(String palabraRevisar){
        
        Pattern patron = Pattern.compile("^[PROGRAMA|FINPROG|IMPRIME|LEE].+");
        Matcher matcher = patron.matcher(palabraRevisar);

        boolean coincidencia = matcher.matches();

        return coincidencia;
    }

    public static boolean asigancion(String palabraRevisar){

        Pattern patron = Pattern.compile(".+=.+");
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

    public static boolean verificarER(){

        boolean validar = false;

        if(identificadores(null) && literalesDeTexto(null) && literalesNumericasDecimales(null)
        && literalesNumericasHexadecimales(null) && operadoresNumericos(null)
        && palabrasReservadas(null) && asigancion(null) && comentario(null) == true){
            validar = true;
            //System.out.println("cumple con las condiciones");
        }  else{
            //System.out.println("no hubo coincidencia");
        }

        return validar;
    }


}
