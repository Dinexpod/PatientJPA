package mate.academy.jpddemo.model.test;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "blood_tests")
public class BloodTest extends Test {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "blood_test_id")
    private Integer id;
    @Column
    private Double cost;
    @Column
    private LocalDate date;
    @Column
    private State State;

    public enum State {
        EXECUTED,
        NOT_EXECUTED
    }

    public BloodTest(String name, Type type, String location, Double cost, LocalDate date, BloodTest.State state) {
        super(name, type, location);
        this.cost = cost;
        this.date = date;
        State = state;
    }

    public BloodTest() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public BloodTest.State getState() {
        return State;
    }

    public void setState(BloodTest.State state) {
        State = state;
    }

    public String customToString() {
        return (super.toString() + "\n" + toString());
    }

    @Override
    public String toString() {
        return "BloodTest{" +
                "cost=" + cost +
                ", date=" + date +
                ", State=" + State +
                '}';
    }
}
