package pl.michalboguski.HMS.Department;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.michalboguski.HMS.Employee.Employee;
import pl.michalboguski.HMS.Employee.EmployeesService;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@Service
public class DepartmentService {
    @Autowired
    DepartmentRepository departmentRepository;
    @Autowired
    DepartmentMapper departmentMapper;

    @Autowired
    EmployeesService employeesService;


    public void deleteById(Iterable<Long> ids) {
        departmentRepository.deleteAllById(ids);
    }
    public void save(DepartmentDTO department){
        DepartmentEntity departmentEntity = departmentMapper.toEntity(department);

        departmentRepository.save(departmentEntity);
        System.out.println("S department : "+department);
        System.out.println("S departmentEntity : "+departmentEntity);
        Long id = departmentEntity.getId();
    }

    public Set<DepartmentDTO> findAllDepartmentsFromDataBase() {
        return departmentRepository.findAll()
                .stream()
                .map(departmentMapper)
                .collect(Collectors.toSet());
    }
    public Iterable<DepartmentEntity> findAllDepartmentsEntityFromDataBase() {
        return departmentRepository.findAll();
    }

}
