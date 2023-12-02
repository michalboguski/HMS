package pl.michalboguski.HMS.Department;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.michalboguski.HMS.Employee.Employee;
import pl.michalboguski.HMS.Employee.EmployeesService;

import java.util.List;

@Controller
@RequestMapping("/departments")
public class DepartmentsController {

    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private EmployeesService employeesService;

    @GetMapping("")
    public String displayDepartments(){
        return "departments";
    }
    @ModelAttribute
    public Department departmentModel() {
        return new Department();
    }

    @ModelAttribute("allEmployee")
    public Iterable<Employee> getAllEmployee() {
        return employeesService.findAllEmployeesFromDataBase();
    }

    @ModelAttribute("departments")
    public Iterable<Department> returnEmployees() {
        return departmentService.findAllDepartmentsFromDataBase();
    }
    @PostMapping(params = "usun=true")
    public String deletePersons(@RequestParam(required = false) List<Long> department) {
        departmentService.deleteById(department);
        return "redirect:departments";
    }
    @PostMapping()
    public String savePerson(Department department) {
        departmentService.save(department);
        return "redirect:departments";
    }
}
