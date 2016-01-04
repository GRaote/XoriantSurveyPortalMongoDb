package com.xoriant.resourcestest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.xoriant.dao.EmployeeDao;
import com.xoriant.model.Employee;
import com.xoriant.resources.stub.EmployeeResourceStub;
import com.xoriant.stubinterface.IEmployee;

/**
 * 
 * @author raote_g
 * 
 */
public class EmployeeResourceTest {

	private List<Employee> empList = null;
	private IEmployee iEmployee = null;
	private Employee employee = new Employee();

	/**
	 * 
	 */
	@Before
	public void setup() {
		iEmployee = new EmployeeResourceStub();
		empList = iEmployee.getAllEmployees();
		employee = iEmployee.getEmployee("e01");
	}

	/**
	 * 
	 */
	@Test
	public void getAllEmployeesNullTest() {
		boolean gotException = true;

		try {
			EmployeeDao.instance.getAllEmployees();
		} catch (NullPointerException e) {
			System.out.println("Null pointer exception");
			gotException = false;
		}

		if (!gotException) {
			fail("Returned null");
		}
	}

	/**
	 * 
	 * 
	 */
	@Test
	public void getEmployeeSuccessTest() {
		List<Employee> employeeList = null;
		employeeList = EmployeeDao.instance.getAllEmployees();
		Employee emp = employeeList.get(0);
		Employee emp1 = empList.get(0);
		assertEquals(emp, emp1);
	}

	/**
	 * 
	 * 
	 */
	@Test
	public void getEmployeeFailTest() {
		List<Employee> employeeList = null;
		employeeList = EmployeeDao.instance.getAllEmployees();
		Employee emp = employeeList.get(0);
		Employee emp1 = empList.get(1);
		boolean flag = emp.equals(emp1);
		assertFalse(flag);
	}

}
