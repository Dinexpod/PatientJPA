package mate.academy.jpddemo.model.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Objects;

@XmlRootElement
public class DeviceDto {

    private Integer id;

    private String name;

    private String model;

    private String brand;


    public DeviceDto() {

    }

    public DeviceDto(Integer id, String name, String model, String brand) {
        this.id = id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DeviceDto deviceDto = (DeviceDto) o;
        return Objects.equals(id, deviceDto.id) &&
                Objects.equals(name, deviceDto.name) &&
                Objects.equals(model, deviceDto.model) &&
                Objects.equals(brand, deviceDto.brand);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, model, brand);
    }
}
