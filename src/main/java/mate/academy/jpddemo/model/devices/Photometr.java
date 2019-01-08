package mate.academy.jpddemo.model.devices;

import mate.academy.jpddemo.model.acsessory.Acsessory;
import mate.academy.jpddemo.model.acsessory.PhotometerAcsessory;
import mate.academy.jpddemo.model.model.Patient;
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

import static mate.academy.jpddemo.model.acsessory.PhotometerAcsessory.PAcsessoryState.APPLIED;
import static mate.academy.jpddemo.model.acsessory.PhotometerAcsessory.PAcsessoryState.UNAPPLIED;

@Entity
@Table(name = "photomeeters")
public class Photometr extends Device {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "photometr_id")
    private Integer id;
    @Column
    private Integer weight;
    @Column(name = "qr_code")
    private String qrCode;
    @Column
    private Double cost;
    @Column
    @OneToMany(mappedBy = "ownerPhotometer", fetch = FetchType.EAGER)
    protected List<PhotometerAcsessory> photometerAcsessories = new ArrayList<>(1);

    @Override
    public Test doTest(Patient patient) {
        super.doTest(patient);
        System.out.print("by PHOTOMETER for " + patient.getName());
        SkinTest skinTest = createSkinTest();
        System.out.println("\n" + skinTest.customToString());
        return skinTest;
    }

    private SkinTest createSkinTest() {
        return new  SkinTest("SkinTest",
                Test.Type.FOR_ADULT,
                "Kyiv",
                1200.0,
                LocalDate.now(),
                SkinTest.State.EXECUTED);
    }

    @Override
    public Device turnOnAcsessory(Object acsessory) {
        PhotometerAcsessory photometerAcsessory = (PhotometerAcsessory) acsessory;
        photometerAcsessories.add(photometerAcsessory);
        photometerAcsessory.setState(APPLIED);
        System.out.println("Photometer acsessory turned ON");
        return this;
    }

    @Override
    public Device turnOffAcsessory(Object acsessory) {
        PhotometerAcsessory photometerAcsessory = (PhotometerAcsessory) acsessory;
        photometerAcsessories.remove(photometerAcsessory);
        photometerAcsessory.setState(UNAPPLIED);
        System.out.println("Photometer acsessory turned OFF");
        return this;
    }

    public Photometr() {
    }

    public Photometr(String name, String model, String brand, Integer weight, String qrCode, Double cost) {
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
        return "Photometr{" +
                "weight=" + weight +
                ", qrCode='" + qrCode + '\'' +
                ", cost=" + cost +
                '}';
    }
}
