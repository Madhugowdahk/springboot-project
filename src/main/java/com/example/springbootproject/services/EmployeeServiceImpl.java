package com.example.springbootproject.services;

import org.apache.el.util.ReflectionUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import com.example.springbootproject.dto.EmployeeDTO;
import com.example.springbootproject.entities.Employee;
import com.example.springbootproject.repositories.EmployeeRepository;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
//1.Field Injection (Not recommended)
//Very easy and short code.
//Cons (why NOT recommended)
//Hard to write unit tests
//Cannot make field final
//Spring uses reflection → not clean design
//Use only for quick demos or small projects.
	
    @Autowired
    private EmployeeRepository employeeRepository;
    
    @Autowired
    private ModelMapper modelMapper;
    
//2.Constructor Injection (Recommended Best Practice)
//Best for testing
//Allows fields to be final
//No reflection
//Ensures dependency is not null
//Works perfectly with Spring Boot auto-wiring
    
//    private final EmployeeRepository employeeRepository;
//
//    public EmployeeService(EmployeeRepository employeeRepository) {
//        this.employeeRepository = employeeRepository;
//    }


//3. Setter Injection
//You expose a setter method and let Spring inject dependency.
//    private EmployeeRepository employeeRepository;
//
//    @Autowired
//    public void setEmployeeRepository(EmployeeRepository employeeRepository) {
//        this.employeeRepository = employeeRepository;
//    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee updateEmployee(Long id, Employee employee) {
        Employee existing = employeeRepository.findById(id).orElse(null);
        if (existing != null) {
            existing.setName(employee.getName());
            existing.setDepartment(employee.getDepartment());
            existing.setSalary(employee.getSalary());
            return employeeRepository.save(existing);
        }
        return null;
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public EmployeeDTO getEmployeeById(Long id) {
        Optional<Employee> savedEmployee= employeeRepository.findById(id);
		return modelMapper.map(savedEmployee, EmployeeDTO.class);

    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

	@Override
	public EmployeeDTO updateEmployeeID(Long id, EmployeeDTO employeeDTO) {
		System.out.println(id);
		Employee employee=modelMapper.map(employeeDTO, Employee.class);
		employee.setId(id);
		Employee savedEmployee=employeeRepository.save(employee);
		System.out.println(savedEmployee.getId());
		return modelMapper.map(savedEmployee, EmployeeDTO.class);
	}

	@Override
	public EmployeeDTO updatePartialEmployee(Long id, Map<String, Object> updatePartial) {
		boolean isExists=employeeRepository.existsById(id);
		if(!isExists) {
			return null;
		}
		Employee savedEmployee=employeeRepository.findById(id).get();
		updatePartial.forEach((key ,value)->{
		Field fieldTobeUpdated=	ReflectionUtils.findField(Employee.class, key);
		fieldTobeUpdated.setAccessible(true);
		ReflectionUtils.setField(fieldTobeUpdated, savedEmployee, value);
		});
      return modelMapper.map(employeeRepository.save(savedEmployee),EmployeeDTO.class);
	}
}
