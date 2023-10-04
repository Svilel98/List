package pro.sky.skyproemoloyeelist.service;

import org.springframework.stereotype.Service;
import pro.sky.skyproemoloyeelist.model.Employee;
import pro.sky.skyproemoloyeelist.EmployeeService;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toList;

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

    @Override
    public Employee getMinimumSalaryInDepartment(int department) {
        List<Employee> departmentEmployees = employees.values().stream()
                .filter(employee -> employee.getDepartment() == department)
                .sorted(Comparator.comparing(Employee::getSalary)).collect(toList());
        Employee minSalariesEmployee = departmentEmployees.stream()
                .findFirst().orElseThrow();
        return minSalariesEmployee;
    }

    @Override
    public Employee getMaxSalaryInDepartment(int department) {
        List<Employee> departmentEmployees = employees.values().stream()
                .filter(employee -> employee.getDepartment() == department)
                .sorted(Comparator.comparing(Employee::getSalary)).collect(toList());
        Employee maxSalariesEmployee = departmentEmployees.stream()
                .reduce((e1, e2) -> e2)
                .orElseThrow();
        return maxSalariesEmployee;
    }

    @Override
    public List<Employee> getEmployeeFromDepartment(Integer department) {
        if (department == null) {
            List<Employee> departmentEmployees = employees.values().stream()
                    .sorted(Comparator.comparing(Employee::getDepartment)).collect(toList());
            return departmentEmployees;
        }
        List<Employee> employeesByDepartment = employees.values().stream()
                .filter(employee -> employee.getDepartment() == department).collect(toList());
        return employeesByDepartment;
    }

}


