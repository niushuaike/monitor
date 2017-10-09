package com.micropower.manager.service.impl;

import com.micropower.manager.model.po.User;
import com.micropower.manager.model.po.Warntimeperiod;
import com.micropower.manager.model.pojo.WarntimeperiodPojo;
import com.micropower.manager.service.UserService;
import com.micropower.manager.service.WarntimeperiodService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by oliver on 2017/9/4.
 */
@Service
public class WarntimeperiodServiceImpl extends BaseServiceImpl<Warntimeperiod> implements WarntimeperiodService {
    @Override
    public Integer delete(Integer id) {
        return manager.deleteByID(namespace + "delete", id);
    }

    @Override
    public List<WarntimeperiodPojo> listpojo() {
        List<WarntimeperiodPojo> listpojo = new ArrayList<>();
        List<Warntimeperiod> list = (List<Warntimeperiod>) manager.list(namespace + "list");
        for (Warntimeperiod warntimeperiod : list) {
            WarntimeperiodPojo warntimeperiodPojo = new WarntimeperiodPojo();

            String[] split1 = warntimeperiod.getMonday().split("-");

            if (split1.length >= 2) {

                warntimeperiodPojo.setStartmonday(split1[0]);
                warntimeperiodPojo.setEndmonday(split1[1]);
            }


            String[] split2 = warntimeperiod.getTuesday().split("-");
            if (split2.length >= 2) {

                warntimeperiodPojo.setStarttuesday(split2[0]);
                warntimeperiodPojo.setEndtuesday(split2[1]);
            }

            String[] split3 = warntimeperiod.getThursday().split("-");
            if (split3.length >= 2) {

                warntimeperiodPojo.setStartthursday(split3[0]);
                warntimeperiodPojo.setEndthursday(split3[1]);
            }

            String[] split4 = warntimeperiod.getWednesday().split("-");
            if (split4.length >= 2) {

                warntimeperiodPojo.setStartwednesday(split4[0]);
                warntimeperiodPojo.setEndwednesday(split4[1]);
            }

            String[] split5 = warntimeperiod.getFriday().split("-");
            if (split5.length >= 2) {

                warntimeperiodPojo.setStartfriday(split5[0]);
                warntimeperiodPojo.setEndfriday(split5[1]);
            }

            String[] split6 = warntimeperiod.getSaturday().split("-");
            if (split6.length >= 2) {
                warntimeperiodPojo.setStartsaturday(split6[0]);
                warntimeperiodPojo.setEndsaturday(split6[1]);

            }

            String[] split7 = warntimeperiod.getSunday().split("-");
            if (split7.length >= 2) {

                warntimeperiodPojo.setStartsunday(split7[0]);
                warntimeperiodPojo.setEndsunday(split7[1]);
            }

            warntimeperiodPojo.setTimeperiodname(warntimeperiod.getTimeperiodname());
            warntimeperiodPojo.setId(warntimeperiod.getId());

            listpojo.add(warntimeperiodPojo);
        }
        return listpojo;
    }

    @Override
    public List<Warntimeperiod> list() {
        return (List<Warntimeperiod>) manager.list(namespace + "list");
    }
}
