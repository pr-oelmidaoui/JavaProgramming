package ma.dentalPro.repository.memoryDataBase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import ma.dentalPro.domain.Patient;

public class VirtualDataBase {

    public static List<Patient> patients() {

        return new ArrayList<>(
                Arrays.asList(
                        new Patient(1L, "Fadoua", 20),
                        new Patient(2L, "Omar", 22),
                        new Patient(4L, "Souhail", 23),
                        new Patient(5L, "Amine", 18),
                        new Patient(6L, "Tarek", 17),
                        new Patient(7L, "Amina", 20),
                        new Patient(8L, "Tanae", 30),
                        new Patient(9L, "Ayman", 26),
                        new Patient(10L, "Btihal", 27)
                )
        );
    }
}
