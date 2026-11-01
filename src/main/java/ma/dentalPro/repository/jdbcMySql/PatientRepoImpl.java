package ma.dentalPro.repository.jdbcMySql;


import java.util.List;
import lombok.Data;
import ma.dentalPro.domain.Patient;
import ma.dentalPro.repository.api.PatientRepo;

@Data
public class PatientRepoImpl implements PatientRepo {

    @Override
    public List<Patient> findByNomLike(String mc) {
        return List.of();
    }

    @Override
    public List<Patient> findAll() {
        System.out.println("Call for mySQL repo");
        return VirtualDataBase.patients();
    }
    @Override
    public Patient findById(Long identity) {
        return VirtualDataBase
                .patients()
                .stream()
                .filter(p->p.getIdPatient().equals(identity))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Patient save(Patient newElement) {
        var maxId = findAll().stream()
                .mapToLong(Patient::getIdPatient)
                .max()
                .orElse(0L);
        newElement.setIdPatient(maxId + 1);
        VirtualDataBase.patients().add(newElement);
        return newElement;
    }

    @Override
    public boolean update(Patient newValuesElement) {
        VirtualDataBase.patients().set(VirtualDataBase.patients().indexOf(newValuesElement), newValuesElement);

        return true;
    }

    @Override
    public boolean delete(Patient element) {
        return   VirtualDataBase.patients().remove(element);
    }

    @Override
    public boolean deleteById(Long identity) {
        return delete(findById(identity));
    }
}
