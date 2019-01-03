package mate.academy.jpddemo.model;

import mate.academy.jpddemo.model.model.Patient;

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

        Patient createPatient = createPatient("Bob", "UsetLastName");
    }

    private static Patient createPatient(String firstName, String lastName) {
        Date dateOfBirth = new Date();
        em.getTransaction().begin();
        Patient pat = new Patient(firstName, lastName, dateOfBirth);
        return pat;
    }

    public Patient add(Patient patient) {
        em.getTransaction().begin();
        Patient pat = em.merge(patient);
        em.getTransaction().commit();
        return pat;
    }

    public void delete(long id) {
        em.getTransaction().begin();
        em.remove(get(id));
        em.getTransaction().commit();
    }

    public Patient get(long id) {
        return em.find(Patient.class, id);
    }

    public void update(Patient patient) {
        em.getTransaction().begin();
        em.merge(patient);
        em.getTransaction().commit();
    }
}
