package ma.dentalPro.repository.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import ma.dentalPro.domain.Patient;

/**
 * Centralise les fonctions qui transforment une ligne SQL en objet métier.
 * Les futurs mappings Consultation, RendezVous et autres entités seront ajoutés ici.
 */
public final class RowMappers {

    private RowMappers() {
    }

    public static Patient toPatient(ResultSet resultSet) throws SQLException {
        return new Patient(
                resultSet.getLong("id_patient"),
                resultSet.getString("nom"),
                resultSet.getInt("age")
        );
    }
}
