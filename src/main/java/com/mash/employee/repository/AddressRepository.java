/**
 * 
 */
package com.mash.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mash.employee.entity.Address;
import com.mash.employee.entity.Employee;

/**
 * @author manoj
 *
 */
public interface AddressRepository extends JpaRepository<Address,Long> {

	Address findByEmloyee(Employee emloyee);
			
}
