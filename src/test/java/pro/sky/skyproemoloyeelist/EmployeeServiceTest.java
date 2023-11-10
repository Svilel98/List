package pro.sky.skyproemoloyeelist;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.Null;
import org.springframework.boot.test.context.SpringBootTest;
import pro.sky.skyproemoloyeelist.service.EmployeeServiceImpl;
import pro.sky.skyproemoloyeelist.service.model.Employee;

import java.util.Collections;

@SpringBootTest
public class EmployeeServiceTest {
    private String name;
    private String lastname;
    private int department;
    private int salary;
    private String name2;
    private String lastname2;
    private int department2;
    private int salary2;
    private Employee employee1;
    private Employee employee2;
    private Employee emptyEmployee;
    private EmployeeServiceImpl employeeService;

    @BeforeEach
    public void setUp() {
        name = "Ivan";
        lastname = "Ivanov";
        department = 1;
        salary = 10000;
        name2 = "Sergey";
        lastname2 = "Sergeev";
        department2 = 2;
        salary2 = 2000;
        employeeService = new EmployeeServiceImpl();
        employee1 = new Employee(name, lastname, department, salary);
        employee2 = new Employee(name2, lastname2, department2, salary2);
        emptyEmployee = null;
    }

    @Test
    public void addEmployee() {
        Employee person1 = employeeService.addEmployee(employee1);
        Assertions.assertEquals(employee1, person1);
        Assertions.assertThrows(NullPointerException.class, () -> employeeService.addEmployee(emptyEmployee));
    }

    @Test
    public void removeEmployee() {
        employeeService.addEmployee(employee1);
        Employee deletedEmployee = employeeService.removeEmployee(employee1);
        Assertions.assertEquals(employee1, deletedEmployee);
        Assertions.assertThrows(NullPointerException.class, () -> employeeService.removeEmployee(employee1));
        Assertions.assertThrows(NullPointerException.class, () -> employeeService.removeEmployee(emptyEmployee));
    }

    @Test
    public void findEmployee() {
        employeeService.addEmployee(employee1);
        Employee findEmployee = employeeService.findEmployee(employee1.getFullName());
        Assertions.assertEquals(employee1.getFullName(), findEmployee.getFullName());
        Assertions.assertNull(employeeService.findEmployee(employee2.getFullName()));
        Assertions.assertThrows(IllegalArgumentException.class, () -> employeeService.findEmployee(null));
    }
}
