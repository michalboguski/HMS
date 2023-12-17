package pl.michalboguski.HMS.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeesController {
    @Autowired
    private EmployeesService employeesService;

    @ModelAttribute("newEmployee")
    public Employee personModel() {
        return new Employee();
    }

    @ModelAttribute("employees")
    public Iterable<Employee> returnEmployees() {
        return employeesService.findAllEmployeesFromDataBase();
    }

    @PostMapping(params = "usun=true")
    public String deletePersons(@RequestParam(required = false) List<Long> employee) {
        System.out.println(employee);
        employeesService.deleteById(employee);
        return "redirect:employees";
    }

    @GetMapping("")
    public String displayEmployees() {
        return "employees";
    }

    @PostMapping()
    public String savePerson(Employee employee) {
        employeesService.save(employee);
        return "redirect:employees";
    }

    @GetMapping("employee/{id}")
    public String displayEmployee(@PathVariable("id") Long id, Model model){
        model.addAttribute("employee", employeesService.findById(id));
        return "employee";

    }
}
