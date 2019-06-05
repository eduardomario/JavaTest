package com.axity.test;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.Normalizer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        App app = new App();
        String dia = "2019-04-30";
        System.out.println(app.convertStringToDate(dia));
    }

    private String limpiarAcentos(String cadena) {
        String limpio =null;
        if (cadena !=null) {
            String valor = cadena;
            limpio = Normalizer.normalize(valor, Normalizer.Form.NFKD);
            limpio = limpio.replaceAll("[^\\p{ASCII}]", "");
        }
        return limpio;
    }

    private String cambiarAcentos(String cadena) {        
        // convert String to char[] array
		char[] chars = cadena.toCharArray();

		// iterate over char[] array and evaluate special chars
		for (int i = 0; i < chars.length; i++) {
			if(chars[i] == 'á'){
                chars[i] = '\u00e1';
            }
            else if(chars[i] == 'é' ){
                chars[i] = '\u00e9';
            }
            else if(chars[i] == 'í'){
                chars[i] = '\u00ed';
            }
            else if(chars[i] == 'ó'){
                chars[i] = '\u00f3';
            }
            else if(chars[i] == 'ú'){
                chars[i] = '\u00fa';
            }
            else if(chars[i] == 'Á'){
                chars[i] = '\u00c1';
            }            
            else if(chars[i] == 'É'){
                chars[i] = '\u00c9';
            }            
            else if(chars[i] == 'Í'){
                chars[i] = '\u00cd';
            }            
            else if(chars[i] == 'Ó'){
                chars[i] = '\u00d3';
            }            
            else if(chars[i] == 'Ú'){
                chars[i] = '\u00da';
            }
        }
        // return String from char[] array
        String cambiado = new String(chars);
        return cambiado;
    }

    public long añadirDecimalesAEntero(BigDecimal decimal){
        BigDecimal multiply = new BigDecimal(100);
        decimal = decimal.multiply(multiply);
        long entero = decimal.longValue();
        return entero;
    }

    public String quitarPuntoDecimal(String monto){
        return monto.replace(".", "");
    }

    public String formatoDecimal(String numero){
        BigDecimal numeroBig = new BigDecimal(numero);
        numeroBig.setScale(2, BigDecimal.ROUND_HALF_UP);
        return numeroBig.toPlainString();
    }

    private String dateConverter(String fecha) {
        SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy");
        String dateStr = "";
        try {
            Date date = sdf.parse(fecha);
            sdf.applyPattern("MM/dd/yyyy");
            dateStr = sdf.format(date);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        return dateStr;
    }

    private Date convertStringToDate(String date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dateStr = "";
        try {
            Date oldDate = sdf.parse(date);
            sdf.applyPattern("MM/dd/yyyy");
            dateStr = sdf.format(oldDate);
            return new SimpleDateFormat("MM/dd/yyyy").parse(dateStr);
        } catch (ParseException ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
