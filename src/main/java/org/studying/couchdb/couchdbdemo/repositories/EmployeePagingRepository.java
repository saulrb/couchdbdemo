package org.studying.couchdb.couchdbdemo.repositories;

import com.couchbase.client.java.query.QueryScanConsistency;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.studying.couchdb.couchdbdemo.annotations.MyRepoAnnotation;
import org.studying.couchdb.couchdbdemo.model.Employee;

import java.awt.print.Pageable;
import java.util.List;

@MyRepoAnnotation( query = QueryScanConsistency.REQUEST_PLUS )
public interface EmployeePagingRepository extends PagingAndSortingRepository<Employee,String> {
    List<Employee> findAllByFirstName(String firstName, Pageable pageable);
}
