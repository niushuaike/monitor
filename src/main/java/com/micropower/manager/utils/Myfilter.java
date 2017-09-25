package com.micropower.manager.utils;

import com.lycheeframework.core.common.util.SpringUtil;
import com.micropower.manager.model.po.Saveconfig;
import com.micropower.manager.service.SaveConfigService;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;

import javax.servlet.*;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by niushuaike on 2017/9/19.
 */
public class Myfilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                ThreadPoolTaskScheduler threadPoolTaskScheduler = SpringUtil.getBean(ThreadPoolTaskScheduler.class);

                threadPoolTaskScheduler.schedule(SpringUtil.getBean(ScheduleMonitorRunnable.class),new CronTrigger("0/2 * *  * * ?"));
//                threadPoolTaskScheduler.schedule(SpringUtil.getBean(ScheduleMonitorRunnable.class),new CronTrigger("0 24-27/1 *  * * ?"));
            }
        }, 5 * 1000);

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                SaveConfigService bean = SpringUtil.getBean(SaveConfigService.class);
                Saveconfig saveconfig = bean.queryById(1);
                String[] split = saveconfig.getStarttime().split(":");
                String starttime = "";
                if (split[0].startsWith("0")){
                    starttime=split[0].substring(1);
                }else {
                    starttime=split[0];
                }
                String[] split1 = saveconfig.getEndtime().split(":");
                String endtime = "";
                if (split1[0].startsWith("0")){
                    endtime=split1[0].substring(1);
                }else {
                    endtime=split1[0];
                }
                String cronstr = "0 0 "+starttime+"-"+endtime+"/"+saveconfig.getDeltatime()+" * * ?";
               /* cronstr = "0 0/1 11-12 * * ?";*/
                ThreadPoolTaskScheduler threadPoolTaskScheduler = SpringUtil.getBean(ThreadPoolTaskScheduler.class);
                threadPoolTaskScheduler.schedule(SpringUtil.getBean(ScheduleSaveRunnable.class),new CronTrigger(cronstr));
            }
        }, 5 * 1000);


    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        chain.doFilter(request,response);
    }

    @Override
    public void destroy() {

    }
}
