package com.cfs.illinois.employeepay;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord; 

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import java.nio.file.Files; 
import java.nio.file.Paths;

public class ReadCSVData {

    public final File file;
    public List<Employee> employees;
    public final File data = new File("src\\main\\java\\com\\cfs\\illinois\\employeepay\\data.json");

    public ReadCSVData(File file){
        this.file = file;
        run();
    }

    public ReadCSVData(String string){
        this.file = new File(string);
        run();
    }

    /*public void run(){
        Pattern pattern = Pattern.compile(",");
        try(BufferedReader in = new BufferedReader(new FileReader(file))){
            employees = in.lines().skip(1).map(line -> {
                String[] arr = pattern.split(line);
                return new Employee(arr[4], arr[2], arr[3], arr[5], arr[6], arr[7]);
            }).collect(Collectors.toList());

            ObjectMapper mapper = new ObjectMapper();
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            mapper.writeValue(data, employees);

        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        } catch (NumberFormatException e){
            e.printStackTrace();
        }
    }*/
    
    public void run(){
        employees = new ArrayList<>();
        try(Reader reader = Files.newBufferedReader(Paths.get(file.getPath()));
            CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT
                                                .withFirstRecordAsHeader()
                                                .withIgnoreHeaderCase()
                                                .withTrim())
        ){
            for(CSVRecord record : csvParser){
                System.err.println(record.get("Employee Name"));
                Employee employee = new Employee(record.get("Employee Name"), record.get("Agency"),
                        record.get("Agency Division"), record.get("Position Title"),
                        record.get("Period Pay Rate"), record.get("YTD Gross"));
                employees.add(employee);
            }

            ObjectMapper mapper = new ObjectMapper();
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            mapper.writeValue(data, employees);

        } catch(IOException e){
            e.printStackTrace();    
        }
    }

    public static void main(String[] args){
        ReadCSVData test = new ReadCSVData("data\\ILEmployeePay.csv");
        //System.err.println("\n" + test.employees.get(0).getName() + " " + test.employees.get(0).getPeriodPayRate());
    }
}
