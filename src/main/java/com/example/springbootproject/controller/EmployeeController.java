package com.example.springbootproject.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.springbootproject.configs.MapperConfigure;
import com.example.springbootproject.dto.EmployeeDTO;
import com.example.springbootproject.entities.Cars;
import com.example.springbootproject.entities.Employee;
import com.example.springbootproject.repositories.CarRepository;
import com.example.springbootproject.services.EmployeeService;

@RestController
@RequestMapping(path = "/employee")
public class EmployeeController {
	
	@Autowired
	private final EmployeeService employeeService;
	@Autowired
	private final MapperConfigure mapperConfigure;

	public EmployeeController(EmployeeService employeeService,MapperConfigure mapperConfigure) {
		this.employeeService=employeeService;
		this.mapperConfigure=mapperConfigure;

	}
	
	@Autowired
	private  CarRepository carRepository;
	//http://localhost:8080/employees -post
	//{
	//    "name": "Madhu",
	//    "department": "IT",
	//    "salary": 45000
	//  }

//	@PostMapping
//	public Employee save(@RequestBody Employee employee) {
//		return employeeService.saveEmployee(employee);
//	}
	@PostMapping
	public Cars save(@RequestBody Cars car) {
		return carRepository.save(car);
	}
	
    //http://localhost:8080/employees/1 -put
	//{
	//    "name": "Madhu",
	//    "department": "IT",
	//    "salary": 45000
	//  }
	@PutMapping("/updateEmployee/{id}")
	public Employee update(@PathVariable("id") Long id,@RequestBody Employee employee) {
		return employeeService.updateEmployee(id, employee);
	}
	
	//http://localhost:8080/employees/deleteEmployee/4 -delete
	@DeleteMapping("/deleteEmployee/{id}")
	public String delete(@PathVariable Long id) {
		employeeService.deleteEmployee(id);
		return "Deleted Successfully";
	}

	//http://localhost:8080/employees/getEmployee/4 -get
	@GetMapping("/getEmployee/{id}")
	public Employee getOne(@PathVariable Long id) {
		return employeeService.getEmployeeById(id);
	}
	//postman - http://localhost:8080/employees/getAllEmployees
	//in spring boot without mapping it works based on class level mapping 
	@GetMapping("/getAllEmployees")
	public List<Employee> getAll() {
		return employeeService.getAllEmployees();
	}
	@PutMapping(path = "/{id}")
	public EmployeeDTO updateEmployeeID(@RequestBody EmployeeDTO employeeDTO,@PathVariable Long id) {
		System.out.println(employeeDTO);
		return employeeService.updateEmployeeID(id,employeeDTO);
	}
	
	// Handles partial updates using HTTP PATCH.
	// This method is used when the client wants to update only selected fields
	// without sending the complete Employee object.
	// The request body contains a map of field names and values,
	// which are applied dynamically using reflection in the service layer.
	@PatchMapping(path = "/{id}")
	public EmployeeDTO updatePartialEmployee(@RequestBody Map<String,Object> updatePartial,@PathVariable Long id) {
		return employeeService.updatePartialEmployee(id,updatePartial);
	}
// Like this without method level mapping works directly 	
	
//    @PostMapping
//    public Employee save(@RequestBody Employee employee) {
//        return employeeService.saveEmployee(employee);
//    }
//
//    @PutMapping("/{id}")
//    public Employee update(@PathVariable Long id,
//                           @RequestBody Employee employee) {
//        return employeeService.updateEmployee(id, employee);
//    }
//
//    @DeleteMapping("/{id}")
//    public String delete(@PathVariable Long id) {
//        employeeService.deleteEmployee(id);
//        return "Deleted Successfully";
//    }
//
//    @GetMapping("/{id}")
//    public Employee getOne(@PathVariable Long id) {
//        return employeeService.getEmployeeById(id);
//    }
//
//    @GetMapping
//    public List<Employee> getAll() {
//        return employeeService.getAllEmployees();
//    }


}


