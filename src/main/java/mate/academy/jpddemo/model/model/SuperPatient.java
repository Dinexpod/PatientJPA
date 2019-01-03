package mate.academy.jpddemo.model.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "superpatient")
public class SuperPatient extends Patient {
    @Column(name = "power")
    private String power;
    @Column(name = "drugs")
    private String drugs;

    public SuperPatient(String name, String lastName, Date date, String power, String drugs) {
        super(name, lastName, date);
        this.power = power;
        this.drugs = drugs;
    }

    public SuperPatient() {
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public String getDrugs() {
        return drugs;
    }

    public void setDrugs(String drugs) {
        this.drugs = drugs;
    }
}
