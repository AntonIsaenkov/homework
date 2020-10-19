package exam1;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.Objects;

import static exam1.AbonementTypes.*;
import static exam1.SectionTypes.*;

public class Fitness {

    final private Abonement[] gym = new Abonement[20];
    final private Abonement[] swimmingPool = new Abonement[20];
    final private Abonement[] groupLesson = new Abonement[20];


    private LocalDateTime fitnessTime;
    private LocalTime fitnessOpen = LocalTime.of(8, 00);
    private LocalTime fitnessClosed = LocalTime.of(22, 00);


    public void setFitnessTime(LocalDateTime fitnessTime) {
        Objects.requireNonNull(fitnessTime, "fitnesstime не может быть null");
        this.fitnessTime = fitnessTime;
    }


    public Fitness(LocalDateTime fitnessTime) {
        setFitnessTime(fitnessTime);
    }

    public void fitnesClosed() {
        if (fitnessTime.toLocalTime().isAfter(fitnessClosed) || fitnessTime.toLocalTime().equals(fitnessClosed) ||
                fitnessTime.toLocalTime().isBefore(fitnessOpen)) {

            System.out.println("Фитнес зал закрыт");

            for (int i = 0; i < gym.length; i++) {
                if (gym[i] != null) {
                    gym[i].inFintess = false;
                    gym[i] = null;
                }
            }

            for (int i = 0; i < swimmingPool.length; i++) {
                if (swimmingPool[i] != null) {
                    swimmingPool[i].inFintess = false;
                    swimmingPool[i] = null;
                }
            }

            for (int i = 0; i < groupLesson.length; i++) {
                if (groupLesson[i] != null) {
                    groupLesson[i].inFintess = false;
                    groupLesson[i] = null;
                }
            }
        }

    }

    // Добавление посетителя в массив зоны посещения
    private void addVisitor(Abonement[] sectionArr, Abonement abonement,String visitZone) {

        if (sectionArr[sectionArr.length - 1] != null) {
            System.out.println("В зоне нет свободных мест");

        } else {
            for (int i = 0; i < sectionArr.length; i++) {
                if (sectionArr[i] == null) {
                    sectionArr[i] = abonement;
                    sectionArr[i].inFintess = true;
                    showInfoAboutVisitor(abonement, visitZone);
                    break;
                }
            }
        }


    }

    public void checkAboniment(Abonement abonement, String visitZone) {

        if (abonement == null) throw new IllegalArgumentException("Aбонемент не должен быть null");
        if (visitZone == null) throw new IllegalArgumentException("Зона посещения не должена быть null");
        if (!(GYM.equals(visitZone) || GROUP_LESSON.equals(visitZone) || SWIMMING_POOL.equals(visitZone))) {
            throw new IllegalArgumentException("Зона посещения может быть только: " +
                    "GYM или GROUP_LESSON или SWIMMING_POOL");
        }

        if (abonement.inFintess) {
            System.out.println("Посетитель " + abonement.getPerson().getName() + " уже зпрегистрирован в зоне " + visitZone);
            return;
        }

        if (
                (fitnessTime.toLocalTime().isBefore(fitnessOpen))

                        || (fitnessTime.toLocalTime().isAfter(fitnessClosed))||
                        (fitnessTime.toLocalTime().equals(fitnessClosed))

        ) {
            System.out.println("Извините," + abonement.getPerson().getName() + " фитнес закрыт");

        } else if (
                fitnessTime.toLocalTime().isAfter(abonement.getEndTime())
                        || fitnessTime.toLocalTime().equals(abonement.getEndTime())

        ) {
            System.out.println("Извините, " + abonement.getPerson().getName() + " время посещения не совпадают со временем абонимента");

        } else if (fitnessTime.toLocalDate().isBefore(abonement.getDateOfRegistration())

                || fitnessTime.toLocalDate().isAfter(abonement.getEndOfRegistration())

        ) {
            System.out.println("Извините, "  + abonement.getPerson().getName() + " даты абонимента не совпадают с датами посещения");

        } else {
            Arrays.sort(abonement.getSectionType());
            if (Arrays.binarySearch(abonement.getSectionType(), visitZone) >= 0) {

                switch (visitZone) {
                    case GYM:
                        addVisitor(gym, abonement, visitZone);
                        break;

                    case GROUP_LESSON:
                        addVisitor(groupLesson, abonement, visitZone);
                        break;

                    case SWIMMING_POOL:
                        addVisitor(swimmingPool, abonement, visitZone);
                        break;
                }

            } else {
                System.out.println("Извините,"+ abonement.getPerson().getName() +" желаемая зона не входит в Ваш абонимент");
            }
        }
    }

    private void showInfoAboutVisitor(Abonement abonement, String visitZone) {

        StringBuilder sb = new StringBuilder("Зарегистрировался посетитель" + " \n");

        sb.append(abonement.getPerson().getSurname())
                .append(" ")
                .append(abonement.getPerson().getName())
                .append(" ")
                .append(visitZone)
                .append(" ")
                .append(fitnessTime)
                .append("\n");

        System.out.println(sb.toString());

    }


    private void showInfoSection(Abonement[] sectionsArr, String sectionType) {

        if (sectionsArr == null) throw new IllegalArgumentException("sectionsArr не может быть null");
        if (sectionType == null) throw new IllegalArgumentException("sectionType не должена быть null");
        if (!(GYM.equals(sectionType) || GROUP_LESSON.equals(sectionType) || SWIMMING_POOL.equals(sectionType))) {
            throw new IllegalArgumentException("sectionType может быть только: " +
                    "GYM или GROUP_LESSON или SWIMMING_POOL");
        }

        StringBuilder sb = new StringBuilder("Посетители секции " + sectionType + " \n");
        for (Abonement visitor : sectionsArr) {
            if (visitor != null) {

                sb.append(visitor.getPerson().getSurname())
                        .append(" ")
                        .append(visitor.getPerson().getName())
                        .append(", ")
                        .append(sectionType)
                        .append("\n");
            }
        }
        System.out.println(sb.toString());

    }


    public void showAllInfo() {
        showInfoSection(gym, GYM);
        showInfoSection(swimmingPool, SWIMMING_POOL);
        showInfoSection(groupLesson, GROUP_LESSON);

    }

}





