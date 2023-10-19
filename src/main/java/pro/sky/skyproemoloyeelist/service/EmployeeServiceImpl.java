package pro.sky.skyproemoloyeelist.service;

import org.apache.commons.lang3.StringUtils;
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
        validateEmployee(employee);
        startedWithUpperCase(employee.getLastname());
        employee.setName(startedWithUpperCase(employee.getName()));
        employee.setLastname(startedWithUpperCase(employee.getLastname()));
        employees.put(employee.getFullName(), employee);
        sizeEmployee++;
        return employee;
    }

    private static void validateEmployee(Employee employee) {
        String name = employee.getName();
        if (StringUtils.isEmpty(name)){
            throw new IllegalArgumentException("Пустое имя");
        }
        String lastname = employee.getLastname();
        if (StringUtils.isEmpty(lastname)){
            throw new IllegalArgumentException("Пустая фамилия");
        }
    }
    private static String startedWithUpperCase(String str){
        return StringUtils.capitalize(str);
    }

    @Override
    public Employee removeEmployee(Employee employee) {
        validateEmployee(employee);
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
        if(StringUtils.isEmpty(fullname)){
            throw new IllegalArgumentException("Пусто");
        };
        return employees.get(fullname);
    }

    @Override
    public Map<String, Employee> getMap() {
        return employees;
    }


}


