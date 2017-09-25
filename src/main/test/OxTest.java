import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
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
        Date currentdate = new Date(new Date().getTime()-2*60*60*1000);
        System.out.println(currentdate);
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(7);
        list.add(23);
        list.add(25);
        System.out.println(list.toString());
    }

}
