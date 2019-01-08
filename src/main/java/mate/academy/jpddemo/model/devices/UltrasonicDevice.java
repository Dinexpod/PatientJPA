package mate.academy.jpddemo.model.devices;

import mate.academy.jpddemo.model.acsessory.PhotometerAcsessory;
import mate.academy.jpddemo.model.acsessory.UltrasonicAcsessory;
import mate.academy.jpddemo.model.model.Patient;
import mate.academy.jpddemo.model.test.BloodTest;
import mate.academy.jpddemo.model.test.SkinTest;
import mate.academy.jpddemo.model.test.Test;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static mate.academy.jpddemo.model.acsessory.UltrasonicAcsessory.UAcsessoryState.APPLIED;
import static mate.academy.jpddemo.model.acsessory.UltrasonicAcsessory.UAcsessoryState.UNAPPLIED;

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
    @Column
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "ownerUltrasonic")
    private List<UltrasonicAcsessory> ultrasonicAcsessories = new ArrayList<>(1);


    @Override
    public Test doTest(Patient patient) {
        super.doTest(patient);
        System.out.print("by ULTRASONIC DEVICE!");
        BloodTest bloodTest = createBloodTest();
        System.out.println("\n" + bloodTest.customToString());
        return bloodTest;
    }

    private BloodTest createBloodTest() {
        return new  BloodTest("UltrasonicTest",
                Test.Type.FOR_ADULT,
                "DNIPRO",
                1600.0,
                LocalDate.now(),
                BloodTest.State.EXECUTED);
    }

    @Override
    public Device turnOnAcsessory(Object acsessory) {
        UltrasonicAcsessory ultrasonicAcsessory = (UltrasonicAcsessory) acsessory;
        ultrasonicAcsessories.add(ultrasonicAcsessory);
        ultrasonicAcsessory.setState(APPLIED);
        System.out.println("Ultrasonic acsessory turned ON");
        return this;
    }

    @Override
    public Device turnOffAcsessory(Object acsessory) {
        UltrasonicAcsessory ultrasonicAcsessory = (UltrasonicAcsessory) acsessory;
        ultrasonicAcsessories.add(ultrasonicAcsessory);
        ultrasonicAcsessory.setState(UNAPPLIED);
        System.out.println("Ultrasonic acsessory turned OFF");
        return this;
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

    public String customToString() {
        return (super.toString() + "\n" + toString());
    }

    @Override
    public String toString() {
        return "UltrasonicDevice{" +
                "weight=" + weight +
                ", qrCode='" + qrCode + '\'' +
                ", cost=" + cost +
                '}';
    }
}
