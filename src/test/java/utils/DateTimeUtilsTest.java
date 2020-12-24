package utils;

import com.wah.commons.utils.DateTimeUtils;
import org.junit.Test;

import java.util.Date;

public class DateTimeUtilsTest{

    @Test
    public void toStrings(){
        Date now = new Date();

        System.out.println(DateTimeUtils.toString(now));
    }
}
