package L5.model.doctor;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import L5.model.Specialize;
import L5.model.patient.Patient;

import java.util.List;

@Slf4j
@Getter
@NoArgsConstructor
public abstract class Doctor {

    public abstract Specialize getSpecializeType();
    public abstract void addPatientToDoctor(Patient patient);
    public abstract void deletePatientToDoctor(Patient patient);
    public abstract List<Patient> getPatients();
    public abstract void clearDoctor();
    public void log(String message){
        log.info(message);
    }


}
