package pl.michalboguski.HMS.Department;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.michalboguski.HMS.Employee.EmployeeEntity;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


@Service
public class DepartmentService {
    @Autowired
    DepartmentRepository departmentRepository;
    @Autowired
    DepartmentMapper departmentMapper;



    public void deleteMembers(Long id){
        departmentRepository.findById(id).ifPresent(d -> {d.setHOD(null); d.setMembers(null);});
    }
    public void deleteById(Iterable<Long> ids) {
        ids.forEach(d -> findById(d).getMembers().forEach(m -> m.setDepartment(null)));
        ids.forEach(this::deleteMembers);
        departmentRepository.deleteAllById(ids);
    }
    public void save(DepartmentDTO department){
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

    public DepartmentEntity findById(Long id){
        return departmentRepository.getReferenceById(id);
    }

    public void deleteMembers(List<Long> ids) {
       StreamSupport.stream(findAllDepartmentsEntityFromDataBase().spliterator(),false)
//               .filter(d -> d.getMembers()
//                       .stream()
//                       .map(EmployeeEntity::getId)
//                       .anyMatch(ids::contains))
//               .forEach(d -> {d.setHOD(null); d.setMembers(null);});

               .filter(d -> (d.getHOD() != null && ids.contains(d.getHOD().getId())))
               .forEach(d -> d.setHOD(null));
    }

}
