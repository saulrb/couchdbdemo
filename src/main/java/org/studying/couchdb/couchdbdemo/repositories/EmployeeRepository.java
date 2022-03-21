package org.studying.couchdb.couchdbdemo.repositories;

import com.couchbase.client.java.query.QueryScanConsistency;
import org.springframework.data.repository.CrudRepository;
import org.studying.couchdb.couchdbdemo.annotations.MyRepoAnnotation;
import org.studying.couchdb.couchdbdemo.model.Employee;

import java.util.List;

@MyRepoAnnotation( query = QueryScanConsistency.REQUEST_PLUS )
public interface EmployeeRepository  extends CrudRepository<Employee, String> {
    List<Employee> findByFirstName(String firstName);
    List<Employee> findByLastName(String lastName);
}
