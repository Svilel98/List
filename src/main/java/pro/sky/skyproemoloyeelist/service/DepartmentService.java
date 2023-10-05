package pro.sky.skyproemoloyeelist.service;

import pro.sky.skyproemoloyeelist.service.model.Employee;

import java.util.List;
import java.util.Map;

public interface DepartmentService {
    Employee getMinimumSalaryInDepartment(int department);

    Employee getMaxSalaryInDepartment(int department);

    List<Employee> getEmployeeFromDepartment(int department);
    Map<Integer, List<Employee>> getAllEmployees();

}
