package pl.michalboguski.HMS.Department;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.michalboguski.HMS.Employee.Employee;
import pl.michalboguski.HMS.Employee.EmployeesService;

import java.util.List;
import java.util.Set;

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
    public DepartmentEntity departmentModel() {
        return new DepartmentEntity();
    }

    @ModelAttribute("allEmployee")
    public Iterable<Employee> getAllEmployee() {
        return employeesService.findAllEmployeesFromDataBase();
    }


//    @PostMapping(params = "add=true")
//    public List<Employee> newMembers(@RequestParam(required = false) List<Long> employees){
//        System.out.println("emp      "+employees);
//        return new ArrayList<>(employeesService.findAllEmployyeByIds(employees));
//    }


    @ModelAttribute("departments")
    public Set<DepartmentDTO> returnEmployees() {
        return departmentService.findAllDepartmentsFromDataBase();
    }


    @PostMapping(params = "usun=true")
    public String deleteDepartment(@RequestParam() List<Long> department) {
        departmentService.deleteById(department);
        return "redirect:departments";
    }

    @PostMapping
    public String saveDepartment(DepartmentEntity department) {
        System.out.println("=========");
        System.out.println(department);
        System.out.println("=========");
        departmentService.save(department);
        return "redirect:departments";
    }
}
