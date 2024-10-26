package L5;

import L5.exception.DoctorIsBusyException;
import L5.model.Specialize;
import L5.model.doctor.Dentist;
import L5.model.doctor.Doctor;
import L5.model.patient.Patient;
import org.junit.jupiter.api.*;
import L5.service.DoctorManager;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DoctorManagerTest {

    private static final Doctor dentist = new Dentist(Specialize.DENTIST);
    private static final Doctor dermatolog = new Dentist(Specialize.DERMATOLOGIST);
    private static final LocalDate birthday = LocalDate.of(2000, 8, 10);
    private static final LocalDate date = LocalDate.of(2024, 11, 10);
    private static final Patient patient = new Patient("FIO", Specialize.ANESTHESIOLOGIST, birthday, date);
    private static final Patient patient2 = new Patient("FIO", Specialize.DERMATOLOGIST, birthday, date);
    private static final Patient patient3 = new Patient("FIO", Specialize.DENTIST, birthday, date);
    private static final DoctorManager doctorManager = new DoctorManager();
    List<Doctor> doctors = List.of(dentist, dermatolog);


    @AfterEach
    void clearShelves() {
        doctors.forEach(Doctor::clearDoctor);
    }

    @Test
    @DisplayName("Проверим, у всех врачей нужные пациенты")
    void allDoctorsHaveCorrectPatients() {
        assertDoesNotThrow(() ->
                doctorManager.addPatientToDoctor(dentist, patient3));
        assertDoesNotThrow(() ->
                doctorManager.addPatientToDoctor(dermatolog, patient2));
        for (Doctor doctor : doctors) {
            for (Patient patient : doctor.getPatients()) {
                Assertions.assertEquals(doctor.getSpecializeType(), patient.getDirection());
            }
        }
    }

    @Test
    @DisplayName("Проверим, что если мы вдруг перепутали врачей, то наш менеджер все равно направит к нужному")
    void incorrectPatientHasCorrectDoctor() {
        assertDoesNotThrow(() -> doctorManager.addPatientToDoctor(
                dentist,
                patient2
        ));

        assertEquals(dentist.getPatients().size(), 0);

        assertEquals(dermatolog.getPatients().size(), 1);
        assertEquals(dermatolog.getSpecializeType(),
                dermatolog.getPatients().get(0).getDirection());
    }

    @Test
    @DisplayName("Ошибка добавления пациента доктору")
    void doctorDoesNotExistsForPatient() {
        assertThrows(DoctorIsBusyException.class,
                () -> doctorManager.addPatientToDoctor(dentist, patient));
    }

}

