package pl.michalboguski.HMS.Department;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class DepartmentService {
    @Autowired
    DepartmentRepository departmentRepository;
    @Autowired
    DepartmentMapper departmentMapper;

    public void removeMember(DepartmentEntity departmentEntity, Long memberID) {
        departmentEntity.getMembers().removeIf(member -> memberID.equals(member.getId()));
    }

    @Transactional
    public void removeAllMembersFromDepartment(Long departmentID) {
        DepartmentEntity departmentEntity = departmentRepository.getReferenceById(departmentID);
        departmentEntity.getMembers().forEach(member -> member.setDepartment(null)); // czy todziała?
        departmentEntity.setMembers(null);
        departmentEntity.setHOD(null);
        departmentRepository.save(departmentEntity);
    }

    @Transactional
    public void deleteDepartments(List<Long> departmentsIDs) {
        departmentsIDs.forEach(this::removeAllMembersFromDepartment);
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
