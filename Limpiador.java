import java.util.ArrayList;

public class Limpiador {

    public static ArrayList<String> limpiarTodo (String cadenaLimpiar){
        String [] palabrasReservadas = {"PROGRAMA", "FINPROG", "IMPRIME","LEE"};
        String [] palabrasRevisando,cadenaSinReservadas,cadenaSinSuma,cadenaSinResta, cadenaSinDivision, cadenaSinMulti;
        ArrayList<String> palabrasLimpias = new ArrayList<>();
        int contadorResta, contadorMulti, contadorDiv, contadorPalabrasLimpias;
        boolean sigue = true, encontrada=false;
        if (cadenaLimpiar.startsWith("#")){
            palabrasLimpias.add(cadenaLimpiar);
            encontrada=true;
            sigue = false;
        }
        for (int reservada =0; reservada<palabrasReservadas.length && encontrada==false; reservada++){
            if (cadenaLimpiar.contains(palabrasReservadas[reservada])){
                cadenaSinReservadas = limpiarReservadas(cadenaLimpiar, palabrasReservadas);
                for (String sinReservadas : cadenaSinReservadas){
                    palabrasLimpias.add(sinReservadas);
                }
                encontrada=true;
                sigue=false;
            }
            for (String sinReservadas : palabrasLimpias){
                System.out.println(sinReservadas);
            }     
        }

        if (sigue == true){
            if (cadenaLimpiar.contains("=")){
                palabrasRevisando = limpiarAsignacion(cadenaLimpiar);
                palabrasLimpias.add(palabrasRevisando[0]);
                cadenaLimpiar = limpiarAsignacion(cadenaLimpiar)[1];
            }
    
            cadenaSinSuma = limpiarSuma(cadenaLimpiar);
    
            for (contadorResta =0; contadorResta<cadenaSinSuma.length; contadorResta++){
                cadenaSinResta = limpiarResta(cadenaSinSuma[contadorResta]);
                for (contadorMulti=0; contadorMulti<cadenaSinResta.length;contadorMulti++){
                    cadenaSinMulti = limpiarMulti(cadenaSinResta[contadorMulti]);
                    for (contadorDiv=0; contadorDiv<cadenaSinMulti.length;contadorDiv++){
                        cadenaSinDivision = limpiarDiv(cadenaSinMulti[contadorDiv]);
                        for (contadorPalabrasLimpias=0; contadorPalabrasLimpias<cadenaSinDivision.length;contadorPalabrasLimpias++){
                            palabrasLimpias.add(cadenaSinDivision[contadorPalabrasLimpias ]); 
                        }
                    }
                }
            }
        }

        


        return palabrasLimpias;
        
    }

    public static String [] limpiarAsignacion (String cadenaLimpiar){

        String[] asignacionSeparado = cadenaLimpiar.split("=");
        
        return asignacionSeparado;
    }

    public static String [] limpiarSuma (String cadenaLimpiar){

        String[] sumaSeparado = cadenaLimpiar.split("\\+");

        return sumaSeparado;
    }

    public static String [] limpiarResta (String CadenaLimpiar){

        String[] restaSeparado = CadenaLimpiar.split("\\-");

        return restaSeparado;
    }

    public static String [] limpiarMulti (String CadenaLimpiar){

        String[] multiSeparado = CadenaLimpiar.split("\\*");

        return multiSeparado;
    }

    public static String [] limpiarEspacio (String CadenaLimpiar){

        String[] espacioSeparado = CadenaLimpiar.split(" ");

        return espacioSeparado;
    }



    public static String [] limpiarDiv (String CadenaLimpiar){

        String[] divSeparado = CadenaLimpiar.split("/");

        return divSeparado;
    }

    public static String[] limpiarReservadas (String cadenaLimpiar, String [] palabrasReservadas){
        String [] reservadasSeparado=null;


        for (String str : palabrasReservadas){
            if (cadenaLimpiar.contains(str)){
                reservadasSeparado = limpiarEspacio(cadenaLimpiar);
            }
        }
        return reservadasSeparado;
    }
    
}