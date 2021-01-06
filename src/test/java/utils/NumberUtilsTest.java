package utils;

import com.wah.commons.utils.NumberUtils;
import com.wah.commons.utils.UUIDUtils;
import org.junit.Test;

public class NumberUtilsTest{

    @Test
    public void binary(){
        long dec = 10;

        System.out.println(NumberUtils.binary(dec));
    }

    @Test
    public void convert(){
        String uuid = UUIDUtils.uuid32();

        System.out.println(NumberUtils.convert(uuid, 16, 36));
    }
}
