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
@Table(name = "acsessories")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Acsessory {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "acsessory_id")
    private Integer id;
    @Column
    private String name;
    @Column
    private String model;
    @Column
    private String brand;

    public Acsessory() {
    }

    public Acsessory(String name, String model, String brand) {
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
}
