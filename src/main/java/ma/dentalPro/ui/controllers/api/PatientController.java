package ma.dentalPro.ui.controllers.api;

import java.util.List;
import ma.dentalPro.domain.Patient;

/**
 * Contrat des opérations exposées par un contrôleur de patients.
 */
public interface PatientController {

    void getAllPatients();

    Patient save(Patient patient);

    boolean update(Patient patient);

    boolean delete(Patient patient);

    boolean delete(Long idPatient);

    List<Patient> findByNomLike(String nom);
}
