package ma.dentalPro;


import ma.dentalPro.config.ApplicationContext;
import ma.dentalPro.domain.Patient;
import ma.dentalPro.shared.RepositoryException;
import ma.dentalPro.ui.controllers.api.PatientController;

public class App {

    static void main() {
        var myController =
                ApplicationContext
                        .getInstance()
                        .getBean(PatientController.class);

        try {
            var patientOmar = myController.save(new Patient(null, "Omar", 29));
            System.out.printf(
                    "[SUCCÈS] Patient créé : id=%d, nom=%s, âge=%d%n",
                    patientOmar.getIdPatient(),
                    patientOmar.getNom(),
                    patientOmar.getAge()
            );

            var patientAnis = myController.save(new Patient(null, "Anis", 34));
            System.out.printf(
                    "[SUCCÈS] Patient créé : id=%d, nom=%s, âge=%d%n",
                    patientAnis.getIdPatient(),
                    patientAnis.getNom(),
                    patientAnis.getAge()
            );

            var patientMisAJour = new Patient(1L, "Rayane", 23);
            var modificationReussie = myController.update(patientMisAJour);
            System.out.printf(
                    "[%s] Mise à jour du patient id=%d%n",
                    modificationReussie ? "SUCCÈS" : "ÉCHEC",
                    patientMisAJour.getIdPatient()
            );

            var idPatientASupprimer = 1L;
            var suppressionReussie = myController.delete(idPatientASupprimer);
            System.out.printf(
                    "[%s] Suppression du patient id=%d%n",
                    suppressionReussie ? "SUCCÈS" : "ÉCHEC",
                    idPatientASupprimer
            );

            System.out.println("\nListe actuelle des patients :");
            myController.getAllPatients();
        } catch (RepositoryException e) {
            System.err.println(e.getSummary());
        }
    }
}
