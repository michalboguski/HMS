package pl.michalboguski.HMS.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.michalboguski.HMS.DataUtil;
import pl.michalboguski.HMS.Department.DepartmentService;
import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeesController {
    @Autowired
    private EmployeesService employeesService;

    @Autowired
    private DepartmentService departmentService;

    @ModelAttribute("newEmployee")
    public EmployeeDTO personModel() {
        return new EmployeeDTO();
    }

    @ModelAttribute("employees")
    public Iterable<EmployeeDTO> returnEmployees() {
        return employeesService.findAllEmployeeDAOFromDataBase();
    }

    @PostMapping(params = "usun")
    public String deletePersons(@RequestParam(required = false) List<Long> employee) {
        System.out.println(employee);

        //delete members from department
        //delete hod from department
        departmentService.deleteMembers(employee);

        //delete department_id from employee
        employee.forEach(e -> employeesService.deleteDepartmentReferenceFromEmployee(e));

        //delete employes
        employeesService.deleteById(employee);

        System.out.println(employee);
        return "redirect:employees";
    }

    @GetMapping("")
    public String displayEmployees() {
        return "employees";
    }

    @PostMapping()
    public String savePerson(EmployeeDTO employeeDTO) {
        employeesService.save(employeeDTO);
        return "redirect:employees";
    }

    @GetMapping("employee/{id}")
    public String displayEmployee(@PathVariable("id") Long id, Model model){
        model.addAttribute("employee", employeesService.findById(id));
        return "employee";
    }

    @PostMapping(params = "ten=utworz")
    public String add10Emplyees(){
        DataUtil dataUtil = new DataUtil();
        employeesService.saveAll(dataUtil.create10Emplyees());

        return "redirect:employees";
    }
}
