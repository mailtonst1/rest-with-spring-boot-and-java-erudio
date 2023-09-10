package br.com.erudio.converter;

public class Convertes {

    public static Double convertToDouble(String strNumber) {
        if(strNumber == null) return 0D;

        String number = strNumber.replaceAll("," ,".");
        if(isNumeric(number)) return  Double.parseDouble(number);
        return 0D;
    }

    public static Boolean isNumeric(String strNumber) {
        if(strNumber == null)  return null;
        String number = strNumber.replaceAll("," ,".");
        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }

}
