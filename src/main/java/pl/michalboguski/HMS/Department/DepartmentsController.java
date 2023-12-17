package pl.michalboguski.HMS.Department;

import jdk.swing.interop.SwingInterOpUtils;
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

    @ModelAttribute("department")
    public DepartmentDTO departmentModel() {
        return new DepartmentDTO();
    }

    @ModelAttribute("allEmployee")
    public Iterable<Employee> getAllEmployee() {
        return employeesService.findAllEmployeesFromDataBase();
    }

    @ModelAttribute("departments")
    public Iterable<DepartmentDTO> returnDepartments() {
        return departmentService.findAllDepartmentsFromDataBase();
    }

    @PostMapping(params = "del=true")
    public String deleteDepartment(@RequestParam(required = false) List<Long> dept) {
        System.out.println("LIST delete id FROM TEMPLATE: " + dept);
        departmentService.deleteById(dept);
        return "redirect:departments";
    }

    @PostMapping
    public String saveDepartment(DepartmentDTO department) {
        System.out.println("SAVING DEPARTMENT MEMBER for id: "+ department.getId() );
        department.getMembers().forEach(m -> System.out.println(m.toString()+" : "+m.getId().toString()));
        System.out.println(department);
        departmentService.save(department);




        return "redirect:departments";
    }
}
