package Assigment.Assignment.restservice.conversionData;
/*
Author- Neha
Purpose- This class file defines the structure of conversion data which will be stored in HashMap
 */
public class ConversionData{
    String name;
    String symbol;
    String quantity;
    String siConversion;
    public ConversionData(String name, String symbol, String quantity, String siConversion)
    {
        this.name = name;
        this.symbol = symbol;
        this.quantity = quantity;
        this.siConversion = siConversion;
    }
    public ConversionData()
    {};

    public String getName() {
        return name;
    }

    public String getQuantity() {
        return quantity;
    }

    public String getSiConversion() {
        return siConversion;
    }

    public String getSymbol() {
        return symbol;
    }
}