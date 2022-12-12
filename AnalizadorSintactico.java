import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class AnalizadorSintactico {
    public static void analisisS(String nombreArchivo){
        String linea;
        int contadorLinea=0, contadorReal=1;
        boolean iniciar = false, continuar=true, exito = false;
        
        File codigo = new File(nombreArchivo);
 
        try (BufferedReader br = new BufferedReader(new FileReader(codigo)))
        {
            br.mark(100000);
            while ((linea = br.readLine()) != null){

                contadorLinea++;

            }

            br.reset();            

            String[] arregloLex = new String[contadorLinea];
            contadorLinea=0;
            
            while ((linea = br.readLine()) != null){
                arregloLex[contadorLinea] = linea;
                contadorLinea++;
            } 

            contadorLinea=0;     

            while (continuar == true){
                //System.out.println("ay");
                if (arregloLex[contadorLinea].startsWith("#")){ 
                    contadorLinea++;
                    contadorReal++;
                    System.out.println("coment");
                    if (arregloLex[contadorLinea+1]==null){
                        break;
                    }
                    continue;
                }

                if (ER.palabrasReservadas(arregloLex[contadorLinea])){
                    System.out.println("Reservada");
                    contadorReal++;
                    if (arregloLex[contadorLinea].equals("PROGRAMA")){
                        if (iniciar==false){
                            contadorLinea++;
                            iniciar=true;
                            if (ER.identificadores(arregloLex[contadorLinea])!=true){
                                //System.out.println("Error en la linea "+contadorReal);
                                break;
                            }else {
                                contadorLinea++;
                                continue;
                            }                        
                        } else {
                            //System.out.println("Error en la linea "+contadorReal);
                            break;
                        }
                    }

                    if (arregloLex[contadorLinea].equals("IMPRIME")){
                        contadorLinea++;
                        if (!(ER.identificadores(arregloLex[contadorLinea]) || ER.literalesDeTexto(arregloLex[contadorLinea]) || ER.literalesNumericasDecimales(arregloLex[contadorLinea]) || ER.literalesNumericasHexadecimales(arregloLex[contadorLinea]))){
                            //System.out.println("Error en la linea "+contadorReal);
                            break;     
                        } else {
                            contadorLinea++;
                            continue;
                        }
                    }
                    if (arregloLex[contadorLinea].equals("LEE")){
                        contadorLinea++;
                        if (!(ER.identificadores(arregloLex[contadorLinea]))){
                            //System.out.println("Error en la linea "+contadorReal);
                            break;     
                        } else {
                            contadorLinea++;
                            continue;
                        }
                    }

                    if (arregloLex[contadorLinea].equals("FINPROG")){
                        if (contadorLinea == arregloLex[contadorLinea].length()){
                            //System.out.println("Error en la linea "+contadorReal);
                            break;     
                        } else {
                            exito = true;
                            continuar = false;
                            break;
                        }
                    }

                } 
                
                if(ER.identificadores(arregloLex[contadorLinea])){
                    contadorReal++;
                    System.out.println("id");
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
                            }
                        }
                        continue;
                    } else {
                        //System.out.println("Error en la linea "+contadorReal);
                        break;
                    }

                }
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
        }

    }
}      

