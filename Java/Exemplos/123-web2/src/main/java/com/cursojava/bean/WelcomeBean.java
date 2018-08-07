package com.cursojava.bean;

import javax.faces.bean.ManagedBean;

@ManagedBean(name = "welcome", eager = true)
public class WelcomeBean {

    public String getMessage() {
        return "I'm alive";
    }
}
