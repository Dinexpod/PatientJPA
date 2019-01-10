package mate.academy.jpademo.acsessory;

import mate.academy.jpademo.devices.Photometr;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "ultrasonic_acsessories")
public class UltrasonicAcsessory extends Acsessory {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "ultrasonic_acsessory_id")
    private Integer id;
    @Column
    private Double cost;
    @Column
    private UAcsessorySize size;
    @Column
    private UAcsessoryState State;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "ultrasonic_id", nullable = false)
    private Photometr ownerUltrasonic;

    public enum UAcsessoryState {
        APPLIED,
        UNAPPLIED
    }

    public enum UAcsessorySize {
        LITTLE,
        MIDDLE,
        BIG
    }

    public UltrasonicAcsessory() {
    }

    public UltrasonicAcsessory(String name, String model, String brand, Double cost, UAcsessorySize size, UAcsessoryState state) {
        super(name, model, brand);
        this.cost = cost;
        this.size = size;
        State = state;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public UAcsessorySize getSize() {
        return size;
    }

    public void setSize(UAcsessorySize size) {
        this.size = size;
    }

    public UAcsessoryState getState() {
        return State;
    }

    public void setState(UAcsessoryState state) {
        State = state;
    }


    public String customToString() {
        return (super.toString() + "\n" + toString());
    }

    @Override
    public String toString() {
        return "UltrasonicAcsessory{" +
                "cost=" + cost +
                ", size=" + size +
                ", State=" + State +
                ", ownerUlrasonic=" + ownerUltrasonic +
                '}';
    }
}
