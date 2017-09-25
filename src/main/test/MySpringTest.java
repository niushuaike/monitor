import com.micropower.manager.service.WarnLogService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by niushuaike on 2017/9/21.
 */
@Transactional
public class MySpringTest extends TestBase {

    @Autowired
    WarnLogService warnLogService;

    @Test
    public void fun1() {
        Map<String, String> map = new HashMap<>();
        map.put("id", "7072");
        map.put("warnstate", "4");
        warnLogService.updateWarnLogStatus(map);

        int i = 1 / 0;

    }
}
