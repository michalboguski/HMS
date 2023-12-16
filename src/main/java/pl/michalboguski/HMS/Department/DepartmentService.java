package pl.michalboguski.HMS.Department;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;


@Service
public class DepartmentService {
    @Autowired
    DepartmentRepository departmentRepository;
    @Autowired
    DepartmentMapper departmentMapper;


    public void deleteById(Iterable<Long> ids) {
        departmentRepository.deleteAllById(ids);
    }
    public void save(DepartmentEntity department){
    departmentRepository.save(department);
    }

    public Set<DepartmentDTO> findAllDepartmentsFromDataBase() {
        return departmentRepository.findAll()
                .stream()
                .map(departmentMapper).collect(Collectors.toSet());
    }
    public void delete(DepartmentEntity department) {
        departmentRepository.delete(department);
    }

}
