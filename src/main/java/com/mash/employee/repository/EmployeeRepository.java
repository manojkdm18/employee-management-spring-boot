/**
 * 
 */
package com.mash.employee.repository;

import org.springframework.stereotype.Repository;

import com.mash.employee.entity.Employee;

import org.springframework.data.jpa.repository.JpaRepository;
import java.lang.String;
import java.util.List;

/**
 * @author manoj
 *
 */
@Repository
public interface EmployeeRepository  extends JpaRepository<Employee,Long>{
	
	Employee findByEmprfnum(Long emprfnum);
	List<Employee> findByEmail(String email);
	List<Employee> findByMobile(String mobile);
	List<Employee> findByFirstNameContaining(String name);
	
	

}
