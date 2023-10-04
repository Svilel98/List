package pro.sky.skyproemoloyeelist.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.skyproemoloyeelist.EmployeeService;
import pro.sky.skyproemoloyeelist.model.Employee;
import pro.sky.skyproemoloyeelist.service.EmployeeServiceImpl;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeServiceImpl employeeService;

    public EmployeeController(EmployeeServiceImpl employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/add")
    public Employee addEmployee(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName,
                                @RequestParam("department") Integer department, @RequestParam("salary") Integer salary) {
        return employeeService.addEmployee(new Employee(firstName, lastName, department, salary));
    }

    @GetMapping(path = "/remove")
    public Employee removeEmployee(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
        return employeeService.removeEmployee(new Employee(firstName, lastName));
    }

    @GetMapping(path = "/find")
    public Employee findEmployee(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
        return employeeService.findEmployee(new Employee(firstName, lastName).getFullName());
    }

    @GetMapping
    public Map<String, Employee> getMap() {
        return employeeService.getMap();
    }

    @GetMapping(path = "/min-salary")
    public Employee getMinimumSalaryInDepartment(@RequestParam("department") int department) {
        return employeeService.getMinimumSalaryInDepartment(department);
    }

    @GetMapping(path = "/max-salary")
    public Employee getMaxSalaryInDepartment(@RequestParam("department") int department) {
        return employeeService.getMaxSalaryInDepartment(department);
    }

    @GetMapping(path = "/all")
    public List<Employee> getEmployeeFromDepartment(@RequestParam(value = "department", required = false) Integer department) {
        return employeeService.getEmployeeFromDepartment(department);
    }
}
