import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class AnalizadorSintactico {
    public static void analisisS(String nombreArchivo){
        String linea, error="";
        int contadorLinea=0, contadorReal=1;
        boolean iniciar = false, continuar=true, exito = false;
        
        File codigo = new File(nombreArchivo);
 
        try (BufferedReader br = new BufferedReader(new FileReader(codigo)))
        {
            br.mark(100000);
            while ((linea = br.readLine()) != null){

                contadorLinea++;

            }

            int tamanoArreglo = contadorLinea;

            br.reset();            

            String[] arregloLex = new String[contadorLinea];
            contadorLinea=0;
            
            while ((linea = br.readLine()) != null){
                arregloLex[contadorLinea] = linea;
                contadorLinea++;
            } 

            contadorLinea=0;     

            while (continuar == true){
                if (arregloLex[contadorLinea].startsWith("#")){ 
                    contadorLinea++;
                    contadorReal++;
                    if (arregloLex[contadorLinea+1]==null){
                        break;
                    }
                    continue;
                }

                if (ER.palabrasReservadas(arregloLex[contadorLinea])){
                    contadorReal++;
                    if (arregloLex[contadorLinea].equals("PROGRAMA")){
                        if (iniciar==false){
                            contadorLinea++;
                            iniciar=true;
                            if (ER.identificadores(arregloLex[contadorLinea])!=true){
                                error = "Error: Después de PROGRAMA se esperaba un id";
                                break;
                            }else {
                                contadorLinea++;
                                continue;
                            }                        
                        } else {
                            error = "Error: No puede nombrar al programa 2 veces";
                            break;
                        }
                    }

                    if (arregloLex[contadorLinea].equals("IMPRIME")){
                        contadorLinea++;
                        if (ER.identificadores(arregloLex[contadorLinea]) || ER.literalesDeTexto(arregloLex[contadorLinea]) || ER.literalesNumericasDecimales(arregloLex[contadorLinea]) || ER.literalesNumericasHexadecimales(arregloLex[contadorLinea])){
                            contadorLinea++;
                            continue;
                        } else {
                            error = "Error: Después de IMPRIME se esperaba un id, literal de texto, decimal o hexadecimal";
                            break;     

                        }
                    }
                    if (arregloLex[contadorLinea].equals("LEE")){
                        contadorLinea++;
                        if (ER.identificadores(arregloLex[contadorLinea])){
                            contadorLinea++;
                            continue;
                        } else {
                            error = "Error: Después de LEE se esperaba un id";
                            break;     

                        }
                    }

                    if (arregloLex[contadorLinea].equals("FINPROG")){
                        if (contadorLinea+1 == tamanoArreglo){
                            exito = true;
                            continuar = false;
                            break;
                        } else {
                            error = "Solo puede colocar FINPROG al final del programa";
                            break;
                        }
                    }

                } 
                
                if(ER.identificadores(arregloLex[contadorLinea])){
                    contadorReal++;
                    contadorLinea++;
                    if (ER.asignacion(arregloLex[contadorLinea])){
                        contadorLinea++;
                        boolean sigue = true;
                        while (sigue){
                            if(ER.identificadores(arregloLex[contadorLinea]) || ER.literalesNumericasDecimales(arregloLex[contadorLinea]) ||  ER.literalesNumericasHexadecimales(arregloLex[contadorLinea])){
                                contadorLinea++;
                                if (ER.operadoresNumericos(arregloLex[contadorLinea])){
                                    contadorLinea++;
                                } else {
                                    sigue = false;
                                }
                            } else {
                                error = "Error: Después de asignacion se esperaba un id, literal decimal, hexadecimal u operador";
                                break;
                            }
                        }
                        continue;
                    } else {
                        error = "Error: Despues de ID se esperaba asignacion";
                        break;
                    }

                }
                error = "Error: Solo puede iniciar una linea con palabras reservadas o id";
                continuar= false;
            }
        }catch (IOException e) {
            System.out.println("No se encuentra un archivo con ese nombre");       
            e.printStackTrace();         
        }
            
        if(exito && iniciar){
            System.out.println("Compilacion exitosa");
        } else {
            System.out.println("Error en la linea "+contadorReal);
            System.out.println(error);
        }

    }
}      

