package pro.sky.skyproemoloyeelist;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.skyproemoloyeelist.service.DepartmentServiceImpl;
import pro.sky.skyproemoloyeelist.service.EmployeeServiceImpl;
import pro.sky.skyproemoloyeelist.service.model.Employee;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static pro.sky.skyproemoloyeelist.Constants.*;


@ExtendWith(MockitoExtension.class)
public class DepartmentServiceTest {
    @Mock
    private EmployeeServiceImpl employeeMock;
    private DepartmentServiceImpl departmentMock;

    @BeforeEach
    public void BeforeEach() {
        departmentMock = new DepartmentServiceImpl(employeeMock);
    }

    @Test
    public void getSalarySumByDeptTest() {

        Mockito.when(employeeMock.getMap()).thenReturn(EMPLOYEE_MAP);
        int deptNum = 1;
        for (int i = 0; i < departmentSalariesSum.size(); i++) {
            int actual = departmentMock.sumSalaryInDepartment(deptNum);
            assertEquals(departmentSalariesSum.get(i), actual);
            deptNum++;
        }
    }

    @Test
    public void maxSalaryInDepartment() {

        Mockito.when(employeeMock.getMap()).thenReturn(EMPLOYEE_MAP);
        int deptNum = 1;
        for (int i = 0; i < 2; i++) {
            int actual = departmentMock.maxSalaryInDepartment(deptNum);
            assertEquals(departmentSalariesMax.get(i), actual);
            deptNum++;
        }
    }

    @Test
    public void minSalaryInDepartment() {

        Mockito.when(employeeMock.getMap()).thenReturn(EMPLOYEE_MAP);
        int deptNum = 1;
        for (int i = 0; i < 2; i++) {
            int actual = departmentMock.minSalaryInDepartment(deptNum);
            assertEquals(departmentSalariesMin.get(i), actual);
            deptNum++;
        }
    }

    @Test
    public void getall() {
        Mockito.when(employeeMock.getMap()).thenReturn(EMPLOYEE_MAP);
        Map<Integer, List<Employee>> actual = departmentMock.getAllEmployees();
        assertEquals(actual,All_EMPLOYEE_MAP);
    }
}
