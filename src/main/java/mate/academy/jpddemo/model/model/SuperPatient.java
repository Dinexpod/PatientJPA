//package mate.academy.jpddemo.model.model;
//
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//import mate.academy.jpddemo.model.Main;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.EntityManager;
//import javax.persistence.Table;
//import java.util.Date;
//
//@Entity
//@Table(name = "superpatient")
//public class SuperPatient extends Patient {
//    private static EntityManager em = Main.getEm();
//
//    @Column(name = "power")
//    private String power;
//    @Column(name = "drugs")
//    private String drugs;
//
//    public SuperPatient() {
//    }
//
//    public SuperPatient(String name, String lastName, String power, String drugs) {
//        super(name, lastName, em);
//        this.power = power;
//        this.drugs = drugs;
//    }
//
//    public String getPower() {
//        return power;
//    }
//
//    public void setPower(String power) {
//        this.power = power;
//    }
//
//    public String getDrugs() {
//        return drugs;
//    }
//
//    public void setDrugs(String drugs) {
//        this.drugs = drugs;
//    }
//}
