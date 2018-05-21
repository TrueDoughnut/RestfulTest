package com.cfs;

import com.cfs.general.ReadCSV;
import com.cfs.controllers.EmployeeController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    public static void main(String[] args){
        run();
        SpringApplication.run(Application.class, args);
    }

    public static void run(){
        EmployeeController employeeController = new EmployeeController();
        ReadCSV readCSV = new ReadCSV("data\\ILEmployeePay.csv");
        readCSV.run();
        employeeController.list = readCSV.list;
    }

}
