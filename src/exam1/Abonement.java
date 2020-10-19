package exam1;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static exam1.AbonementTypes.*;
import static exam1.SectionTypes.*;


public class Abonement {

    boolean inFintess;

    private String[] sectionType;
    private Person person;
    private String abonementType;

    private LocalDate dateOfRegistration = LocalDate.now();
    private LocalDate endOfRegistration;

    private LocalTime startTime = LocalTime.of(8,00);
    private LocalTime endTime;

    public String getAbonementType() {
        return abonementType;
    }

    public LocalDate getDateOfRegistration() {
        return dateOfRegistration;
    }

    public LocalDate getEndOfRegistration() {
        return endOfRegistration;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public String[] getSectionType() {
        return sectionType;
    }

    private Abonement(String abonementType, Person person) {
        setAbonementType(abonementType);
        setPerson(person);
    }

    public void setAbonementType(String abonementType) {
        if (abonementType == null) throw new IllegalArgumentException("тип абониметна не должен быть null");

        if (ONE_DAY.equals(abonementType) || MORNING.equals(abonementType) || FULL.equals(abonementType)) {

            this.abonementType = abonementType;
        } else {
            throw new IllegalArgumentException("Тип абонимента может быть только: ONE_DAY или MORNING или FULL");
        }
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        if (person == null)
            throw new IllegalArgumentException("Клиент не должен быть null");
        this.person = person;

    }

    public static Abonement abonementMaker(String abonementType, Person person) {

        Abonement abon = new Abonement(abonementType, person);

        switch (abonementType) {

            case ONE_DAY:
                abon.sectionType = new String[]{GYM, SWIMMING_POOL, GROUP_LESSON};
                abon.endOfRegistration = abon.dateOfRegistration;
                abon.endTime = LocalTime.of(21,59);
                break;

            case MORNING:
                abon.sectionType = new String[]{GYM, GROUP_LESSON};
                abon.endOfRegistration = abon.dateOfRegistration.plusMonths(12);
                abon.endTime = LocalTime.of(15,59);
                break;

            case FULL:
                abon.sectionType = new String[]{GYM, SWIMMING_POOL, GROUP_LESSON};
                abon.endOfRegistration = abon.dateOfRegistration.plusMonths(12);
                abon.endTime = LocalTime.of(21,59);
                break;

        }
        return abon;
    }
    

}
