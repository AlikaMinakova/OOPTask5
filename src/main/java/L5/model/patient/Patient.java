package L5.model.patient;

import lombok.*;
import L5.model.Specialize;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class Patient {
    private String FIO;
    private Specialize direction;
    private LocalDate birthday;
    private LocalDate reception;

}
