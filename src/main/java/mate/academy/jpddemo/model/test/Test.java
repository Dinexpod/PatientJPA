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

@Entity
@Table(name = "tests")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Test {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "test_id")
    private Integer id;
    @Column
    private String name;
    @Column
    private Type type;
    @Column
    private String location;

    public enum Type {
        FOR_KID,
        FOR_ADULT,
        FOR_OLD
    }

    public Test() {
    }

    public Test(String name, Type type, String location) {
        this.name = name;
        this.type = type;
        this.location = location;
    }

    public String myToStringTest() {
        return "Test [" +
                "name = " + name +
                ", type = " + type +
                ", location = " + location;
    }
}