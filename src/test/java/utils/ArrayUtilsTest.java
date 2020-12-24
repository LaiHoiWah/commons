package utils;

import com.wah.commons.utils.ArrayUtils;
import org.junit.Test;

public class ArrayUtilsTest{

    @Test
    public void isEmptyByByte(){
        byte[] bytes_1 = new byte[0];
        Byte[] bytes_2 = new Byte[0];

        System.out.println(ArrayUtils.isEmpty(bytes_1));
        System.out.println(ArrayUtils.isEmpty(bytes_2));
    }
}
