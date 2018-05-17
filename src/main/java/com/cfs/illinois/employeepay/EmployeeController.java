package com.cfs.illinois.employeepay;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class EmployeeController {

    private static final String tag = "/employee";

    @RequestMapping(tag + "/id")
    public Object getEmployee(@RequestParam(value="id", required = false, defaultValue = "0") int id){
        return ReadILEmployeePay.employees.get(id);
    }

    @RequestMapping(tag + "/name")
    public Object getEmployee(@RequestParam(value = "name") String name){
        int index = -1;
        for (int i = 0; i < ReadILEmployeePay.employees.size(); i++) {
            if (ReadILEmployeePay.employees.get(i).getName().equalsIgnoreCase(name)) {
                index = i;
            }
        }
        if (index >= 0) {
            return ReadILEmployeePay.employees.get(index);
        } else {
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        }
    }
}
