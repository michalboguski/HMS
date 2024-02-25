package pl.michalboguski.HMS.Department;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.michalboguski.HMS.Employee.EmployeeDTO;
import pl.michalboguski.HMS.Employee.EmployeesService;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Controller
@RequestMapping("/departments")
public class DepartmentsController {
    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private EmployeesService employeesService;

    @GetMapping("")
    public String displayDepartments() {
        return "departments";
    }

    @ModelAttribute("department")
    public DepartmentDTO departmentModel() {
        return new DepartmentDTO();
    }

    @ModelAttribute("freeEmployees")
    public Iterable<EmployeeDTO> getUnAssignedEmployees() {
        System.out.println("NEW FREE EMPLOEE IN DEPARTAMENT LIST");
        return StreamSupport
                .stream(employeesService.findAllEmployeeDAOFromDataBase().spliterator(), false)
                .filter(employeeDTO -> employeeDTO.getDepartment() == null)
                .collect(Collectors.toSet());

    }

    @ModelAttribute("allEmployee")
    public Iterable<EmployeeDTO> getAllEmployee() {
        return employeesService.findAllEmployeeDAOFromDataBase();
    }

    @ModelAttribute("departments")
    public Iterable<DepartmentDTO> returnDepartments() {
        return departmentService.findAllDepartmentsFromDataBase();
    }

    @PostMapping(params = "del=true")
    public String deleteDepartment(@RequestParam(required = false) List<Long> dept) {
        departmentService.deleteDepartments(dept);
        return "redirect:departments";
    }

    @PostMapping
    public String saveDepartment(DepartmentDTO department) {
        departmentService.save(department);
        return "redirect:departments";
    }


}
