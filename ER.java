import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ER {
    public static void main (String[] args){

        //identificadores alfanumericos
        String linea = "DiaDeLaSemana1";

        Pattern patron = Pattern.compile("^[a-zA-Z].[a-zA-Z0-9_-]{0,15}");
        Matcher matcher = patron.matcher(linea);

        boolean coincidencia = matcher.find();

            if(coincidencia == true){
                System.out.println("Hubo coincidencia");
            } else{
                System.out.println("Error");
            }

        // identificadores literales de texto
        
    }
}