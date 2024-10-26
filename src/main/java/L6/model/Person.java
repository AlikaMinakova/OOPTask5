package L6.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.experimental.Accessors;

import java.time.LocalDate;
import java.util.Objects;

@NoArgsConstructor
@Data
@Accessors(chain = true)
public class Person implements Comparable<Person>{
    @NonNull
    private String name;
    @NonNull
    private String surname;
    @NonNull
    private LocalDate birthday;

    @Override
    public int compareTo(Person o) {
        if (this.equals(o)){
            return 0;
        }
        else {
            return this.surname.compareTo(o.surname) > 0 ? 1 : -1;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return name.equals(person.name) && surname.equals(person.surname) && birthday.equals(person.birthday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, birthday);
    }
}
