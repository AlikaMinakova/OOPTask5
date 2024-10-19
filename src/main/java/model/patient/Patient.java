package model.patient;

import lombok.*;
import model.Specialize;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class Patient {
    private String FIO;
    private Specialize direction;
    private LocalDate birthday;
    private LocalDate reception;

}
