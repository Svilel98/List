package pro.sky.skyproemoloyeelist;

import java.util.List;

public interface EmployeeService{
    pro.sky.skyproemoloyeelist.Employee addEmployee(String firstname, String lastname);
    pro.sky.skyproemoloyeelist.Employee removeEmployee(String firstname, String lastname);
    pro.sky.skyproemoloyeelist.Employee findEmployee(String firstname, String lastname);
    List<pro.sky.skyproemoloyeelist.Employee> getList();
}