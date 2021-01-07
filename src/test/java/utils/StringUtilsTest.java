package utils;

import com.wah.commons.utils.StringUtils;
import org.junit.Test;

public class StringUtilsTest{

    @Test
    public void capitalize(){
        String txt = "123hello";

        System.out.println((StringUtils.capitalize(txt)));
    }
}
