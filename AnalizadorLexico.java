import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class AnalizadorLexico {

    public static void analisisL(String nombreArchivo){
        String linea;
        int contadorLinea=0;
        ArrayList<String> palabrasLimpias = new ArrayList<>();
        ArrayList<String> palabrasLimpiasConOperadores = new ArrayList<>();
        ArrayList<String> PalabrasSinOperadores = new ArrayList<>();
        ArrayList<String> palabrasConOperadores= new ArrayList<>();
        
        File codigo = new File(nombreArchivo);
 
        try (BufferedReader br = new BufferedReader(new FileReader(codigo)))
        {
            while ((linea = br.readLine()) != null) {
                contadorLinea++;
                PalabrasSinOperadores = Limpiador.limpiarTodo(linea);
                palabrasConOperadores = Limpiador.limpiarConOperadores(linea);

                for (String str : PalabrasSinOperadores){
                    if (ER.verificarER(str)==false){
                        System.out.println("Error en la linea "+contadorLinea+" en la palabra "+str);
                    }
                }
                
                //Aquí se puede hacer la función de validación de las palabras, si alguna no cumple pueden modificar el ArrayList y ya 
            
                for (String palabra : PalabrasSinOperadores){
                    palabrasLimpias.add(palabra);
                }

                for (String str : palabrasConOperadores){
                    palabrasLimpiasConOperadores.add(str);
                }
                //Aquí haré la función de imprimir 

                //checar si está en el lenguaje  |
                //escribir tokens en archivo (adentro se llamara a los metodos de separacion por cada operador) |
                //metodo de convertir hexa a decimal |
                /*for (String palabra : palabrasLimpias){
                    System.out.println(palabra);
                }  */          
            }
            String [][] ids = new String [palabrasLimpias.size()][2];
            String [][] txt = new String [palabrasLimpias.size()][2];
            String [][] val = new String [palabrasLimpias.size()][2];
            int contadorIDs=1, contadorTxt=1, contadorVal=1;
            
            for (String palabra : palabrasLimpias){
                if (ER.identificadores(palabra)==true  && ER.palabrasReservadas(palabra)==false){
                    ids[contadorIDs-1][0] = palabra;
                    if (contadorIDs<10){
                        ids[contadorIDs-1][1] = "id0"+contadorIDs;
                    }else {
                        ids[contadorIDs-1][1] = "id"+contadorIDs;
                    }
                    contadorIDs++;
                }
        
                if (ER.literalesDeTexto(palabra)==true){
                    txt[contadorTxt][0] = palabra;
                    if (contadorTxt<10){
                        txt[contadorTxt-1][1] = "txt0"+contadorIDs;
                    }else {
                        txt[contadorTxt-1][1] = "txt"+contadorIDs;
                    }
                    contadorTxt++;
                }
        
                if (ER.literalesNumericasDecimales(palabra)==true && ER.literalesNumericasHexadecimales(palabra)==false){
                    val[contadorVal-1][0] = palabra;
                    val[contadorVal-1][1] = palabra;
                    contadorVal++;
                }
        
                if(ER.literalesNumericasHexadecimales(palabra)==true ){
                    
                    val[contadorVal-1][0] = palabra;
                    val[contadorVal-1][1] = Limpiador.convertirHexaADecimal(palabra);
                    contadorVal++;
                }
            }

            File archivoLista = new File("uwu.txt"); //algo.lex
                File archivoMatrices = new File("tipos.txt"); //algo.lex
                
                ManipuladorArchivos.crearArchivo(archivoLista);
                ManipuladorArchivos.crearArchivo(archivoMatrices);
                
                ManipuladorArchivos.imprimirLista(palabrasLimpiasConOperadores, archivoLista);
                ManipuladorArchivos.imprimirArreglos(ids, txt,val, archivoMatrices);
                
        } catch (IOException e) {
            e.printStackTrace();
        }


/*
        try {
            File codigo = new File(nombreArchivo);
            try (Scanner archivo = new Scanner(codigo)) {
                System.out.println("Entre a escribir");
                while(archivo.hasNextLine()){
                    contadorLinea++;
                    linea = archivo.nextLine();
                    System.out.println(linea);
                    PalabrasSinOperadores = Limpiador.limpiarTodo(linea);
                    System.out.println("sigo");

                    palabrasConOperadores = Limpiador.limpiarConOperadores(linea);

                    for (String str : PalabrasSinOperadores){
                        if (ER.verificarER(str)==false){
                            System.out.println("Error en la linea "+contadorLinea+" en la palabra "+str);
                        }
                    }
                    
                    //Aquí se puede hacer la función de validación de las palabras, si alguna no cumple pueden modificar el ArrayList y ya 
                
                    for (String palabra : PalabrasSinOperadores){
                        palabrasLimpias.add(palabra);
                    }

                    for (String str : palabrasConOperadores){
                        palabrasLimpiasConOperadores.add(str);
                    }
                    //Aquí haré la función de imprimir 

                    //checar si está en el lenguaje  |
                    //escribir tokens en archivo (adentro se llamara a los metodos de separacion por cada operador) |
                    //metodo de convertir hexa a decimal |
                    for (String palabra : palabrasLimpias){
                        System.out.println(palabra);
                    }
                }

                String [][] ids = new String [palabrasLimpias.size()][2];
                String [][] txt = new String [palabrasLimpias.size()][2];
                String [][] val = new String [palabrasLimpias.size()][2];
                int contadorIDs=0, contadorTxt=0, contadorVal=0;
                
                System.out.println(palabrasLimpias.size());

                for (String palabra : palabrasLimpias){
                    ER.clasificarPalabra(palabra, ids, txt, val, contadorIDs, contadorTxt, contadorVal);
                    System.out.println(contadorIDs);
                }


                /*
                File archivoLista = new File("uwu.txt"); //algo.lex
                File archivoMatrices = new File("tipos.txt"); //algo.lex
                
                ManipuladorArchivos.crearArchivo(archivoLista);
                ManipuladorArchivos.crearArchivo(archivoMatrices);
                
                ManipuladorArchivos.imprimirLista(palabrasLimpias, archivoLista);
                ManipuladorArchivos.imprimirArreglos(ids, txt,val, archivoMatrices);
                
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }  

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }*/        
    }
}



