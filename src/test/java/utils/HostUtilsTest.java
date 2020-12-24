package utils;

import com.wah.commons.utils.HostUtils;
import org.junit.Test;

public class HostUtilsTest{

    @Test
    public void httpHost(){
        String url = "192.168.3.1/hello/test.do?test1=1&test2=2";

        HostUtils.Host host = HostUtils.getHttpHost(url);

        System.out.println(host.toString());
        System.out.println(host.getHostname());
        System.out.println(host.getPath());
        System.out.println(host.paramsMap());
    }
}
