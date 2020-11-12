package Assigment.Assignment.restservice;
/*Author-Neha
  Input- Read the incoming request, parses the input & gets the unit name and conversion factor
  Output- returns jason object with unit_name and multiplication_factor value
  Purpose- Reads the incoming requests, parses inputs, converts data as per provided input and returns converted values
* */
import Assigment.Assignment.restservice.conversionData.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
@RestController
public class ConversionController {

    //private static final String template = "Hello, %s!";
    private String unit_name = "";
    HashMap<String,ConversionData> map;
    public ConversionController()
    {
        Conversion obj = new Conversion();
        map = obj.conversionUnits;
    }

    @GetMapping("/units/si")
    public Conversion conversion(@RequestParam(value = "units", defaultValue = "Long") String units) {
        String[] parsedData = getConversionSet(units);
        String firstUnit="";
        String secondUnit="";
        if(parsedData != null && parsedData.length > 2) {
            firstUnit = parsedData[0];
            secondUnit = parsedData[1];
        }
        else{
            return new Conversion("Not valid", "Not valid");
        }
        String symbol = parsedData[2];
        String multiplicationFac = getMultiplicationFactor(parsedData,map);
        ConversionData temp = map.getOrDefault(firstUnit,new ConversionData("default","default","0","default"));
        StringBuilder s = new StringBuilder();
        for(int i=temp.getSiConversion().length() -1; i >= 0; i--)
        {
          if(!Character.isDigit(temp.getSiConversion().charAt(i)))
          {
              s = s.append(temp.getSiConversion().charAt(i));
          }
          else{
              break;
          }
        }
        unit_name = s.reverse().toString();
        if(!secondUnit.isEmpty()){
        ConversionData secondTemp = map.getOrDefault(secondUnit,new ConversionData());
        StringBuilder p = new StringBuilder();
        for(int i=secondTemp.getSiConversion().length() -1; i > 0; i--)
        {
            char checkTheSec = secondTemp.getSiConversion().charAt(i);
            if(Character.isLetter(checkTheSec))
            {
                p = p.append(secondTemp.getSiConversion().charAt(i));
            }
            else{
                break;
            }
        }
         unit_name = unit_name + symbol + p.reverse().toString();
        }
        return new Conversion(unit_name, multiplicationFac);
    }

    public String[] getConversionSet(String units)
    {
        String firstUnit ="";
        String secondUnit ="";
        String symbol ="";
        if(units.charAt(0) =='(')
        {   int j=1;
            StringBuilder parseInput = new StringBuilder();
            StringBuilder parseInputSecond = new StringBuilder();
            while(j < units.length() && Character.isLetter(units.charAt(j))){
                parseInput = parseInput.append(units.charAt(j++));
            }
            firstUnit = parseInput.toString();
            if(j < units.length() && units.charAt(j) == '/')
            {
                symbol ="/";
                while(j < units.length()-1 && Character.isLetter(units.charAt(++j))){
                    parseInputSecond = parseInputSecond.append(units.charAt(j));
                }
                secondUnit = parseInputSecond.toString();
            }
            if(j < units.length() && units.charAt(j) == '*')
            {
                symbol ="*";
                while(j < units.length()-1 && Character.isLetter(units.charAt(++j))){
                    parseInputSecond.append(units.charAt(j));
                }
                secondUnit = parseInputSecond.toString();
            }
            //if(j < units.length() && units.charAt(j) == '+')
                if(j < units.length() && (units.charAt(j) == '+') || units.charAt(j)==' ')
                {
                symbol ="+";
                while(j < units.length()-1 && Character.isLetter(units.charAt(++j))){
                    parseInputSecond.append(units.charAt(j));
                }
                secondUnit = parseInputSecond.toString();
            }
            if(j < units.length() && units.charAt(j) == '-')
            {
                symbol = "-";
                while(j < units.length()-1 && Character.isLetter(units.charAt(++j))){
                    parseInputSecond.append(units.charAt(j));
                }
                secondUnit = parseInputSecond.toString();
            }
        }
        else{
            int k=0;
            StringBuilder parseInput = new StringBuilder();
            StringBuilder parseInputSec = new StringBuilder();
            while(k < units.length() && Character.isLetter(units.charAt(k)) ){
                parseInput.append(units.charAt(k++));
                firstUnit = parseInput.toString();
            }
            if(k < units.length() && units.charAt(k) == '/')
            {
                symbol ="/";
                while( k < units.length()-1 && Character.isLetter(units.charAt(++k))){
                    parseInputSec.append(units.charAt(k));
                    secondUnit = parseInputSec.toString();
                }
            }
            if(k < units.length() && units.charAt(k) == '*')
            {
                symbol ="*";
                while(k < units.length()-1 && Character.isLetter(units.charAt(++k))){
                    parseInputSec.append(units.charAt(k));
                    secondUnit = parseInputSec.toString();
                }
            }
            if(k < units.length() && (units.charAt(k) == '+'))
            {
                symbol ="+";
                while(k < units.length()-1 && Character.isLetter(units.charAt(++k))){
                    parseInputSec.append(units.charAt(k));
                    secondUnit = parseInputSec.toString();
                }
            }
            if(k < units.length() && units.charAt(k) == '-')
            {
                symbol = "-";
                while(k < units.length()-1 && Character.isLetter(units.charAt(++k))){
                    parseInputSec.append(units.charAt(k));
                    secondUnit = parseInputSec.toString();
                }
            }
        }
        if(!firstUnit.isEmpty() && !secondUnit.isEmpty() && !symbol.isEmpty())
        return new String[]{firstUnit,secondUnit,symbol};
        else{
         return null;
        }
    }

    public String getMultiplicationFactor(String[] units, Map<String,ConversionData> map)
    {
      String firstUnit = units[0];
      String secondUnit = units[1];
      ConversionData conversionFactor = map.getOrDefault(firstUnit,new ConversionData("default","default","default","default"));
      String conversionFormula = conversionFactor.getSiConversion();
      int j = conversionFormula.length()-1;
      while(j > 0 && !Character.isDigit(conversionFormula.charAt(j)))
      {
          j--;
      }
        if(conversionFormula.charAt(0) == '(') {
            conversionFormula = conversionFormula.substring(1, j-1);
        }
        else{
            conversionFormula = j!=0 ? conversionFormula.substring(0, j+1) : "0";

        }
        ConversionData conversionFactorSec = map.get(secondUnit);

        String conversionFormulaSec = conversionFactorSec.getSiConversion();
        int k = conversionFormulaSec.length()-1;
        while(k > 0 && Character.isLetter(conversionFormulaSec.charAt(k)))
        {
            k--;
        }
        if(conversionFormulaSec.charAt(0) == '(') {
            conversionFormulaSec = conversionFormulaSec.substring(1, k - 1);
        }
         else  conversionFormulaSec = k!=0 ? conversionFormulaSec.substring(0,k+1) :"0";
      //String evaluated = (conversionFormula + units[2] + conversionFormulaSec);
        Double evaluation =0.0;
      if(units[2] =="/")
      {
         evaluation = Double.valueOf(conversionFormula)/Double.valueOf(conversionFormulaSec);
      }
      if(units[2] =="*")
        {
            evaluation = Double.valueOf(conversionFormula) * Double.valueOf(conversionFormulaSec);
        }
        if(units[2] =="+")
        {
            evaluation = Double.valueOf(conversionFormula) + Double.valueOf(conversionFormulaSec);
        }
        if(units[2] =="-")
        {
            evaluation = Double.valueOf(conversionFormula)-Double.valueOf(conversionFormulaSec);
        }
        return String.valueOf(evaluation);
    }

}