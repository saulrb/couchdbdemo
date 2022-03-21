package org.studying.couchdb.couchdbdemo.mapper;

import org.mapstruct.Mapper;
import org.studying.couchdb.couchdbdemo.dto.EmployeeDto;
import org.studying.couchdb.couchdbdemo.model.Employee;

import java.util.List;

@Mapper( componentModel = "spring")
public interface MapStructMapper {

    EmployeeDto employeeToEmployeeDto(Employee employee);

    Employee employeeDtoToEmployee(EmployeeDto employeeDto);

    List<EmployeeDto> employeesToEmployeeAllDtos(Iterable<Employee> employees);

}
