package effigo.ayushi.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import effigo.ayushi.springboot.model.Employee;
import effigo.ayushi.springboot.repository.EmployeeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Optional<Employee> getEmployeeById(Long id) {
        return employeeRepository.findById(id);
    }

    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Optional<Employee> updateEmployee(Long id, Employee employeeDetails) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        if (optionalEmployee.isPresent()) {
            Employee employee = optionalEmployee.get();
            employee.setFirstName(employeeDetails.getFirstName());
            employee.setLastName(employeeDetails.getLastName());
            employee.setEmailId(employeeDetails.getEmailId());
            Employee updatedEmployee = employeeRepository.save(employee);
            return Optional.of(updatedEmployee);
        } else {
            return Optional.empty();
        }
    }

    public boolean deleteEmployee(Long id) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        if (optionalEmployee.isPresent()) {
            employeeRepository.delete(optionalEmployee.get());
            return true;
        } else {
            return false;
        }
    }

	public List<Employee> getAllEmployees1() {
		// TODO Auto-generated method stub
		return null;
	}
}
