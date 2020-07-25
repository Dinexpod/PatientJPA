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
    private PAcsessorySize size;
    @Column
    private PAcsessoryState state;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "photometer_id")
    private Photometr ownerPhotometer;

    public enum PAcsessoryState {
        APPLIED,
        UNAPPLIED
    }

    public enum PAcsessorySize {
        LITTLE,
        MIDDLE,
        BIG
    }

    public PhotometerAcsessory(String name, String model, String brand, Double cost, PAcsessorySize size, PAcsessoryState state) {
        super(name, model, brand);
        this.cost = cost;
        this.size = size;
        this.state = state;
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

    public PAcsessorySize getSize() {
        return size;
    }

    public void setSize(PAcsessorySize size) {
        this.size = size;
    }

    public PAcsessoryState getState() {
        return state;
    }

    public void setState(PAcsessoryState state) {
        this.state = state;
    }

    public String customToString() {
        return (super.toString() + "\n" + toString());
    }

    @Override
    public String toString() {
        return "PhotometerAcsessory{" +
                "cost=" + cost +
                ", size=" + size +
                ", state=" + state +
                ", ownerPhotometer=" + ownerPhotometer +
                '}';
    }
}

