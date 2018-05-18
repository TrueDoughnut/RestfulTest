package com.cfs.illinois.employeepay;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class EmployeeController {

    private static final String tag = "/employee";

    @RequestMapping(value = tag + "/id")
    public Object getEmployee(@RequestParam(value="id", required = false, defaultValue = "0") int id){
        return ReadILEmployeePay.employees.get(id);
    }

    @RequestMapping(value = tag + "/name", params = "name")
    public Object getEmployeeW(@RequestParam(value = "name") String name){
        if(name.contains(" ")) {
            for (int i = 0; i < ReadILEmployeePay.employees.size(); i++) {
                if(ReadILEmployeePay.employees.get(i).getName().equalsIgnoreCase(name)){
                    return ReadILEmployeePay.employees.get(i);
                }
            }
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        }
        return getEmployeeWithSearch(name);
    }

    @RequestMapping(value = tag + "/name", params = "search")
    public Object getEmployeeWithSearch(@RequestParam(value="search") String search){
        String[] allSearchWords = search.split(" ");
        for(int i = 0; i < ReadILEmployeePay.employees.size(); i++){
            String[] data = ReadILEmployeePay.employees.get(i).getName().split(" ");
            for(String str : allSearchWords){
                for(String s : data){
                    if(str.equalsIgnoreCase(s)){
                        return ReadILEmployeePay.employees.get(i);
                    }
                }
            }
        }
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
