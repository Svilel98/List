package pro.sky.skyproemoloyeelist.service;

import org.springframework.stereotype.Service;
import pro.sky.skyproemoloyeelist.service.model.Employee;
import pro.sky.skyproemoloyeelist.EmployeeService;

import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final Map<String, Employee> employees = new HashMap<>();
    private int sizeEmployee = 20;

    @Override
    public Employee addEmployee(Employee employee) {

        if (sizeEmployee == employees.size()) {
            throw new RuntimeException("Overflow");
        }
        employees.put(employee.getFullName(), employee);
        sizeEmployee++;
        return employee;
    }

    @Override
    public Employee removeEmployee(Employee employee) {
        Employee employeeDeleted = employees.remove(employee.getFullName());
        if (employeeDeleted != null) {
            sizeEmployee--;
            System.out.println("Удалил");
        } else {
            throw new RuntimeException("Нет такого");
        }
        return employeeDeleted;
    }

    @Override
    public Employee findEmployee(String fullname) {
        return employees.get(fullname);
    }

    @Override
    public Map<String, Employee> getMap() {
        return employees;
    }


}


