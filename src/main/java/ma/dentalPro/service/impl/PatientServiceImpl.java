package ma.dentalPro.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.Data;
import ma.dentalPro.domain.Patient;
import ma.dentalPro.repository.api.PatientRepo;
import ma.dentalPro.service.api.PatientService;

@Data @AllArgsConstructor
public class PatientServiceImpl implements PatientService {
    // Couplage faible avec repository
    private final PatientRepo repo;

    @Override
    public List<Patient> getPatientsSortedByName() {

        System.out.println("Call for PatientService to sort patients by name ");
        return repo.findAll()
                .stream()
                .sorted((p1, p2) -> p2.getNom().compareTo(p1.getNom()))
                .collect(Collectors.toCollection(ArrayList::new));

    }

    @Override
    public Patient save(Patient patient) {
        return repo.save(patient);
    }

    @Override
    public boolean update(Patient patient) {
        return repo.update(patient);
    }

    @Override
    public boolean delete(Patient patient) {
        return repo.delete(patient);
    }
    @Override
    public boolean deleteById(Long idPatient) {
        return repo.deleteById(idPatient);
    }

    @Override
    public List<Patient> findByNomLike(String nom) {
        return repo.findByNomLike(nom);
    }

}
