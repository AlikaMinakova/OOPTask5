import exception.WrongDateException;
import model.Specialize;
import model.patient.Patient;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import service.PatientManager;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PatientManagerTest {
    private static final LocalDate birthday = LocalDate.of(2000, 8, 10);
    private static final LocalDate date = LocalDate.of(2024, 11, 10);
    private static final Patient patient = new Patient("FIO", Specialize.ANESTHESIOLOGIST, birthday, date);
    private static final String VALID_DATE = "2024-11-10";
    private static final String INVALID_DATE = "2024/08/10";
    private static final String INVALID_DATE2 = "1999-08-10";
    private final PatientManager patientManager = new PatientManager();

    @Test
    @DisplayName("Дата записи валидная, ошибки не будет")
    void setDateOfReceptionValid() {
        patientManager.setDateOfReception(patient, VALID_DATE);
        assertEquals(patient.getReception(), LocalDate.parse(VALID_DATE));
    }


    @Test
    @DisplayName("Ошибка валидации формата даты записи")
    void setDateOfReceptionInValid() {
        assertThrows(WrongDateException.class,
                () -> patientManager.setDateOfReception(patient, INVALID_DATE));
    }

    @Test
    @DisplayName("Ошибка валидации даты записи")
    void setDateOfReceptionInvalidPast() {
        assertThrows(WrongDateException.class,
                () -> patientManager.setDateOfReception(patient, INVALID_DATE2));
    }
}
