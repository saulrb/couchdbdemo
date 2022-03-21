package org.studying.couchdb.couchdbdemo.services;


import org.studying.couchdb.couchdbdemo.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {

    List<EmployeeDto> findAll(Integer page, Integer size);

    List<EmployeeDto> findByName(String name);

    EmployeeDto create(EmployeeDto employeeDto);

    void delete(String id);

    EmployeeDto update(EmployeeDto employeeDto);
}
