package com.cfs.controllers;

import com.cfs.general.Record;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class EmployeeController {

    private static final String tag = "/employee";
    public static List<Record> list;

    @RequestMapping(value = tag + "/id")
    public Object getEmployee(@RequestParam(value="id", required = false, defaultValue = "0") int id){
        return list.get(id).run();
    }

    @RequestMapping(value = tag + "/name", params = "name")
    public Object getEmployee(@RequestParam(value = "name") String name){
        if(name.contains(" ")) {
            for (int i = 0; i < list.size(); i++) {
                if(list.get(i).data.get("Employee Name").equalsIgnoreCase(name)){
                    return list.get(i).run();
                }
            }
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        }
        return getEmployeeWithSearch(name);
    }

    @RequestMapping(value = tag + "/name", params = "search")
    public Object getEmployeeWithSearch(@RequestParam(value="search") String search){
        String[] allSearchWords = search.split(" ");
        for(int i = 0; i < list.size(); i++){
            String[] data = list.get(i).data.get("Employee Name").split(" ");
            for(String str : allSearchWords){
                for(String s : data){
                    if(str.equalsIgnoreCase(s)){
                        return list.get(i).run();
                    }
                }
            }
        }
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
