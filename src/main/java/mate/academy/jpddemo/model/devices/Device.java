package mate.academy.jpddemo.model.devices;

import mate.academy.jpddemo.model.Main;
import mate.academy.jpddemo.model.acsessory.PhotometerAcsessory;
import mate.academy.jpddemo.model.model.Patient;
import mate.academy.jpddemo.model.test.Test;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "devices")
@Inheritance(strategy = InheritanceType.JOINED)
public class Device {
    private static EntityManager em = Main.getEm();

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "device_id")
    private Integer id;
    @Column
    private String name;
    @Column
    private String model;
    @Column
    private String brand;
    boolean avaliableAcsessory = false;

    protected Device turnOnAcsessory(Object acsessory) {
        this.avaliableAcsessory = true;
        return this;
    }

    protected Device turnOffAcsessory(Object acsessory) {
        this.avaliableAcsessory = false;
        return this;
    }

    public Test doTest(Patient patient) {
        System.out.print("do test ");
        return new Test();
    }

    public Device() {
    }

    public Device(String name, String model, String brand, EntityManager em) {
        this.name = name;
        this.model = model;
        this.brand = brand;

        em.getTransaction().begin();
        em.persist(this);
        em.flush();
        em.getTransaction().commit();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "Device{" +
                "name='" + name + '\'' +
                ", model='" + model + '\'' +
                ", brand='" + brand + '\'' +
                ", avaliableAcsessory=" + avaliableAcsessory +
                '}';
    }
}
