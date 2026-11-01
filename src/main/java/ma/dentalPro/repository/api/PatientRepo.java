package ma.dentalPro.repository.api;

import java.util.List;
import ma.dentalPro.domain.Patient;

public interface PatientRepo extends CrudRepo<Patient, Long>
{


    List<Patient> findByNomLike(String mc);
}
