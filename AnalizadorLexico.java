import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class AnalizadorLexico {

    public static boolean analisisL(String nombreArchivo){
        String linea;
        int contadorLinea=0;
        boolean crear=true, correcto=false; 
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
                        crear = false;
                    }
                }
                            
                for (String palabra : PalabrasSinOperadores){
                    palabrasLimpias.add(palabra);
                }

                for (String str : palabrasConOperadores){
                    palabrasLimpiasConOperadores.add(str);
                }  
            }
            if (crear == true){
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
                        txt[contadorTxt-1][0] = palabra;
                        if (contadorTxt<10){
                            txt[contadorTxt-1][1] = "txt0"+contadorTxt;
                        }else {
                            txt[contadorTxt-1][1] = "txt"+contadorTxt;
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
    
    
                    File archivoLista = new File("programa.lex"); 
                    File archivoMatrices = new File("programa.sim"); 
                    
                    ManipuladorArchivos.crearArchivo(archivoLista);
                    ManipuladorArchivos.crearArchivo(archivoMatrices);
                    
                    ManipuladorArchivos.imprimirLista(palabrasLimpiasConOperadores, archivoLista);
                    ManipuladorArchivos.imprimirArreglos(ids, txt,val, archivoMatrices);
                    correcto=true;
            }
                
        } catch (IOException e) {
            System.out.println("No se encuentra un archivo con ese nombre");                
        }     
        return correcto;
    }
}



