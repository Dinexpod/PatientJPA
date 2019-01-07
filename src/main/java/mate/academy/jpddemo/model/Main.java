package mate.academy.jpddemo.model;

import mate.academy.jpddemo.model.acsessory.Acsessory;
import mate.academy.jpddemo.model.acsessory.PhotometerAcsessory;
import mate.academy.jpddemo.model.devices.Device;
import mate.academy.jpddemo.model.devices.Photometr;
import mate.academy.jpddemo.model.model.Patient;
import mate.academy.jpddemo.model.test.SkinTest;
import mate.academy.jpddemo.model.test.Test;

import java.time.LocalDate;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Patient patient = new Patient("Tony", "Lev", new Date());



        Photometr photometr = new Photometr();

        PhotometerAcsessory photometerAcsessory = new PhotometerAcsessory(
                "photometerAcsessory",
                "ABS",
                "DIDC",
                1300.8,
                PhotometerAcsessory.AcsessorySize.BIG,
                PhotometerAcsessory.AcsessoryState.UNAPPLIED);

        photometr.turnOnAcsessory(photometerAcsessory).doTest(patient);
    }
}
