package mate.academy.jpademo.test;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity(name = "skin_tests")
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
