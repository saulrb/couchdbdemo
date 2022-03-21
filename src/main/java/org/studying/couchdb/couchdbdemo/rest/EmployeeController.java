package org.studying.couchdb.couchdbdemo.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.*;
import org.studying.couchdb.couchdbdemo.dto.APIErrorDto;
import org.studying.couchdb.couchdbdemo.dto.EmployeeDto;
import org.studying.couchdb.couchdbdemo.services.EmployeeService;

import java.util.List;

import static org.springframework.http.MediaType.*;


@RestController
@RequestMapping("/api/")
public class EmployeeController {

    EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping("/employees/")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<EmployeeDto> getEmployees(@RequestParam(name = "page", required = false, defaultValue = "0" ) Integer page,
                                          @RequestParam(name = "size", required = false, defaultValue = "10") Integer size) {
        return this.employeeService.findAll(page,size);
    }


    @PostMapping(value = "/employees",consumes = { APPLICATION_JSON_VALUE, APPLICATION_XML_VALUE})
    @ResponseStatus(HttpStatus.CREATED)
    public EmployeeDto createEmployee(@RequestBody EmployeeDto employeeDto) {
        return this.employeeService.create(employeeDto);
    }

    @PutMapping(value = "/employees", consumes = { APPLICATION_JSON_VALUE, APPLICATION_XML_VALUE})
    @ResponseStatus(HttpStatus.ACCEPTED)
    public EmployeeDto updateEmployee(@RequestBody EmployeeDto employeeDto) {
        return this.employeeService.update(employeeDto);
    }

    @DeleteMapping("/employees/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public APIErrorDto deleteEmployee(@PathVariable(value = "id") String id){
        this.employeeService.delete(id);
        return new APIErrorDto("DELETED","Successes");
    }
}
