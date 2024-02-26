package pl.michalboguski.HMS.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class EmployeesService {
    @Autowired
    EmployeesRepository employeesRepository;
    @Autowired
    EmployeeMapper employeeMapper;

    public void save(EmployeeDTO employeeDTO) {
        employeesRepository.save(employeeMapper.toEntity(employeeDTO));
    }

    public void saveAll(List<EmployeeDTO> employeesDTO) {
        employeesDTO.forEach(this::save);
    }

    public void deleteEmployee(Long id) {
        employeesRepository.deleteById(id);
    }

    public Iterable<EmployeeEntity> findAllEmploeeEntityFromDataBase() {
        return employeesRepository.findAll();
    }

    public Iterable<EmployeeDTO> findAllEmployeeDAOFromDataBase() {
        return StreamSupport.stream(findAllEmploeeEntityFromDataBase().spliterator(), false)
                .map(e -> employeeMapper.toDTO(e))
                .collect(Collectors.toSet());
    }

    public EmployeeEntity findById(Long id) {
        return employeesRepository.getReferenceById(id);
    }

    public List<EmployeeEntity> findAllEmployyeByIds(List<Long> ids) {
        return employeesRepository.findAllById(ids);
    }

    @Transactional
    public void removeDepartment(Long employeeID) {
        EmployeeEntity emp = findById(employeeID);
        emp.getDepartment().getMembers().removeIf(member -> employeeID.equals(member.getId()));
        emp.getDepartment().setHOD(null);
        emp.setDepartment(null);
    }

    public void deleteEmployees(List<Long> employeesIDs) {
        employeesIDs.forEach(this::removeDepartment);
        employeesRepository.deleteAllById(employeesIDs);
    }
}
