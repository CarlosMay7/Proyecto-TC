import java.util.ArrayList;

public class Prueba {
    public static void main(String[] args) {
        
        StringBuilder sb = new StringBuilder();
        ArrayList<String> palabraslindas = new ArrayList<>();
        String prueba = "#IMPRIME 25-6782+78-25";
        String cadenaLimpiar ="uwuuuu=78+25/75/525-96+33";
        String hola = "palindocracia = 780-890+0x842*581-888";
        Limpiador limp = new Limpiador();
        //int medida = limp.limpiarSuma(pueba).length;
        //String [] asignacion = limp.limpiarSuma(pueba);
       /* 
        for(int i=0;i<medida;i++){
            System.out.println(limp.limpiarSuma(pueba)[i]+"\n");
        }

        for (String str : asignacion){
            sb.append(str);
        }

        System.out.println(sb.substring(0));

        //System.out.println(sb.append(limp.limpiarAsignacion(pueba)));
        //System.out.println(medida);

        for(String str : limp.limpiarTodo(cadenaLimpiar)){
            System.out.println(str);
        }

*/
        for (String str : Limpiador.limpiarTodo(prueba)){
            palabraslindas.add(str);
        }

        for (String str : palabraslindas){
            System.out.println(str);
        }

        /*for (String str : Limpiador.limpiarTodo(hola)){
            palabraslindas.add(str);
        }*/


       /* for (String str : palabraslindas){
            if (ERR.identificadores(str)==false){
                System.out.println("Error en la palabra "+str);
            }
        } */
        
        //Aquí se puede hacer la función de validación de las palabras, si alguna no cumple pueden modificar el ArrayList y ya 
    
    }
}

