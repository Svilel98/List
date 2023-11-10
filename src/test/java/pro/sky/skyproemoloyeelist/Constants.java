package pro.sky.skyproemoloyeelist;

import pro.sky.skyproemoloyeelist.service.EmployeeServiceImpl;
import pro.sky.skyproemoloyeelist.service.model.Employee;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Constants {
    public static String name = "Ivan";
    public static String lastname = "Ivanov";
    public static Integer department = 1;
    public static int salary = 10000;
    public static String name2 = "Sergey";
    public static String lastname2 = "Sergeev";
    public static Integer department2 = 1;
    public static int salary2 = 2000;
    public static String name3 = "Daniil";
    public static String lastname3 = "Victorov";
    public static Integer department3 = 2;
    public static int salary3 = 3000;
    public static String name4 = "Aleksey";
    public static String lastname4 = "Morozov";
    public static Integer department4 = 2;
    public static int salary4 = 4000;
    public static List<Integer> departmentSalariesMax = new ArrayList<>(List.of(salary, salary4));
    public static List<Integer> departmentSalariesMin = new ArrayList<>(List.of(salary2, salary3));
    public static List<Integer> departmentSalariesSum = new ArrayList<>(List.of(salary + salary2, salary3 + salary4));
    public static Employee employee1 = new Employee(name, lastname, department, salary);
    public static Employee employee2 = new Employee(name2, lastname2, department2, salary2);
    public static Employee employee3 = new Employee(name3, lastname3, department3, salary3);
    public static Employee employee4 = new Employee(name4, lastname4, department4, salary4);
    public static Employee emptyEmployee = null;
    public static final String GOOD_PREFIX = "Tea";
    public static final String BAD_PREFIX = "ABC";

    public static final Map<String, Employee> EMPLOYEE_MAP = Map.of(
            employee1.getFullName(), employee1,
            employee2.getFullName(), employee2,
            employee3.getFullName(), employee3,
            employee4.getFullName(), employee4
    );
    public static final Map<Integer, List<Employee>> All_EMPLOYEE_MAP = Map.of(
            department, new ArrayList<>(List.of(employee1, employee2)),
            department3, new ArrayList<>(List.of(employee3, employee4)));
}

