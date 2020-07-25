//package mate.academy.jpademo.model;
//
//import Patient;
//import mate.academy.jpademo.model.model.SuperPatient;
//
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.Persistence;
//import java.util.Date;
//
//public class MainEnother {
//    private static EntityManager em;
//
//    public static void main(String[] args) {
//        EntityManagerFactory emf = Persistence
//                .createEntityManagerFactory("PatientPU");
//        em = emf.createEntityManager();
//
//        Patient createPatient = createPatient("Bob", "UsetLastName");
//        SuperPatient superPatient = createSuperPatient("Bob", "UsetLastName", "superpow", "fen");
//    }
//
//    private static Patient createPatient(String firstName, String lastName) {
//        Date dateOfBirth = new Date();
//        em.getTransaction().begin();
//        Patient pat = new Patient(firstName, lastName, em);
//        em.persist(pat);
//        em.flush();
//        em.getTransaction().commit();
//        return pat;
//    }
//
//    private static SuperPatient createSuperPatient(String firstName, String lastName, String power, String drugs) {
//        Date dateOfBirth = new Date();
//        em.getTransaction().begin();
//        SuperPatient spat = new SuperPatient(firstName, lastName, power, drugs);
//        em.persist(spat);
//        em.flush();
//        em.getTransaction().commit();
//        return spat;
//    }
//
//    public Patient add(Patient patient) {
//        em.getTransaction().begin();
//        Patient pat = em.merge(patient);
//        em.getTransaction().commit();
//        return pat;
//    }
//
//    public void delete(long id) {
//        em.getTransaction().begin();
//        em.remove(get(id));
//        em.getTransaction().commit();
//    }
//
//    public Patient get(long id) {
//        return em.find(Patient.class, id);
//    }
//
//    public void update(Patient patient) {
//        em.getTransaction().begin();
//        em.merge(patient);
//        em.getTransaction().commit();
//    }
//}
