package pl.michalboguski.HMS.Department;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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

    public void deleteMember(DepartmentEntity departmentEntity, Long memberID) {
        departmentEntity.getMembers().removeIf(member -> memberID.equals(member.getId()));
    }

    @Transactional
    public void deleteAllMembers(DepartmentEntity departmentEntity) {
        departmentEntity.getMembers().forEach(member -> member.setDepartment(null));
        departmentEntity.setMembers(null);
        departmentEntity.setHOD(null);
    }

    public void deleteDepartments(List<Long> departmentsIDs) {
        departmentsIDs.forEach(departmentID ->
                deleteAllMembers(departmentRepository.getReferenceById(departmentID))
        );
        departmentRepository.deleteAllById(departmentsIDs);
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
