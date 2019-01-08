package mate.academy.jpddemo.model.model;

import mate.academy.jpddemo.model.Main;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "patient")
@Inheritance(strategy = InheritanceType.JOINED)
public class Patient {
    private static EntityManager em = Main.getEm();

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "patient_id")
    int id;
    @Column(name = "name")
    String name;
    @Column(name = "last_name")
    String lastName;
    @Column(name = "date")
    Date date;

    public Patient() {
    }

    public Patient(String name, String lastName, EntityManager em) {
        this.name = name;
        this.lastName = lastName;
        date = new Date();

        em.getTransaction().begin();
        em.persist(this);
        em.flush();
        em.getTransaction().commit();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", date=" + date +
                '}';
    }
}
