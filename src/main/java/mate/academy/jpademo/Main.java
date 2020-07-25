package mate.academy.jpademo;

import mate.academy.jpademo.model.PatientService;
import mate.academy.jpademo.test.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;


public class Main {
    private static EntityManager em;

    public static EntityManager getEm() {
        return em;
    }

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence
                .createEntityManagerFactory("PatientPU");
        em = emf.createEntityManager();

//        Patient patient = new Patient ("Tony", "Lev", em);
//        Photometr photometr = new Photometr(
//                "Photometer",
//                "SWE",
//                "ww",
//                33,
//                "sfcewcse",
//                354.0,
//                em);
//        PhotometerAcsessory photometerAcsessory = new PhotometerAcsessory(
//                "photometerAcsessory",
//                "ABS",
//                "DIDC",
//                1300.8,
//                PhotometerAcsessory.PAcsessorySize.BIG,
//                PhotometerAcsessory.PAcsessoryState.UNAPPLIED);
//
//        Test skinTest = photometr.turnOnAcsessory(photometerAcsessory).doTest(patient);
//        saveTest(skinTest);
//
//        System.out.println("==========================================================");
//
//        Patient patient1 = new Patient("Jack", "Bond", em);
//        UltrasonicDevice ultrasonicDevice = new UltrasonicDevice(
//                "UltrasonicDevice",
//                "SWE",
//                "ff",
//                44,
//                "sfcewcse",
//                3454.0,
//                em);
//        UltrasonicAcsessory ultrasonicAcsessory = new UltrasonicAcsessory(
//                "UltrasonicAcsessory",
//                "CRV",
//                "KNDJ",
//                1600.8,
//                UltrasonicAcsessory.UAcsessorySize.BIG,
//                UltrasonicAcsessory.UAcsessoryState.UNAPPLIED);
//
//        Test ultrasonicTest = ultrasonicDevice.turnOnAcsessory(ultrasonicAcsessory).doTest(patient1);
//        saveTest(ultrasonicTest);

        PatientService patientService = new PatientService();
        List<Test> tests = patientService.getAllTests();
        System.out.println(tests.toString());
    }
    private static void saveTest(Test test) {
        em.getTransaction().begin();
        em.persist(test);
        em.flush();
        em.getTransaction().commit();
    }

    public static List<Test> getPatientByName() {
        TypedQuery<Test> query =
                em
                        .createQuery("select p from tests p ", Test.class);

        return query.getResultList();
    }
}
