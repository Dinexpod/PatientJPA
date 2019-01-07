package mate.academy.jpddemo.model.acsessory;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mate.academy.jpddemo.model.devices.Photometr;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "photometer_acsessories")
public class PhotometerAcsessory extends Acsessory {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "photometer_acsessory_id")
    private Integer id;
    @Column
    private Double cost;
    @Column
    private AcsessorySize size;
    @Column
    private AcsessoryState State;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "photometer_id")
    private Photometr ownerPhotometer;

    public enum AcsessoryState {
        APPLIED,
        UNAPPLIED
    }

    public enum AcsessorySize {
        LITTLE,
        MIDDLE,
        BIG
    }

    public PhotometerAcsessory(String name, String model, String brand, Double cost, AcsessorySize size, AcsessoryState state) {
        super(name, model, brand);
        this.cost = cost;
        this.size = size;
        State = state;
    }

    public PhotometerAcsessory() {
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

    public AcsessorySize getSize() {
        return size;
    }

    public void setSize(AcsessorySize size) {
        this.size = size;
    }

    public AcsessoryState getState() {
        return State;
    }

    public void setState(AcsessoryState state) {
        State = state;
    }
}

