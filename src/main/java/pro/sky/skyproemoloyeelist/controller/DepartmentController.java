package pro.sky.skyproemoloyeelist.controller;

import org.springframework.web.bind.annotation.*;
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

    @GetMapping("/{id}/employees")
    public List<Employee> getEmployeeFromDepartment(@PathVariable(value = "id") int department) {
        return departmentService.getEmployeeFromDepartment(department);
    }

    @GetMapping("employees")
    public Map<Integer, List<Employee>> getAllEmployees() {
        return departmentService.getAllEmployees();
    }


    @GetMapping("/{id}/salary/sum")
    public Integer sumSalaryInDepartment(@PathVariable("id") int department) {
        return departmentService.sumSalaryInDepartment(department);
    }

    @GetMapping("/{id}/salary/max")
    public Integer maxSalaryInDepartment(@PathVariable("id") int department) {
        return departmentService.maxSalaryInDepartment(department);
    }

    @GetMapping("/{id}/salary/min")
    public Integer minSalaryInDepartment(@PathVariable("id") int department) {
        return departmentService.minSalaryInDepartment(department);
    }
}
