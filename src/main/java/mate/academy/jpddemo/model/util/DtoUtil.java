package mate.academy.jpddemo.model.util;

import mate.academy.jpddemo.model.devices.Device;
import mate.academy.jpddemo.model.dto.DeviceDto;
import org.hibernate.SessionFactory;

public class DtoUtil {
   public static DeviceDto parseDevice(Device device) {
       DeviceDto dto = new DeviceDto();
       dto.setName(device.getName());
       dto.setBrand(device.getBrand());
       dto.setId(device.getId());
       dto.setModel(device.getModel());

       return dto;
   }
}
