package mate.academy.jpddemo.model;

import mate.academy.jpddemo.model.acsessory.PhotometerAcsessory;
import mate.academy.jpddemo.model.acsessory.UltrasonicAcsessory;
import mate.academy.jpddemo.model.devices.Photometr;
import mate.academy.jpddemo.model.devices.UltrasonicDevice;
import mate.academy.jpddemo.model.model.Patient;
import mate.academy.jpddemo.model.test.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Date;


public class Main {
    private static EntityManager em;

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence
                .createEntityManagerFactory("PatientPU");
        em = emf.createEntityManager();

        Patient patient = createPatient("Tony", "Lev");
        Photometr photometr = new Photometr();
        PhotometerAcsessory photometerAcsessory = new PhotometerAcsessory(
                "photometerAcsessory",
                "ABS",
                "DIDC",
                1300.8,
                PhotometerAcsessory.PAcsessorySize.BIG,
                PhotometerAcsessory.PAcsessoryState.UNAPPLIED);

        Test skinTest = photometr.turnOnAcsessory(photometerAcsessory).doTest(patient);

        System.out.println("==========================================================");

        Patient patient1 = createPatient("Jack", "Bond");
        UltrasonicDevice ultrasonicDevice = new UltrasonicDevice();
        UltrasonicAcsessory ultrasonicAcsessory = new UltrasonicAcsessory(
                "UltrasonicAcsessory",
                "CRV",
                "KNDJ",
                1600.8,
                UltrasonicAcsessory.UAcsessorySize.BIG,
                UltrasonicAcsessory.UAcsessoryState.UNAPPLIED);

        Test ultrasonicTest = ultrasonicDevice.turnOnAcsessory(ultrasonicAcsessory).doTest(patient1);

    }

    private static Patient createPatient(String firstName, String lastName) {
        Date dateOfBirth = new Date();
        em.getTransaction().begin();
        Patient pat = new Patient(firstName, lastName, dateOfBirth);
        em.persist(pat);
        em.flush();
        em.getTransaction().commit();
        return pat;
    }
}
