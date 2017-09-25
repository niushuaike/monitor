import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

/**
 * Created by niushuaike on 2017/9/12.
 */
public class TestJersay {
    public static void main(String[] args) {
        Client client = new Client();
        String url = "http://192.168.199.152/data/20170912.data";
        WebResource resource = client.resource(url);
        String s = resource.get(String.class);
        System.out.println(s);
    }
}
