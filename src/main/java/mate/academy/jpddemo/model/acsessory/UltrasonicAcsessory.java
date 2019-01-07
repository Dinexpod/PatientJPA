package mate.academy.jpddemo.model.acsessory;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name = "ultrasonic_acsessories")
public class UltrasonicAcsessory extends Acsessory {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "ultrasonic_acsessory_id")
    private Integer id;
    @Column
    private Double cost;
    @Column
    private acsessorySize size;
    @Column
    private acsessoryState State;

    public enum acsessoryState {
        APPLIED,
        UNAPPLIED
    }

    public enum acsessorySize {
        LITTLE,
        MIDDLE,
        BIG
    }

    public UltrasonicAcsessory() {
    }

    public UltrasonicAcsessory(String name, String model, String brand, Double cost, acsessorySize size, acsessoryState state) {
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

    public acsessorySize getSize() {
        return size;
    }

    public void setSize(acsessorySize size) {
        this.size = size;
    }

    public acsessoryState getState() {
        return State;
    }

    public void setState(acsessoryState state) {
        State = state;
    }
}
