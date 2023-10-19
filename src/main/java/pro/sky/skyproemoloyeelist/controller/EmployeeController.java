package pro.sky.skyproemoloyeelist.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.skyproemoloyeelist.service.model.Employee;
import pro.sky.skyproemoloyeelist.service.EmployeeServiceImpl;

import java.util.Map;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeServiceImpl employeeService;

    public EmployeeController(EmployeeServiceImpl employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/add")
    public ResponseEntity<Employee> addEmployee(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName,
                                      @RequestParam("department") Integer department, @RequestParam("salary") Integer salary) {
         try {
             return new ResponseEntity<Employee>(employeeService.addEmployee(new Employee(firstName, lastName, department, salary)), HttpStatus.OK);
        } catch (Exception E){
             System.out.println(E.getMessage());
             return new ResponseEntity(HttpStatus.BAD_REQUEST);
         }
//        return employeeService.addEmployee(new Employee(firstName, lastName, department, salary));
    }

    @GetMapping(path = "/remove")
    public ResponseEntity<Employee> removeEmployee(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
        try {
            return new ResponseEntity<Employee>(employeeService.removeEmployee(new Employee(firstName, lastName)), HttpStatus.OK);
        } catch (Exception E){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(path = "/find")
    public ResponseEntity<Employee> findEmployee(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
        try {
            return new ResponseEntity<Employee>(employeeService.findEmployee(new Employee(firstName, lastName).getFullName()), HttpStatus.OK);
        } catch (Exception E){
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public Map<String, Employee> getMap() {
        return employeeService.getMap();
    }
}
