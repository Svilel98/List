package pro.sky.skyproemoloyeelist.service;

import org.springframework.stereotype.Service;
import pro.sky.skyproemoloyeelist.Employee;
import pro.sky.skyproemoloyeelist.EmployeeService;
import pro.sky.skyproemoloyeelist.exception.EmployeeAlreadyAddedException;
import pro.sky.skyproemoloyeelist.exception.EmployeeNotFoundException;
import pro.sky.skyproemoloyeelist.exception.EmployeeStorageIsFullException;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private List<Employee> collectionEmployee;
    private final int maxEmployees = 15;

    public EmployeeServiceImpl(List<Employee> collectionEmployee) {
        this.collectionEmployee = collectionEmployee;
    }

    @Override
    public Employee addEmployee(String name, String lastname) {
        Employee newEmployee = new Employee(name, lastname);
        boolean foundEmployee = isFoundEmployee(newEmployee);
        if (foundEmployee) {
            throw new EmployeeAlreadyAddedException("Такой сотрудник есть в компании");
        }
        if (collectionEmployee.size() < maxEmployees) {
            collectionEmployee.add(newEmployee);
        } else {
            throw new EmployeeStorageIsFullException("Превышен лимит количества сотрудников в фирме");
        }
        return newEmployee;
    }

    @Override
    public Employee removeEmployee(String name, String lastname) {
        Employee newEmployee = new Employee(name, lastname);
        boolean foundEmployee = isFoundEmployee(newEmployee);
        if (!foundEmployee) {
            throw new EmployeeNotFoundException("Сотрудник не найден");
        }
        collectionEmployee.remove(newEmployee);
        return newEmployee;
    }

    @Override
    public Employee findEmployee(String name, String lastname) {
        Employee newEmployee = new Employee(name, lastname);
        boolean foundEmployee = isFoundEmployee(newEmployee);
        if (!foundEmployee) {
            throw new EmployeeNotFoundException("Сотрудник не найден");
        }
        return newEmployee;
    }

    private boolean isFoundEmployee(Employee newEmployee) {
        boolean foundEmployee = false;
        for (int i = 0; i < collectionEmployee.size(); i++) {
            if (newEmployee.equals(collectionEmployee.get(i))) {
                System.out.println("Нашел");
                foundEmployee = true;
            }
        }
        return foundEmployee;
    }

    @Override
    public List<Employee> getList() {
        return collectionEmployee;
    }
}

