/**
 * 
 */
package com.mash.employee.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.mash.employee.controller.request.AddressBean;
import com.mash.employee.controller.request.DepartementBean;
import com.mash.employee.controller.request.EmpDataBean;
import com.mash.employee.controller.response.ResponseBean;
import com.mash.employee.entity.Address;
import com.mash.employee.entity.Department;
import com.mash.employee.entity.Employee;
import com.mash.employee.repository.AddressRepository;
import com.mash.employee.repository.DepartmentRespository;
import com.mash.employee.repository.EmployeeRepository;
import com.mash.employee.service.EmployeeService;
import com.mash.employee.utils.MashUtils;

/**
 * @author manoj
 *
 */
@Service
@Component
public class EmployeeServiceImpl implements EmployeeService {
	
	static final Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);

	
	@Autowired
	EmployeeRepository empRepo;
	@Autowired
	AddressRepository addRepo;
	@Autowired
	DepartmentRespository deptRepo;
	public static final String EMPID_PREFIX = "EMP0000";	
	
	@Override
	public ResponseBean saveUpdateEmployee(EmpDataBean bean) {
		ResponseBean responseBean = null;
		Employee emp = null;
		try {
			String message = validateRequest(bean);
			if ("SUCCESS".equalsIgnoreCase(message)) {
				if (MashUtils.isNotEmpty(bean.getEmprfnum())) {
					emp = empRepo.findByEmprfnum(bean.getEmprfnum());
					if (MashUtils.isNotEmpty(emp)) {
						emp = setEmployeeData(bean, emp);
						bean = setEmployeeData(emp);
						responseBean = new ResponseBean("SUCCESS", 0, "RECORD UPDATED",bean);
					}
				} else {
					emp = new Employee();
					emp = setEmployeeData(bean, emp);
					emp.setEmpId(EMPID_PREFIX+emp.getEmprfnum());
					empRepo.save(emp);
					bean = setEmployeeData(emp);
					responseBean = new ResponseBean("SUCCESS", 0, "RECORD SAVED",bean);
				}
			} else {
				responseBean = new ResponseBean("FAILD", 1, message);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return responseBean;
	}
	
	@Override
	public ResponseBean getEmployeeById(Long emprfnum) {
			ResponseBean responseBean = null;
			if (MashUtils.isNotEmpty(emprfnum)) {
				Employee emp = empRepo.findByEmprfnum(emprfnum);
				if (emp != null) {
					EmpDataBean bean = setEmployeeData(emp);
					responseBean = new ResponseBean("SUCCESS", 0, "RECORD FOUND",bean);
				}else {
					responseBean = new ResponseBean("FAILD", 1, "RECORD NOT FOUND");
				}
			}
			return responseBean;
		}
		
	
	private Employee setEmployeeData(EmpDataBean bean, Employee emp) {
		try {
			emp.setFirstName(bean.getFirstName());
			emp.setLastName(bean.getLastName());
			emp.setEmail(bean.getEmail());
			emp.setMobile(bean.getMobile());
			emp.setDesignation(bean.getDesignation());
			emp.setSalary(bean.getSalary());
			emp.setGender(bean.getGender());
			emp.setDateOfBirth(bean.getDateofbirth());
			emp.setIsactive("Y");
			Long deptrfnum = bean.getDepartment().getDeptrfnum();
			if (deptrfnum != null) {
				Optional<Department> dept = deptRepo.findById(deptrfnum);
				if (dept.isPresent()) {
					emp.setDepartment(dept.get());
				}
			}
			empRepo.save(emp);
			logger.info("records saved or updated for employee :"+emp.getEmail());
			saveEmployeeAddress(bean, emp);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return emp;
	}
	
	private void saveEmployeeAddress(EmpDataBean bean, Employee emp) {
		AddressBean addBean = bean.getAddress();
		if (addBean != null) {
			Address address = addRepo.findByEmloyee(emp);
			address = address == null ? new Address() : address;
			address.setCity(addBean.getCity());
			address.setState(addBean.getState());
			address.setZipcode(addBean.getZipcode() + "");
			address.setCountry(addBean.getCountry());
			address.setIsactive("Y");
			address.setEmloyee(emp);
			addRepo.save(address);
			logger.info("address saved or updated for employee :"+emp.getEmail());
		}
	}

	
	@Override
	public List<EmpDataBean> getEmployeeList() {
		List<EmpDataBean> dataList = new ArrayList<>();
		List<Employee> employeeList = empRepo.findAll();
		if (MashUtils.isNotEmpty(employeeList)) {
			employeeList.stream().forEach(emp -> {
				EmpDataBean data = setEmployeeData(emp);
				dataList.add(data);
			});
		}
		return dataList;
	}

	
	
	public EmpDataBean setEmployeeData(Employee emp) {
		EmpDataBean bean = new EmpDataBean();
		if (emp != null) {
			bean.setEmprfnum(emp.getEmprfnum());
			bean.setFirstName(emp.getFirstName());
			bean.setLastName(emp.getLastName());
			bean.setMobile(emp.getMobile());
			bean.setEmail(emp.getEmail());
			bean.setEmpId(emp.getEmpId());
			bean.setDateofbirth(emp.getDateOfBirth());
			bean.setSalary(emp.getSalary());
			bean.setGender(emp.getGender());
			bean.setDesignation(emp.getDesignation());
			Address address = addRepo.findByEmloyee(emp);
			if (address != null) {
				AddressBean addBean = new AddressBean();
				addBean.setCity(address.getCity());
				addBean.setState(address.getState());
				addBean.setZipcode(address.getZipcode());
				addBean.setCountry(address.getCountry());
				bean.setAddress(addBean);
			}
			Department department = emp.getDepartment();
			if (department != null) {
				DepartementBean deptBean = new DepartementBean();
				deptBean.setDeptcode(department.getDeptCode());
				deptBean.setDeptname(department.getDeptName());
				deptBean.setDeptrfnum(department.getDeptrfnum());
				bean.setDepartment(deptBean);
			}
		}
		return bean;
	}
	
	public String  validateRequest(EmpDataBean bean) {
		try {
			String email = bean.getEmail();
			String mobile = bean.getMobile();
			Long emprfnum = bean.getEmprfnum();
			if(!MashUtils.isNotEmpty(email)) {
				return "EMAIL_REQUIRED";
			}else if(emprfnum == null && isEmailExists(email)) {
				return "EMAIL_EXISTS";
			}else if(!MashUtils.isNotEmpty(mobile)) {
				return "MOBILE_REQUIRED";
			}else if(emprfnum == null && isMobileExists(mobile)) {
				return "MOBILE_EXISTS";
			}else if(!MashUtils.isNotEmpty(bean.getFirstName())) {
				return "FIRST_NAME REQUIRED";
			}else if(!MashUtils.isNotEmpty(bean.getSalary())) {
				return "SALARY_REQUIRED";
			}else if(bean.getSalary().doubleValue() < 0) {
				return "SALARY SHOULD BE GREATER THAN 0";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "SUCCESS";
	}
	
	
	public boolean isEmailExists(String email) {
	  List<Employee> empList = empRepo.findByEmail(email);
	  return empList != null && !empList.isEmpty() ? true :false;
	}
	
    public boolean isMobileExists(String email) {
    	 List<Employee> empList = empRepo.findByMobile(email);
   	  return empList != null && !empList.isEmpty() ? true :false;
	}

	@Override
	public List<Department> getDepartmentList() {
		return deptRepo.findAll();
	}
	
	@Override
	public List<EmpDataBean> getEmployeeByName(String name) {
		List<EmpDataBean> dataList = new ArrayList<>();
		List<Employee> employeeList = empRepo.findByFirstNameContaining(name);
		if (MashUtils.isNotEmpty(employeeList)) {
			employeeList.stream().forEach(emp -> {
				EmpDataBean data = setEmployeeData(emp);
				dataList.add(data);
			});
		}
		return dataList;
	}
	@Override
	public ResponseBean deleteEmployee(Long emprfnum) {
		ResponseBean responseBean = null;
		if (MashUtils.isNotEmpty(emprfnum)) {
			Employee emp = empRepo.findByEmprfnum(emprfnum);
			if (emp != null) {
				Address address = addRepo.findByEmloyee(emp);
				if(address != null)
				addRepo.delete(address);
				empRepo.delete(emp);
				responseBean = new ResponseBean("SUCCESS", 0, "RECORD DELETED",null);
			}else {
				responseBean = new ResponseBean("FAILD", 1, "RECORD NOT FOUND");
			}
		}
		return responseBean;
	}
	
}
