package mate.academy.jpddemo.model;

import mate.academy.jpddemo.model.devices.Device;
import mate.academy.jpddemo.model.dto.DeviceDto;
import mate.academy.jpddemo.model.util.DtoUtil;
import mate.academy.jpddemo.model.util.HibernateUtil;
import org.hibernate.Session;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class XmlMain {
    public static void main(String[] args) {
//        Integer id = createDevice();
//        Device device = getDevice(id);
//
//        System.out.println(deviceDto.toString());
//        writeDeviceToXml(deviceDto, new File("device1.xml"));
        DeviceDto deviceDto = getDeviceDto(50);
      File file = new File("src/main/java/mate/academy/jpddemo/model/matedevice11.xml");
      writeDeviceToXml(deviceDto, file);


        System.out.println(deviceDto.equals(readDeviceFromXml(file)));



    }

    public static  Integer createDevice() {
        return HibernateMain.createDevice();
    }

    public static  DeviceDto getDeviceDto(Integer id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        DeviceDto deviceDto = DtoUtil.parseDevice(session.load(Device.class, id));
        session.close();
        return deviceDto;
    }

    public static void writeDeviceToXml(DeviceDto deviceDto, File file) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(DeviceDto.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            marshaller.marshal(deviceDto, file);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    public static  DeviceDto readDeviceFromXml(File file) {

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(DeviceDto.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            DeviceDto deviceDto = (DeviceDto) unmarshaller.unmarshal(file);
            return deviceDto;
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }
}
