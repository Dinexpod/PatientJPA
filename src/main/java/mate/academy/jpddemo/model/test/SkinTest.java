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
@Table(name = "skin_tests")
public class SkinTest extends Test {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "skin_test_id")
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

    public SkinTest() {
    }

    public SkinTest(String name, Type type, String location, Double cost, LocalDate date, State state) {
        super(name, type, location);
        this.cost = cost;
        this.date = date;
        State = state;
    }

    public String customToString() {
        return (super.toString() + "\n" + toString());
    }

    @Override
    public String toString() {
        return "SkinTest{" +
                "cost=" + cost +
                ", date=" + date +
                ", State=" + State +
                '}';
    }
}
