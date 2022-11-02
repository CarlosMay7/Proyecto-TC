import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ManipuladorArchivos {
    
    public static void imprimirLista (ArrayList<String> lista, File archivoEscribir){

          try (FileWriter escritor = new FileWriter(archivoEscribir)){
            for (String palabra : lista){
                escritor.write(palabra+"\n");
            }
          } catch (IOException e){
            System.err.println("Ocurrio un error al escribir el archivo"+ e);
          }
    }

    public static void imprimirArreglos (String [][] matrizIds,String [][] matrizTxt, String [][] matrizVal, File archivoDeMatrices){
        int fila;

          try (FileWriter escritor = new FileWriter(archivoDeMatrices)){
            escritor.write("IDS\n");
            for (fila =0; fila<matrizIds.length; fila++){
                escritor.write(matrizIds[fila][0]+" "+matrizIds[fila][1]+"\n");
            }
            escritor.write("\n");
            escritor.write("TXT\n");
            for (fila =0; fila<matrizTxt.length; fila++){
                escritor.write(matrizTxt[fila][0]+" "+matrizTxt[fila][1]+"\n");
            }
            escritor.write("\n");
            escritor.write("VAL\n");
            for (fila =0; fila<matrizVal.length; fila++){
                escritor.write(matrizVal[fila][0]+" "+matrizVal[fila][1]+"\n");
            }
          } catch (IOException e){
            System.err.println("Ocurrio un error al escribir el archivo"+ e);
          }  
    }

    public static void crearArchivo (File nombreArchivo){
      try {
        if (nombreArchivo.createNewFile())
        System.out.println("El archivo se ha creado correctamente");
        else{
        System.out.println("El archivo " + nombreArchivo+" ya existe, se sobreescribira");
        }
    } catch (IOException ioe) {
        ioe.printStackTrace();
    }
    }
}
