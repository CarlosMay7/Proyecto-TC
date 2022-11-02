import java.io.File;
import java.util.ArrayList;

public class prueba {
    public static void main(String[] args) {
        
        StringBuilder sb = new StringBuilder();
        ArrayList<String> palabraslindas = new ArrayList<>();
        String reservada = "# Programa fuente en ellenguaje MIO para expresiones aritméticas";
        String prueba = "+";
        String cadenaLimpiar ="uwuuuu=78+25/75/525-96+33";
        String hola = "tukutu =             780-890+0x842* 581-888";
        Limpiador limp = new Limpiador();

        String [][] miMatriz1 = new String [3][3];

        miMatriz1[0][0]="5";
		miMatriz1[0][1]="8";
		miMatriz1[0][2]="1";
		//llenar la segunda fila
		miMatriz1[1][0]="9";
		miMatriz1[1][1]="7";
		miMatriz1[1][2]="2";

        String [][] miMatriz2 = new String [3][3];

        miMatriz2[0][0]="5";
		miMatriz2[0][1]="8";
		miMatriz2[0][2]="1";
		//llenar la segunda fila
		miMatriz2[1][0]="9";
		miMatriz2[1][1]="7";
		miMatriz2[1][2]="2";

        String [][] miMatriz3 = new String [3][3];

        miMatriz3[0][0]="5";
		miMatriz3[0][1]="8";
		miMatriz3[0][2]="1";
		//llenar la segunda fila
		miMatriz3[1][0]="9";
		miMatriz3[1][1]="7";
		miMatriz3[1][2]="2";
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
        for (String str : Limpiador.limpiarConOperadores(cadenaLimpiar)){
            palabraslindas.add(str);
        }

        for (String str : palabraslindas){
            System.out.println(str);
        }

        //ManipuladorArchivos.imprimirLista(palabraslindas);

        String hexa = "0xA25";

        System.out.println(Limpiador.convertirHexaADecimal(hexa));
        
        File archivoLista = new File("prueba.txt"); //algo.lex
        File archivoMatrices = new File("matriz.txt"); //algo.lex
        
        ManipuladorArchivos.crearArchivo(archivoLista);
        ManipuladorArchivos.crearArchivo(archivoMatrices);
        
        ManipuladorArchivos.imprimirLista(palabraslindas, archivoLista);
        ManipuladorArchivos.imprimirArreglos(miMatriz1, miMatriz2,miMatriz3, archivoMatrices);

        System.out.println(ER.palabrasReservadas(reservada));

        System.out.println(ER.comentario(reservada));

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
