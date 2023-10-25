package pl.michalboguski.HMS.Emplyee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeesController {
    @Autowired
    private EmployeesService employeesService;

    @ModelAttribute
    public Employee personModel() {
        return new Employee();
    }

    @ModelAttribute("employees")
    public Iterable<Employee> returnEmployees() {
        return employeesService.findAllEmployeesFromDataBase();
    }

    @PostMapping(params = "usun=true")
    public String deletePersons(@RequestParam(required = false) List<Long> employee) {
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
}
