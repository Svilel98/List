package pro.sky.skyproemoloyeelist;

import pro.sky.skyproemoloyeelist.model.Employee;

import java.util.List;
import java.util.Map;

public interface EmployeeService{
    Employee addEmployee(Employee employee);
    Employee removeEmployee(Employee employee);

    Employee findEmployee(String fullname);

    Map<String ,Employee> getMap();
    Employee getMinimumSalaryInDepartment(int department);
    Employee getMaxSalaryInDepartment(int department);
    List<Employee> getEmployeeFromDepartment(Integer department);
}