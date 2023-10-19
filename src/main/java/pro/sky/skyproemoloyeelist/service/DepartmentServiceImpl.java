package pro.sky.skyproemoloyeelist.service;

import org.springframework.stereotype.Service;
import pro.sky.skyproemoloyeelist.EmployeeService;
import pro.sky.skyproemoloyeelist.service.model.Employee;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final EmployeeService employeeService;

    public DepartmentServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public Employee getMinimumSalaryInDepartment(int department) {
        return employeeService.getMap().values().stream()
                .filter(e -> e.getDepartment() == department)
                .min(Comparator.comparing(Employee::getSalary))
                .orElseThrow(RuntimeException::new);
    }

    @Override
    public Employee getMaxSalaryInDepartment(int department) {
        return employeeService.getMap().values().stream()
                .filter(e -> e.getDepartment() == department)
                .max(Comparator.comparing(Employee::getSalary))
                .orElseThrow(RuntimeException::new);
    }

    @Override
    public List<Employee> getEmployeeFromDepartment(int department) {
        return employeeService.getMap().values().stream()
                .filter(e -> e.getDepartment() == department).toList();
    }

    @Override
    public Map<Integer, List<Employee>> getAllEmployees() {
        return employeeService.getMap().values().stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }
}
