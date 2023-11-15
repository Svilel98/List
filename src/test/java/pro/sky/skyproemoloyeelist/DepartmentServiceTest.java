package pro.sky.skyproemoloyeelist;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
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
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
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

    @ParameterizedTest
    @ValueSource(ints = {1, 2})
    public void getSalarySumByDeptTest(int department) {
        Mockito.when(employeeMock.getMap()).thenReturn(EMPLOYEE_MAP);
        int actual = departmentMock.sumSalaryInDepartment(department);
        assertEquals(departmentSalariesSum.get(department - 1), actual);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2})
    public void maxSalaryInDepartment(int department) {
        Mockito.when(employeeMock.getMap()).thenReturn(EMPLOYEE_MAP);
        int actual = departmentMock.maxSalaryInDepartment(department);
        assertEquals(departmentSalariesMax.get(department - 1), actual);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2})
    public void minSalaryInDepartment(int department) {
        Mockito.when(employeeMock.getMap()).thenReturn(EMPLOYEE_MAP);
        int actual = departmentMock.minSalaryInDepartment(department);
        assertEquals(departmentSalariesMin.get(department - 1), actual);
    }

    @Test
    public void getall() {
        Mockito.when(employeeMock.getMap()).thenReturn(EMPLOYEE_MAP);
        Map<Integer, List<Employee>> actual = departmentMock.getAllEmployees();
        assertEquals(actual.size(), All_EMPLOYEE_MAP.size());
        boolean b = actual.values().stream().flatMap(employees -> employees.stream())
                .allMatch(employees -> All_EMPLOYEE_MAP.values().stream().flatMap(employees1 -> employees1.stream())
                        .collect(Collectors.toList()).contains(employees));
        assertTrue(b);
    }
}
