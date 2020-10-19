package exam1;

import java.time.LocalDate;
import java.util.Objects;

public class Person {

    private String name;
    private String surname;
    private int dateOfBirth;

    public Person() {

    }


    public Person(String name, String surname, int dateOfBirth) {
        setDateOfBirth(dateOfBirth);
        setName(name);
        setSurname(surname);
    }

    public void getInfoAboutPerson() {
        System.out.println("name: " + this.name + ", surname: " + this.surname + ", year of birth: " + dateOfBirth);

    }


    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return dateOfBirth;
    }


    public void setName(String name) {
        if (name == null &&
                name.trim().length() < 2) throw new IllegalArgumentException("имя не должно быть null " +
                "и больше двух символов");
        this.name = name;
    }

    public void setSurname(String surname) {
        if (surname == null && surname.trim().length() < 2)
            throw new IllegalArgumentException("имя не должно быть null " +
                    "и больше двух символов");
        this.surname = surname;
    }

    public void setDateOfBirth(int dateOfBirth) {
        LocalDate date = LocalDate.now();
        if ((date.getYear() - dateOfBirth) < 18)
            throw new IllegalArgumentException("возраст посетителя должен быть больше 18 лет");
        else if (dateOfBirth == 0)
            throw new IllegalArgumentException("возраст посетителя должен быть больше 0 лет");
        this.dateOfBirth = dateOfBirth;
    }


}
