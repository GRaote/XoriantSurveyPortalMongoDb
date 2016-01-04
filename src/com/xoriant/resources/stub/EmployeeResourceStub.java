package com.xoriant.resources.stub;

import java.util.ArrayList;
import java.util.List;

import com.xoriant.model.Employee;
import com.xoriant.stubinterface.IEmployee;
/**
 * 
 * @author raote_g
 *
 */
public class EmployeeResourceStub implements IEmployee{
	/**
	 * 
	 */
	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> employee=new ArrayList<Employee>();
		employee.add(new Employee("e01"));
		employee.add(new Employee("e50"));
		return employee;
	}
	/**
	 * 
	 */
	@Override
	public Employee getEmployee(String empId) {
		Employee employee=new Employee("e01");
		return employee;
	}
	/**
	 * 
	 */
	@Override
	public void addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		
	}



}
