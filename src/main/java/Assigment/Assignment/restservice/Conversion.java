package Assigment.Assignment.restservice;
import Assigment.Assignment.restservice.conversionData.*;
/*
Autho- Neha
Purpose- This class is pojo for storing the conversion data in hashMap
 */
import java.util.HashMap;

public class Conversion {

    private String unit_name;
    private  String multiplication_factor;
    HashMap <String, ConversionData> conversionUnits;

    /* Data for conversion unit is stored in static HashMap
       Todo- In future we need to read these conversion data from flat file or database so that if more conversion units needs to be added code will be untouched
    * */
    public Conversion(String unit_name, String multiplication_factor) {
        this.unit_name = unit_name;
        this.multiplication_factor = multiplication_factor;
        conversionUnits = new HashMap<>();
        conversionUnits.put("minute", new ConversionData("minute","min","time","60s"));
        conversionUnits.put("hour", new ConversionData("hour","h","time","3600s"));
        conversionUnits.put("day", new ConversionData("day","d","time","86400s"));
        String convetedVal = String.valueOf(3.14159/180) + "rad";
        String convretedValOne = String.valueOf(3.14159/10800) +"rad";
        String convretedValTwo = String.valueOf(3.14159/648000) +"rad";
        conversionUnits.put("default", new ConversionData("default","","0","default"));
        conversionUnits.put("degree", new ConversionData("degree","0","unitless/plane angle",convetedVal));
        conversionUnits.put("arcminute", new ConversionData("arcminute","'","unitless/plane angle",convretedValOne));
        conversionUnits.put("arcsecond", new ConversionData("arcsecond","''","unitless/plane angle",convretedValTwo));
        conversionUnits.put("hectare", new ConversionData("hectare","ha","area","10000 m*m"));
        conversionUnits.put("litre", new ConversionData("litre","L","volume","0.001 m*m*m"));
        conversionUnits.put("tonne", new ConversionData("tonne","t","mass","1000 kg"));
    }

    public Conversion(){
        conversionUnits = new HashMap<>();
        String convetedVal = String.valueOf(3.14159/180) + "rad";
        String convretedValOne = String.valueOf(3.14159/10800) +"rad";
        String convretedValTwo = String.valueOf(3.14159/648000) +"rad";
        conversionUnits.put("default", new ConversionData("default","","0","default"));
        conversionUnits.put("minute", new ConversionData("minute","min","time","60s"));
        conversionUnits.put("hour", new ConversionData("hour","h","time","3600s"));
        conversionUnits.put("day", new ConversionData("day","d","time","86400s"));
        conversionUnits.put("degree", new ConversionData("degree","0","unitless/plane angle",convetedVal));
        conversionUnits.put("arcminute", new ConversionData("arcminute","'","unitless/plane angle",convretedValOne));
        conversionUnits.put("arcsecond", new ConversionData("arcsecond","''","unitless/plane angle",convretedValTwo));
        conversionUnits.put("hectare", new ConversionData("hectare","ha","area","10000 m*m"));
        conversionUnits.put("litre", new ConversionData("litre","L","volume","0.001 m*m*m"));
        conversionUnits.put("tonne", new ConversionData("tonne","t","mass","1000 kg"));
    };

    public String getUnit_name() {
        return unit_name;
    }

    public String getMultiplication_factor() {
        String[] parseContent = multiplication_factor.split("/");
        multiplication_factor = parseContent[0];
        return multiplication_factor;
    }
}