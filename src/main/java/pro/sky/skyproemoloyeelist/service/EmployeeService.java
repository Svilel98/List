package pro.sky.skyproemoloyeelist;

import pro.sky.skyproemoloyeelist.service.model.Employee;

import java.util.Map;

public interface EmployeeService{
    Employee addEmployee(Employee employee);
    Employee removeEmployee(Employee employee);

    Employee findEmployee(String fullname) ;

    Map<String ,Employee> getMap();
}