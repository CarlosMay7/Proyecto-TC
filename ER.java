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

    public static boolean asignacion(String palabraRevisar){

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

    public static boolean verificarER(String palabraRevisar){

        boolean validar = false;

        if(identificadores(palabraRevisar) || literalesDeTexto(palabraRevisar) || literalesNumericasDecimales(palabraRevisar)
        || literalesNumericasHexadecimales(palabraRevisar) || operadoresNumericos(palabraRevisar)
        || palabrasReservadas(palabraRevisar) || asignacion(palabraRevisar) || comentario(palabraRevisar) == true){
            validar = true;
            //System.out.println("cumple con las condiciones");
        }  else{
            validar = false;
            //System.out.println("no hubo coincidencia");
        }

        return validar;
    }

    public static void clasificarPalabra (String palabraClasificar, String [][] ids, String [][] txt, String [][] val,int contadorIDs, int contadorTxt, int contadorVal){

        if (identificadores(palabraClasificar)==true){
            ids[contadorIDs][0] = palabraClasificar;
            if (contadorIDs<10){
                ids[contadorIDs][1] = "id0"+contadorIDs;
            }else {
                ids[contadorIDs][1] = "id"+contadorIDs;
            }
            contadorIDs++;
        }

        if (literalesDeTexto(palabraClasificar)==true){
            txt[contadorTxt][0] = palabraClasificar;
            if (contadorTxt<10){
                txt[contadorTxt][1] = "txt0"+contadorIDs;
            }else {
                txt[contadorTxt][1] = "txt"+contadorIDs;
            }
            contadorTxt++;
        }

        if (literalesNumericasDecimales(palabraClasificar)==true){
            val[contadorVal][0] = palabraClasificar;
            val[contadorVal][1] = palabraClasificar;
            contadorVal++;
        }

        if(literalesNumericasHexadecimales(palabraClasificar)==true){
            
            val[contadorVal][0] = palabraClasificar;
            val[contadorVal][1] = Integer.toString(Limpiador.convertirHexaADecimal(palabraClasificar));
            contadorVal++;
        }


    }




}
