package pro.sky.skyproemoloyeelist.service.model;

import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

public class Employee {
    private String name;
    private String lastname;
    private int department;
    private int salary;

    public Employee(String name, String lastname) {
        this.name = name;
        this.lastname = lastname;
    }

    public Employee(String name, String lastname, int department, int salary) {
        this.name = name;
        this.lastname = lastname;
        this.department = department;
        this.salary = salary;
    }

    public String getFullName() {
        return name + " " + lastname;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public int getDepartment() {
        return department;
    }

    public int getSalary() {
        return salary;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(name, employee.name) && Objects.equals(lastname, employee.lastname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, lastname);
    }

    @Override
    public String toString() {
        return "pro.sky.skyprolist.Employee{" +
                "name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }
}