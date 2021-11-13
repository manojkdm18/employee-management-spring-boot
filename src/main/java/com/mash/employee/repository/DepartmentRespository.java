/**
 * 
 */
package com.mash.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mash.employee.entity.Department;

/**
 * @author manoj
 *
 */
public interface DepartmentRespository extends JpaRepository<Department, Long>{

}
