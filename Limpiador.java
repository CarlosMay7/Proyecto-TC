import java.util.ArrayList;

public class Limpiador {

    public static ArrayList<String> limpiarTodo (String cadenaLimpiar){

        String [] palabrasRevisando,cadenaSinSuma,cadenaSinResta, cadenaSinDivision, cadenaSinMulti;
        ArrayList<String> palabrasLimpias = new ArrayList<>();
        int contadorResta, contadorMulti, contadorDiv, contadorPalabrasLimpias;

        palabrasRevisando = limpiarAsignacion(cadenaLimpiar);
        palabrasLimpias.add(palabrasRevisando[0]);
        cadenaLimpiar = limpiarAsignacion(cadenaLimpiar)[1];

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

    public static String [] limpiarDiv (String CadenaLimpiar){

        String[] divSeparado = CadenaLimpiar.split("/");

        return divSeparado;
    }

}
