package pl.michalboguski.HMS.Department;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.michalboguski.HMS.Employee.EmployeeEntity;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class DepartmentService {
    @Autowired
    DepartmentRepository departmentRepository;
    @Autowired
    DepartmentMapper departmentMapper;

    public void removeAllMembersFromDepartment(Optional<Long> departmentID) {
        departmentID.ifPresent(id -> {
            DepartmentEntity departmentEntity = departmentRepository.getReferenceById(id);
            Set<EmployeeEntity> members = departmentEntity.getMembers();
            EmployeeEntity hod = departmentEntity.getHOD();

            if (!members.isEmpty()) members.forEach(m -> m.setDepartment(null));
            if (hod != null) hod.setDepartment(null);
            departmentRepository.save(departmentEntity);
        });
    }

    public void deleteDepartments(List<Optional<Long>> departmentsIDs) {
        departmentsIDs.forEach(this::removeAllMembersFromDepartment);
        departmentsIDs.stream().filter(Optional::isPresent).map(Optional::get).forEach(id -> departmentRepository.deleteById(id));
    }

    public void save(DepartmentDTO department) {
        DepartmentEntity departmentEntity = departmentMapper.toEntity(department);
        departmentEntity.getMembers().forEach(m -> m.setDepartment(departmentEntity));
        departmentRepository.save(departmentEntity);
    }

    public Set<DepartmentDTO> findAllDepartmentsFromDataBase() {
        return departmentRepository.findAll()
                .stream()
                .map(d -> departmentMapper.toDto(d))
                .collect(Collectors.toSet());
    }

    public Iterable<DepartmentEntity> findAllDepartmentsEntityFromDataBase() {
        return departmentRepository.findAll();
    }

    public DepartmentEntity findById(Long id) {
        return departmentRepository.getReferenceById(id);
    }
}
