package com.company;

public class Response {
    String dev;
    String qa;
    String manager;

    public Response() {
    }

    public Response(String dev, String qa, String manager) {
        this.dev = dev;
        this.qa = qa;
        this.manager = manager;
    }

    public String getDev() {
        return dev;
    }

    public void setDev(String dev) {
        this.dev = dev;
    }

    public String getQa() {
        return qa;
    }

    public void setQa(String qa) {
        this.qa = qa;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }
}
