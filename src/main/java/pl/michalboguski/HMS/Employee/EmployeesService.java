package pl.michalboguski.HMS.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class EmployeesService {
    EmployeesRepository employeesRepository;

    @Autowired
    public EmployeesService(EmployeesRepository personRepository) {
        this.employeesRepository = personRepository;
    }


    public void save(Employee employee) {
        employeesRepository.save(employee);
    }

    public void delete(Employee employee) {
        employeesRepository.delete(employee);
    }

    public void deleteById(Iterable<Long> ids) {
        employeesRepository.deleteAllById(ids);
    }

    public Iterable<Employee> findAllEmployeesFromDataBase() {
        return employeesRepository.findAll();
    }

    public Employee findById(Long id){
        return employeesRepository.getReferenceById(id);
    }

    public List<Employee> findAllEmployyeByIds(List<Long> ids){
        System.out.println(ids);
        return employeesRepository.findAllById(ids);
    }

}
