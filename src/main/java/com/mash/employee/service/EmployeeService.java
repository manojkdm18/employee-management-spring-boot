/**
 * 
 */
package com.mash.employee.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mash.employee.controller.request.EmpDataBean;
import com.mash.employee.controller.response.ResponseBean;
import com.mash.employee.entity.Department;

/**
 * @author manoj
 *
 */
@Service
public interface EmployeeService {
	
	ResponseBean saveUpdateEmployee(EmpDataBean bean);
	ResponseBean getEmployeeById(Long emprfnum);
	List<EmpDataBean> getEmployeeByName(String name);
	List<EmpDataBean> getEmployeeList();
	List<Department> getDepartmentList();
	ResponseBean deleteEmployee(Long emprfnum);

}
