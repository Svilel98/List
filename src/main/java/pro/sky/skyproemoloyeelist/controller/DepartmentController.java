package pro.sky.skyproemoloyeelist.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.skyproemoloyeelist.service.model.Employee;
import pro.sky.skyproemoloyeelist.service.DepartmentServiceImpl;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    private final DepartmentServiceImpl departmentService;

    public DepartmentController(DepartmentServiceImpl departmentService) {
        this.departmentService = departmentService;
    }


    @GetMapping(path = "/min-salary")
    public Employee getMinimumSalaryInDepartment(@RequestParam("department") int department) {
        return departmentService.getMinimumSalaryInDepartment(department);
    }

    @GetMapping(path = "/max-salary")
    public Employee getMaxSalaryInDepartment(@RequestParam("department") int department) {
        return departmentService.getMaxSalaryInDepartment(department);
    }

    @GetMapping(path = "/all", params = "department")
    public List<Employee> getEmployeeFromDepartment(@RequestParam(value = "department") int department) {
        return departmentService.getEmployeeFromDepartment(department);
    }
    @GetMapping(path = "/all")
    public Map<Integer, List<Employee>> getAllEmployees() {
        return departmentService.getAllEmployees();
    }
}
