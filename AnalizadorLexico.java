import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class AnalizadorLexico {

    public static void analisisL(String nombreArchivo){
        String linea;
        int contadorLinea=0;
        ArrayList<String> palabrasLimpias = new ArrayList<>();
        ArrayList<String> listaPalabras = new ArrayList<>();

        try {
            File cuenta = new File(nombreArchivo);
            try (Scanner archivo = new Scanner(cuenta)) {
                while(archivo.hasNextLine()){
                    contadorLinea++;
                    linea = archivo.nextLine();
                    listaPalabras = Limpiador.limpiarTodo(linea);

                    for (String str : listaPalabras){
                        if (ERR.identificadores(str)==false){
                            System.out.println("Error en la linea "+contadorLinea+" en la palabra "+str);
                        }
                    }
                    
                    //Aquí se puede hacer la función de validación de las palabras, si alguna no cumple pueden modificar el ArrayList y ya 
                

                    for (String str : listaPalabras){
                        palabrasLimpias.add(str);
                    }

                    //Aquí haré la función de imprimir 



                    //checar si está en el lenguaje
                    //escribir tokens en archivo (adentro se llamara a los metodos de separacion por cada operador)
                    //metodo de convertir hexa a decimal
                }
            }
        } catch (Exception e) {
            System.out.println("Error al escribir");
        }
        
    }
}


