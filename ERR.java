import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ERR {
    

    /*public static boolean verficiarPalabraLenguaje (String palabraRevisar){
        boolean dentro;
        
        return dentro;
    }*/

    public static boolean identificadores (String palabraRevisar){

        Pattern patron = Pattern.compile("^[a-zA-Z].[a-zA-Z0-9_-]{0,15}");
        Matcher matcher = patron.matcher(palabraRevisar);

        boolean coincidencia = matcher.find();

            return coincidencia;
    }
}
