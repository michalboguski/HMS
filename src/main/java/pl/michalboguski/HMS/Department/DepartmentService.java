package pl.michalboguski.HMS.Department;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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


    public void deleteMember(Long id) {
        departmentRepository.findById(id).ifPresent(d -> {
            d.setHOD(null);
            d.setMembers(null);
        });
    }

    public void deleteDepartment(Long id){
        departmentRepository.deleteById(id);
    }

    public void deleteDepartments(Iterable<Long> ids) {
        departmentRepository.deleteAllById(ids);
    }

    public void save(DepartmentDTO department) {
        DepartmentEntity departmentEntity = departmentMapper.toEntity(department);
        departmentEntity.addMembers(departmentEntity.getMembers());
        departmentRepository.save(departmentEntity);
    }



    public Set<DepartmentDTO> findAllDepartmentsFromDataBase() {
        return departmentRepository.findAll()
                .stream()
                .map(d -> departmentMapper.toDao(d))
                .collect(Collectors.toSet());
    }

    public Iterable<DepartmentEntity> findAllDepartmentsEntityFromDataBase() {
        return departmentRepository.findAll();
    }

    public DepartmentEntity findById(Long id) {
        return departmentRepository.getReferenceById(id);
    }
}
