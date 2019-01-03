package mate.academy.jpddemo.model;

import mate.academy.jpddemo.model.devices.Device;
import mate.academy.jpddemo.model.util.HibernateUtil;
import org.hibernate.Session;

public class HibernateMain {
    public static void main(String[] args) {
        Integer id = createDevice();
        Device device = getDevice(id);
    }

    public static Integer createDevice() {
        Device device = new Device();
        device.setName("ultrasonic device");
        device.setBrand("ESAOTE");
        device.setModel("ES-115");

        Session session = HibernateUtil.getSessionFactory().openSession();
        Integer id = (Integer) session.save(device);
        session.close();
        return id;
    }

    public static Device getDevice(Integer id) {
        System.out.println("First level cache example");
        Session session = HibernateUtil.getSessionFactory().openSession();
        Device device = session.load(Device.class, id);
        System.out.println(device.getModel());

        Device deviceOneMore = session.load(Device.class, id);
        System.out.println(device.getModel());
        session.close();
        return deviceOneMore;


    }
}
