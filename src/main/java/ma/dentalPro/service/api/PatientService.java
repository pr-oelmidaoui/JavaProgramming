package ma.dentalPro.service.api;

import java.util.List;
import ma.dentalPro.domain.Patient;

public interface PatientService {

    List<Patient> getPatientsSortedByName();

    Patient save(Patient patient);

    boolean update(Patient patient);

    boolean delete(Patient patient);

    boolean deleteById(Long idPatient);

    List<Patient> findByNomLike(String nom);
}
