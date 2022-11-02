import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class AnalizadorLexico {

    public static void analisisL(String nombreArchivo){
        String linea;
        int contadorLinea=0;
        ArrayList<String> palabrasLimpias = new ArrayList<>();
        ArrayList<String> palabrasLimpiasConOperadores = new ArrayList<>();
        ArrayList<String> PalabrasSinOperadores = new ArrayList<>();
        ArrayList<String> palabrasConOperadores= new ArrayList<>();

        try {
            File codigo = new File(nombreArchivo);
            try (Scanner archivo = new Scanner(codigo)) {
                while(archivo.hasNextLine()){
                    contadorLinea++;
                    linea = archivo.nextLine();
                    PalabrasSinOperadores = Limpiador.limpiarTodo(linea);
                    palabrasConOperadores = Limpiador.limpiarConOperadores(linea);

                    for (String str : PalabrasSinOperadores){
                        if (ER.verificarER(str)==false){
                            System.out.println("Error en la linea "+contadorLinea+" en la palabra "+str);
                        }
                    }
                    
                    //Aquí se puede hacer la función de validación de las palabras, si alguna no cumple pueden modificar el ArrayList y ya 
                
                    for (String str : PalabrasSinOperadores){
                        palabrasLimpias.add(str);
                    }

                    for (String str : palabrasConOperadores){
                        palabrasLimpiasConOperadores.add(str);
                    }


                    //Aquí haré la función de imprimir 



                    //checar si está en el lenguaje
                    //escribir tokens en archivo (adentro se llamara a los metodos de separacion por cada operador)
                    //metodo de convertir hexa a decimal
                }
                String [][] ids = new String [palabrasLimpias.size()][2];
                String [][] txt = new String [palabrasLimpias.size()][2];
                String [][] val = new String [palabrasLimpias.size()][2];
                int contadorIDs=0, contadorTxt=0, contadorVal=0;

                for (String palabra : palabrasLimpias){
                    ER.clasificarPalabra(palabra, ids, txt, val, contadorIDs, contadorTxt, contadorVal);
                }

            }
        } catch (Exception e) {
            System.out.println("Error al escribir");
        }
        
    }
}

