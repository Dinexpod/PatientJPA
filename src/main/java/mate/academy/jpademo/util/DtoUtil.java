package mate.academy.jpademo.util;

import mate.academy.jpademo.dto.DeviceDto;
import mate.academy.jpademo.devices.Device;

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
