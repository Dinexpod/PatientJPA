package mate.academy.jpademo;

import org.junit.Assert;
import org.junit.Test;

import javax.persistence.Table;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class RegExTest {
    private String regEx = "^((\\+38)[\\- ]?)?(\\(?0\\d{2}\\)?[\\- ]?)?[\\d\\- ]{7,10}$";
    private String phoneNumber = "+38(026)123-45-67";

    @Test
    public void phoneNumberTest() {
        Pattern p = Pattern.compile(regEx);

        Matcher m = p.matcher(phoneNumber);
        Assert.assertTrue(m.find());

        m = p.matcher("+38(926)123-45-67");
        Assert.assertFalse(m.find());
    }


}
