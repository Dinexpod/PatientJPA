package mate.academy.jpddemo.model.devices;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mate.academy.jpddemo.model.acsessory.Acsessory;
import mate.academy.jpddemo.model.acsessory.PhotometerAcsessory;
import mate.academy.jpddemo.model.model.Patient;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Entity
@Table(name = "Ultrasonic_devices")
public class UltrasonicDevice extends Device {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "ultrasonic_device_id")
    private Integer id;
    @Column
    private Integer weight;
    @Column(name = "qr_code")
    private String qrCode;
    @Column
    private Double cost;


    @Override
    public void doTest(Patient patient) {
        super.doTest(patient);
        System.out.println("by ULTRASONIC DEVICE!");
    }

    public UltrasonicDevice() {
    }

    public UltrasonicDevice(String name, String model, String brand, Integer weight, String qrCode, Double cost) {
        super(name, model, brand);
        this.weight = weight;
        this.qrCode = qrCode;
        this.cost = cost;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getQrCode() {
        return qrCode;
    }

    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }
}
