/**
 * 
 */
package com.mash.employee.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mash.employee.controller.request.EmpDataBean;
import com.mash.employee.controller.response.ResponseBean;
import com.mash.employee.entity.Department;
/**
 * @author manoj
 *
 */
import com.mash.employee.service.EmployeeService;
@RestController
@RequestMapping("/api/v1/employee")
@CrossOrigin(origins = "*")
public class EmployeeController {

	static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);
	
	@Autowired
	EmployeeService service ;

	@PostMapping("/save")
	public ResponseBean saveUpdateEmployee(@RequestBody EmpDataBean bean) {
		return service.saveUpdateEmployee(bean);	
	}
	
	@GetMapping("/employees")
	public List<EmpDataBean> getEmployeeList() {
		return service.getEmployeeList();
	}
	
	@GetMapping("/employees/{emprfnum}")
	public ResponseBean getEmployeeRecordbyId(@PathVariable(value = "emprfnum") Long emprfnum) {
		return service.getEmployeeById(emprfnum);
	}
	
	@GetMapping("/employees/search/{name}")
	public List<EmpDataBean> getEmployeeRecordByName(@PathVariable(value = "name") String name) {
		return service.getEmployeeByName(name);
	}
	
	@GetMapping("/departments")
	public List<Department> getDepartmentsList() {
		return service.getDepartmentList();
	}
	
	@GetMapping("/employees/delete/{emprfnum}")
	public ResponseBean deleteEmployee(@PathVariable(value = "emprfnum") Long emprfnum) {
		return service.deleteEmployee(emprfnum);
	}
	
		
	
}
