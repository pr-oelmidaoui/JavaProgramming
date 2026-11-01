package ma.dentalPro.ui.controllers.console;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import ma.dentalPro.domain.Patient;
import ma.dentalPro.service.api.PatientService;
import ma.dentalPro.ui.controllers.api.PatientController;

@Data
@AllArgsConstructor
public class PatientControllerImpl implements PatientController {

    private final PatientService service;

    @Override
    public void getAllPatients() {
        System.out.println("Call for Patient Controller to show result in console");
        var result = service.getPatientsSortedByName();
        result.forEach(patient ->
                System.out.println("- Patient : " + patient.getNom()
                        + " agé de " + patient.getAge() + " ans"));
    }

    @Override
    public Patient save(Patient patient) {
        return service.save(patient);
    }

    @Override
    public boolean update(Patient patient) {
        return service.update(patient);
    }

    @Override
    public boolean delete(Patient patient) {
        return service.delete(patient);
    }

    @Override
    public boolean delete(Long idPatient) {
        return service.deleteById(idPatient);
    }

    @Override
    public List<Patient> findByNomLike(String nom) {
        return service.findByNomLike(nom);
    }
}
