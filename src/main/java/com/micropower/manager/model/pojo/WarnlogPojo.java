package com.micropower.manager.model.pojo;

import com.micropower.manager.model.po.Warnlog;
import com.micropower.manager.model.po.Warntype;

/**
 * Created by niushuaike on 2017/9/11.
 */
public class WarnlogPojo {

    private Warnlog warnlog;

    private Warntype warntype;

    public Warnlog getWarnlog() {
        return warnlog;
    }

    public void setWarnlog(Warnlog warnlog) {
        this.warnlog = warnlog;
    }

    public Warntype getWarntype() {
        return warntype;
    }

    public void setWarntype(Warntype warntype) {
        this.warntype = warntype;
    }
}
