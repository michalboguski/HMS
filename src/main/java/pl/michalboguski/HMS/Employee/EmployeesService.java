package pl.michalboguski.HMS.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.michalboguski.HMS.Department.DepartmentService;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class EmployeesService {
    @Autowired
    EmployeesRepository employeesRepository;
    @Autowired
    EmployeeMapper employeeMapper;

    @Autowired
    DepartmentService departmentService;

    public void save(EmployeeDTO employeeDTO) {
        employeesRepository.save(employeeMapper.toEntity(employeeDTO));
    }
    public void saveAll(List<EmployeeDTO> employeesDTO) {
        employeesDTO.forEach(this::save);
    }

    public void delete(EmployeeEntity employee) {
        employeesRepository.delete(employee);
    }

    @Transactional
    public void deleteById(List<Long> ids) {
        employeesRepository.deleteAllById(ids);
    }


    public Iterable<EmployeeEntity> findAllEmploeeEntityFromDataBase(){
        return employeesRepository.findAll();
    }

    public Iterable<EmployeeDTO> findAllEmployeeDAOFromDataBase() {
        return StreamSupport.stream(findAllEmploeeEntityFromDataBase().spliterator(), false)
                .map(e -> employeeMapper.toDTO(e))
                .collect(Collectors.toSet());
    }

    public EmployeeEntity findById(Long id){
        return employeesRepository.getReferenceById(id);
    }

    public List<EmployeeEntity> findAllEmployyeByIds(List<Long> ids){
        System.out.println(ids);
        return employeesRepository.findAllById(ids);
    }

    public void deleteDepartmentReferenceFromEmployee(Long id) {
        employeesRepository.findById(id).ifPresent(e -> e.setDepartment(null));
    }
    public void deleteDepartmentsReferencesFromEmployees(List <Long> ids) {
        ids.forEach(this::deleteDepartmentReferenceFromEmployee);
    }
}
