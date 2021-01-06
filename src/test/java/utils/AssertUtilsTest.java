package utils;

import com.wah.commons.utils.AssertUtils;
import org.junit.Test;

public class AssertUtilsTest{

    @Test
    public void isEmptyByArray(){
        byte[] bytes_1 = new byte[0];
        Byte[] bytes_2 = new Byte[0];

        try{
            AssertUtils.notEmpty(bytes_1, "ok");
        }catch(Exception e){
            System.out.println("ok");
        }

        try{
            AssertUtils.notEmpty(bytes_2, "ok");
        }catch(Exception e){
            System.out.println("ok");
        }
    }
}
