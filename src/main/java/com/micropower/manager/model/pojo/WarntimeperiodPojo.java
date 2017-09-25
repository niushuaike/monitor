package com.micropower.manager.model.pojo;

import com.micropower.manager.model.po.Warntimeperiod;

/**
 * Created by niushuaike on 2017/9/15.
 */
public class WarntimeperiodPojo extends Warntimeperiod {

    private String startsunday;

    private String endsunday;

    private String startmonday;

    private String endmonday;

    private String starttuesday;

    private String endtuesday;

    private String startwednesday;

    private String endwednesday;

    private String startthursday;

    private String endthursday;

    private String startfriday;

    private String endfriday;

    private String startsaturday;

    private String endsaturday;

    public String getStartsunday() {
        return startsunday;
    }

    public void setStartsunday(String startsunday) {
        this.startsunday = startsunday;
    }

    public String getEndsunday() {
        return endsunday;
    }

    public void setEndsunday(String endsunday) {
        this.endsunday = endsunday;
    }

    public String getStartmonday() {
        return startmonday;
    }

    public void setStartmonday(String startmonday) {
        this.startmonday = startmonday;
    }

    public String getEndmonday() {
        return endmonday;
    }

    public void setEndmonday(String endmonday) {
        this.endmonday = endmonday;
    }

    public String getStarttuesday() {
        return starttuesday;
    }

    public void setStarttuesday(String starttuesday) {
        this.starttuesday = starttuesday;
    }

    public String getEndtuesday() {
        return endtuesday;
    }

    public void setEndtuesday(String endtuesday) {
        this.endtuesday = endtuesday;
    }

    public String getStartwednesday() {
        return startwednesday;
    }

    public void setStartwednesday(String startwednesday) {
        this.startwednesday = startwednesday;
    }

    public String getEndwednesday() {
        return endwednesday;
    }

    public void setEndwednesday(String endwednesday) {
        this.endwednesday = endwednesday;
    }

    public String getStartthursday() {
        return startthursday;
    }

    public void setStartthursday(String startthursday) {
        this.startthursday = startthursday;
    }

    public String getEndthursday() {
        return endthursday;
    }

    public void setEndthursday(String endthursday) {
        this.endthursday = endthursday;
    }

    public String getStartfriday() {
        return startfriday;
    }

    public void setStartfriday(String startfriday) {
        this.startfriday = startfriday;
    }

    public String getEndfriday() {
        return endfriday;
    }

    public void setEndfriday(String endfriday) {
        this.endfriday = endfriday;
    }

    public String getStartsaturday() {
        return startsaturday;
    }

    public void setStartsaturday(String startsaturday) {
        this.startsaturday = startsaturday;
    }

    public String getEndsaturday() {
        return endsaturday;
    }

    public void setEndsaturday(String endsaturday) {
        this.endsaturday = endsaturday;
    }

    public Warntimeperiod toWarntimeperiod(){
        Warntimeperiod warntimeperiod = new Warntimeperiod();
        warntimeperiod.setId(getId());
        warntimeperiod.setTimeperiodname(getTimeperiodname());
        warntimeperiod.setMonday(startmonday+"-"+endmonday);
        warntimeperiod.setTuesday(starttuesday+"-"+endtuesday);
        warntimeperiod.setWednesday(startwednesday+"-"+endwednesday);
        warntimeperiod.setThursday(startthursday+"-"+endthursday);
        warntimeperiod.setFriday(startfriday+"-"+endfriday);
        warntimeperiod.setSaturday(startsaturday+"-"+endsaturday);
        warntimeperiod.setSunday(startsunday+"-"+endsunday);
        return warntimeperiod;
    }

    public Warntimeperiod toWarntimeperiod( Warntimeperiod warntimeperiod){
        warntimeperiod.setMonday(startmonday+"-"+endmonday);
        warntimeperiod.setTuesday(starttuesday+"-"+endtuesday);
        warntimeperiod.setWednesday(startwednesday+"-"+endwednesday);
        warntimeperiod.setThursday(startthursday+"-"+endthursday);
        warntimeperiod.setFriday(startfriday+"-"+endfriday);
        warntimeperiod.setFriday(startsaturday+"-"+endsaturday);
        warntimeperiod.setSunday(startsunday+"-"+endsunday);
        return warntimeperiod;
    }

}
