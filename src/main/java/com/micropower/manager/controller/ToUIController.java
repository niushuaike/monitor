package com.micropower.manager.controller;

import com.micropower.manager.model.po.Threshold;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by oliver on 2017/9/6.
 */
@Controller
public class ToUIController {

    @RequestMapping("/index")
    public String index() {

        return "index";
    }

    @RequestMapping("/huanj")
    public String huanj() {
        return "huanj";
    }

    @RequestMapping("/jizu")
    public String jizu() {
        return "jizu";
    }

    @RequestMapping("/keySet")
    public String keySet() {
        return "keySet";
    }

    @RequestMapping("/evenR")
    public String evenR() {
        return "evenR";
    }

    @RequestMapping("/evenC")
    public String evenC() {
        return "evenC";
    }

    @RequestMapping("/report")
    public String report() {
        return "report";
    }

    @RequestMapping("/powerSet")
    public String powerSet() {
        return "powerSet";
    }

    @RequestMapping("/huanjing")
    public String huanjing() {
        return "huanjing";
    }

    @RequestMapping("/policeSet")
    public String policeSet() {
        return "policeSet";
    }

    @RequestMapping("/caseSet")
    public String caseSet() {
        return "caseSet";
    }

    @RequestMapping("/setTimt")
    public String setTimt() {
        return "setTimt";
    }

    @RequestMapping("/userSet")
    public String userSet() {
        return "userSet";
    }
}
