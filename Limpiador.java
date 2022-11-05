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
        }

        if (sigue == true){
            if(cadenaLimpiar.contains(" ")){
                cadenaLimpiar.replaceAll(" ", "");
            }
            if (cadenaLimpiar.contains("=")){
                palabrasRevisando = limpiarAsignacion(cadenaLimpiar);
                palabrasLimpias.add(palabrasRevisando[0]);
                cadenaLimpiar = limpiarAsignacion(cadenaLimpiar)[1];
            }
    
            cadenaSinSuma = limpiarSuma(cadenaLimpiar);
            for (int contsigno=0; contsigno<cadenaSinSuma.length-1;contsigno++){
                cadenaSinSuma[contsigno].concat("+");
            }
    
            for (contadorResta =0; contadorResta<cadenaSinSuma.length; contadorResta++){
                cadenaSinResta = limpiarResta(cadenaSinSuma[contadorResta]);
                for (contadorMulti=0; contadorMulti<cadenaSinResta.length;contadorMulti++){ 
                    cadenaSinMulti = limpiarMulti(cadenaSinResta[contadorMulti]);
                    for (contadorDiv=0; contadorDiv<cadenaSinMulti.length;contadorDiv++){
                        cadenaSinDivision = limpiarDiv(cadenaSinMulti[contadorDiv]);
                        for (contadorPalabrasLimpias=0; contadorPalabrasLimpias<cadenaSinDivision.length;contadorPalabrasLimpias++){
                            if(cadenaSinDivision[contadorPalabrasLimpias].contains(" ")){
                                cadenaSinDivision[contadorPalabrasLimpias] = cadenaSinDivision[contadorPalabrasLimpias].replaceAll(" ", "");
                            }
                            palabrasLimpias.add(cadenaSinDivision[contadorPalabrasLimpias ]); 
                        }
                    }
                }
            }
        }
        
        return palabrasLimpias;
    }

    public static ArrayList<String> limpiarConOperadores (String cadenaLimpiar){
        String [] palabrasReservadas = {"PROGRAMA", "FINPROG", "IMPRIME","LEE"};
        String [] palabrasRevisando,cadenaSinReservadas,cadenaSinSuma,cadenaSinResta, cadenaSinDivision, cadenaSinMulti;
        ArrayList<String> palabrasLimpias = new ArrayList<>();
        int contadorResta, contadorMulti, contadorDiv, contadorPalabrasLimpias;
        boolean sigue = true, encontrada=false;
        if (ER.comentario(cadenaLimpiar)){ 
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
        }

        if (sigue == true){
            if(cadenaLimpiar.contains(" ")){
                cadenaLimpiar = cadenaLimpiar.replaceAll(" ", "");
            }
            if (cadenaLimpiar.contains("=")){
                palabrasRevisando = limpiarAsignacion(cadenaLimpiar);
                palabrasLimpias.add(palabrasRevisando[0]);
                palabrasLimpias.add("=");
                cadenaLimpiar = limpiarAsignacion(cadenaLimpiar)[1];
            }
    
            cadenaSinSuma = limpiarSuma(cadenaLimpiar);
            for (int contsigno1=0; contsigno1<(cadenaSinSuma.length)-1;contsigno1++){
                cadenaSinSuma[contsigno1]= cadenaSinSuma[contsigno1].concat("+");
            }
    
            for (contadorResta =0; contadorResta<cadenaSinSuma.length; contadorResta++){
                cadenaSinResta = limpiarResta(cadenaSinSuma[contadorResta]);
                for (int contsigno2=0; contsigno2<(cadenaSinResta.length)-1;contsigno2++){
                    cadenaSinResta[contsigno2]= cadenaSinResta[contsigno2].concat("-");
                }
                for (contadorMulti=0; contadorMulti<cadenaSinResta.length;contadorMulti++){ 
                    cadenaSinMulti = limpiarMulti(cadenaSinResta[contadorMulti]);
                    for (int contsigno3=0; contsigno3<(cadenaSinMulti.length)-1;contsigno3++){
                        cadenaSinMulti[contsigno3]= cadenaSinMulti[contsigno3].concat("*");
                    }
                    for (contadorDiv=0; contadorDiv<cadenaSinMulti.length;contadorDiv++){
                        cadenaSinDivision = limpiarDiv(cadenaSinMulti[contadorDiv]);
                        for (int contsigno4=0; contsigno4<(cadenaSinDivision.length)-1;contsigno4++){
                            cadenaSinDivision[contsigno4]= cadenaSinDivision[contsigno4].concat("/");
                            for(String str : cadenaSinDivision){
                                System.out.println(str);
                            }
                        }

                        for (contadorPalabrasLimpias=0; contadorPalabrasLimpias<cadenaSinDivision.length;contadorPalabrasLimpias++){

                            if(cadenaSinDivision[contadorPalabrasLimpias].contains(" ")){
                                cadenaSinDivision[contadorPalabrasLimpias] = cadenaSinDivision[contadorPalabrasLimpias].replaceAll(" ", "");
                            }
                            if (cadenaSinDivision[contadorPalabrasLimpias].contains("+")){
                                palabrasLimpias.add(cadenaSinDivision[contadorPalabrasLimpias].substring(0,cadenaSinDivision[contadorPalabrasLimpias].length()-1)); 
                                palabrasLimpias.add("+");
                                continue;
                            } 
                            if (cadenaSinDivision[contadorPalabrasLimpias].contains("-")){
                                palabrasLimpias.add(cadenaSinDivision[contadorPalabrasLimpias].substring(0,cadenaSinDivision[contadorPalabrasLimpias].length()-1)); 
                                palabrasLimpias.add("-");
                                continue;
                            } 
                            if (cadenaSinDivision[contadorPalabrasLimpias].contains("*")){
                                palabrasLimpias.add(cadenaSinDivision[contadorPalabrasLimpias].substring(0,cadenaSinDivision[contadorPalabrasLimpias].length()-1)); 
                                palabrasLimpias.add("*");
                                continue;
                            } 
                            if (cadenaSinDivision[contadorPalabrasLimpias].contains("/")){
                                palabrasLimpias.add(cadenaSinDivision[contadorPalabrasLimpias].substring(0,cadenaSinDivision[contadorPalabrasLimpias].length()-1)); 
                                palabrasLimpias.add("/");
                                continue;
                            } 
                            
                            palabrasLimpias.add(cadenaSinDivision[contadorPalabrasLimpias]);

                        }
                    }
                }
            }
        }

        return palabrasLimpias;
    }

    public static String [] limpiarAsignacion (String cadenaLimpiar){

        String[] asignacionSeparado = cadenaLimpiar.split("=");
        if(asignacionSeparado[0].contains(" ")){
            asignacionSeparado[0] = asignacionSeparado[0].replaceAll(" ", "");
        }
        
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
        String imprime [] = new String[2];

        for (String str : palabrasReservadas){
            if (cadenaLimpiar.contains(str)){
                if (!(str.equals("IMPRIME"))){
                    reservadasSeparado = limpiarEspacio(cadenaLimpiar);
                } else {
                    imprime[0]="IMPRIME";
                    imprime[1]=cadenaLimpiar.substring(8);
                    reservadasSeparado=imprime;
                }
            }
        }
        return reservadasSeparado;
    }

    public static String limpiarHexa (String hexa){

        String[] hexaSeparado = hexa.split("x");

        return hexaSeparado[1];
    }

    public static String convertirHexaADecimal (String numeroConvertir){

        int numeroConvertido;
        numeroConvertir = limpiarHexa(numeroConvertir);
        numeroConvertido = Integer.parseInt(numeroConvertir,16);
        String numeroCadena = Integer.toString(numeroConvertido);
        return numeroCadena;
    }
}
