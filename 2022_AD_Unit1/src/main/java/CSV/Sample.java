/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CSV;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 *
 * @author joange
 */
public class Sample {
    
    private void showCSV(String filename,boolean isHeader,String separator) throws IOException{
        
        // Read one file by one Line
        List<String> records=Files.readAllLines(Paths.get(filename));
        
        //print headers, only if exists
        if (isHeader){
            String line=records.get(0);
            records.remove(0);
            String []headers=line.split(separator);
            int i=0;
            for (String header : headers) {
                System.out.printf("%15s",header);
                i+=15;
            }
            System.out.println("");
            imprimirCaracterRepe("-", i+headers.length+1);
            
        }
        
        // print values
        for (String record : records) {
            String []values=record.split(separator);
            for (String value : values) {
                System.out.printf("%15s",value);
            }
            System.out.println("");
        }
        
        
    }
    
    private void imprimirCaracterRepe(String car,int n){
        for (int i = 0; i < n; i++) {
            System.out.print(car);
        }
        System.out.println();
            
}
    
    private void showCSVCols(String filename,boolean isHeader,String separator) throws IOException{
        
        // Read one file by one Line
        List<String> records=Files.readAllLines(Paths.get(filename));
        
        int[]colsSize=calculateMaxColSize(records, separator);
        
        //print headers, only if exists
        if (isHeader){
            String line=records.get(0);
            records.remove(0);
            String []headers=line.split(separator);
            int tam=0;
            System.out.print("|");
            for (int i = 0; i < headers.length; i++) {
                 System.out.printf("%"+colsSize[i]+"s|",headers[i]);
                 tam+=colsSize[i];
            }
            tam+=headers.length+1;
            System.out.println("");
            imprimirCaracterRepe("-", tam);
        }
        
        // print values
        for (String record : records) {
            String []values=record.split(separator);
            System.out.print("|");
            for (int i = 0; i < values.length; i++) {
                 System.out.printf("%"+colsSize[i]+"s|",values[i]);
            }
            System.out.println("");
        }
        
        
    }
    
    
    private int[]calculateMaxColSize(List<String> lines,String separator){
        // array containing the maximun sizes
        int []maxColSizes= new int[lines.get(0).split(separator).length];
        
        for (String line : lines) {
            String elements[]=line.split(separator);
            for (int i = 0; i < elements.length; i++) {
                if(elements[i].length()>maxColSizes[i])
                    maxColSizes[i]=elements[i].length();
            }
        }
        
        return maxColSizes;
    }
    
    
    public static void main(String[] args) throws IOException {
        
        String filename="mlb_players.csv";
        
        Sample sam=new Sample();
        
       // sam.showCSV(filename, true, ",");
        
       sam.showCSVCols(filename, true, ",");
        
    }
}
