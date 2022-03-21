package org.studying.couchdb.couchdbdemo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.studying.couchdb.couchdbdemo.dto.EmployeeDto;
import org.studying.couchdb.couchdbdemo.mapper.MapStructMapper;
import org.studying.couchdb.couchdbdemo.model.Employee;
import org.studying.couchdb.couchdbdemo.repositories.EmployeePagingRepository;
import org.studying.couchdb.couchdbdemo.repositories.EmployeeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImp implements EmployeeService{

    EmployeeRepository employeeRepository;

    EmployeePagingRepository employeePagingRepository;

    MapStructMapper mapStructMapper;

    @Autowired
    public EmployeeServiceImp(EmployeeRepository employeeRepository, MapStructMapper mapStructMapper, EmployeePagingRepository employeePagingRepository){
        this.employeeRepository = employeeRepository;
        this.mapStructMapper = mapStructMapper;
        this.employeePagingRepository = employeePagingRepository;
    }

    @Override
    public List<EmployeeDto> findAll(Integer page, Integer size) {
        Sort defaultSort = Sort.by("firstName").ascending();
        Pageable pageable = PageRequest.of(page,size,defaultSort);
        return mapStructMapper.employeesToEmployeeAllDtos(employeePagingRepository.findAll(pageable));
    }

    @Override
    public List<EmployeeDto> findByName(String name) {
        return mapStructMapper.employeesToEmployeeAllDtos(employeeRepository.findByFirstName(name));
    }

    @Override
    public EmployeeDto create(EmployeeDto employeeDto) {
        return  mapStructMapper.employeeToEmployeeDto(employeeRepository.save(mapStructMapper.employeeDtoToEmployee(employeeDto)));
    }

    @Override
    public void delete(String id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public EmployeeDto update(EmployeeDto employeeDto) {
        return mapStructMapper.employeeToEmployeeDto(employeeRepository.save(mapStructMapper.employeeDtoToEmployee(employeeDto)));
    }
}
