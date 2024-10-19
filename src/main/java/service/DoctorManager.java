package service;

import exception.DoctorIsBusyException;
import exception.WrongDoctorTypeException;
import lombok.extern.slf4j.Slf4j;
import model.Specialize;
import model.doctor.Doctor;
import model.patient.Patient;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class DoctorManager {

    private final Map<Specialize, Doctor> doctors;

    public DoctorManager() {
        this.doctors = new HashMap<>();
    }

    public void addPatientToDoctor(Doctor doctor, Patient patient) {
        try {
            isRightSpecialize(doctor.getSpecializeType(), patient.getDirection());
            doctors.putIfAbsent(doctor.getSpecializeType(), doctor); //если доктора ещё нет в списке, то добавить
            doctor.addPatientToDoctor(patient);
        } catch (WrongDoctorTypeException e) {
            log.info(e.getMessage());
        } finally {
            if (doctors.containsKey(patient.getDirection())) {
                if (!doctors.get(patient.getDirection()).getPatients().contains(patient)) {
                    Doctor correct = doctors.get(patient.getDirection());
                    correct.addPatientToDoctor(patient);
                    log.info("Пациент направлен к нужному доктору");
                }
            } else {
                throw new DoctorIsBusyException("сейчас записи к нужному доктору нет");
            }
        }
    }

    private void isRightSpecialize(Specialize doctorType, Specialize patientType) throws WrongDoctorTypeException {
        if (doctorType != patientType) {
            throw new WrongDoctorTypeException("Пациенту нужен доктор не этой специльности!");
        }
    }
}
