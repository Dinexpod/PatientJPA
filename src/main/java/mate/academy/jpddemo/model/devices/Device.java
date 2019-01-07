package mate.academy.jpddemo.model.devices;

import mate.academy.jpddemo.model.acsessory.PhotometerAcsessory;
import mate.academy.jpddemo.model.model.Patient;
import mate.academy.jpddemo.model.test.Test;

import javax.persistence.Column;
import javax.persistence.Entity;
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

    protected Device turnOnAcsessory(PhotometerAcsessory photometerAcsessory) {
        this.avaliableAcsessory = true;
        return this;
    }

    protected Device turnOffAcsessory(PhotometerAcsessory photometerAcsessory) {
        this.avaliableAcsessory = false;
        return this;
    }

    public void doTest(Patient patient) {
        System.out.print("do test ");
    }

    public Device() {
    }

    public Device(String name, String model, String brand) {
        this.name = name;
        this.model = model;
        this.brand = brand;
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
                "id=" + id +
                ", name='" + name + '\'' +
                ", model='" + model + '\'' +
                ", brand='" + brand + '\'' +
                '}';
    }
}
