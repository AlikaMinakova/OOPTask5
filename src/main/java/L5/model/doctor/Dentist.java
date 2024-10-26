package L5.model.doctor;

import java.util.ArrayList;
import java.util.List;

import L5.model.Specialize;
import L5.model.patient.Patient;

public class Dentist extends Doctor {

    Specialize specializeType;
    List<Patient> patients;

    public Dentist(Specialize specializeType) {
        this.specializeType = specializeType;
        this.patients = new ArrayList<>();
    }

    @Override
    public Specialize getSpecializeType() {
        return specializeType;
    }

    @Override
    public List<Patient> getPatients() {
        return patients;
    }

    @Override
    public void clearDoctor() {
        patients = new ArrayList<>();
    }

    @Override
    public void deletePatientToDoctor(Patient patient) {
        for (Patient patient1 : patients) {
            if (patient.equals(patient1)) {
                patients.remove(patient);
            }
        }
    }

    @Override
    public void addPatientToDoctor(Patient patient) {
        patients.add(patient);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dentist dentist = (Dentist) o;
        return specializeType == dentist.specializeType;
    }

}
