import com.micropower.manager.utils.JDBCUtil;
import org.apache.commons.io.IOUtils;

import java.io.*;
import java.net.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;

/**
 * Created by niushuaike on 2017/9/17.
 */
public class OxTest {

    public static void main1(String[] args) {
        try {
            Process exec = Runtime.getRuntime().exec("cmd.exe /k notepad");
            System.out.println(exec.toString());
            InputStream inputStream = exec.getInputStream();
            exec.waitFor();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main2(String[] args) {
        Date currentdate = new Date(new Date().getTime() - 2 * 60 * 60 * 1000);
        System.out.println(currentdate);
    }

    public static void main3(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(7);
        list.add(23);
        list.add(25);
        System.out.println(list.toString());
    }

    public static void main4(String[] args) throws IOException {
        //isNormal("");
        testJdbc();
    }

    private static Boolean isNormal(String keyDeviceIp) throws IOException {
        System.out.println("开始");
        Process exec = Runtime.getRuntime().exec("ping 192.168.199.195");
        System.out.println("开始获取流");
        InputStream inputStream = exec.getInputStream();
        System.out.println("已经获取流");
        BufferedReader input = new BufferedReader(new InputStreamReader(inputStream, "gbk"));
        String returnStr="231";
        while (input.read() > 0) {
            returnStr+=input.readLine();
        }
        System.out.println(returnStr);
        if (returnStr.contains("无法访问目标主机") || returnStr.contains("Destination Host Unreachable")) {
            return false;
        } else {
            return true;
        }
    }

    private  static void testJdbc(){
        String returnstr = "v_v";
        try {
            Connection connection = JDBCUtil.getConnection();
            String sql = "SELECT id,maincontrolip FROM device WHERE device_type=1";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                returnstr = resultSet.getString(2);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(returnstr);
    }

    public static void main5(String[] args) {
        char i='1';
        float f1= (float) 1.0;
        float f2= (float) 2.0;

        System.out.println(f1<f2);
    }


    public static void main8(String[] args) throws IOException {

        File file1 = new File("WEB-INF/data/20171008.data");
        System.out.println(file1.getAbsolutePath());

        /*FileReader fileReader = new FileReader("WEB-INF/data/20171008.data");
        System.out.println(fileReader);*/
        List<String> strings = IOUtils.readLines(new FileReader("/usr/java/code/monitor/src/main/webapp/WEB-INF/data/20171008.data"));
        for (String str:strings){
            System.out.println(str);
        }
    }

    public static void main(String[] args) throws Exception {
        String linuxLocalIp = getLinuxLocalIp();
        System.out.println(linuxLocalIp);
        int i=1;
    }

    private static String getLinuxLocalIp() throws SocketException {
        String ip = "";
        try {
            for (Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces(); en.hasMoreElements();) {
                NetworkInterface intf = en.nextElement();
                String name = intf.getName();
                if (!name.contains("docker") && !name.contains("lo")) {
                    for (Enumeration<InetAddress> enumIpAddr = intf.getInetAddresses(); enumIpAddr.hasMoreElements();) {
                        InetAddress inetAddress = enumIpAddr.nextElement();
                        if (!inetAddress.isLoopbackAddress()) {
                            String ipaddress = inetAddress.getHostAddress().toString();
                            if (!ipaddress.contains("::") && !ipaddress.contains("0:0:") && !ipaddress.contains("fe80")) {
                                ip = ipaddress;
                            }
                        }
                    }
                }
            }
        } catch (SocketException ex) {
            System.out.println("获取ip地址异常");
            ip = "127.0.0.1";
            ex.printStackTrace();
        }
        return ip;
    }

}
