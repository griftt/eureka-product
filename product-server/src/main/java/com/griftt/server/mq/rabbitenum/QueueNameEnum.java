package com.griftt.server.mq.rabbitenum;

public enum QueueNameEnum {
    TOPONE(1,"topic.queueMessageOne"),
    TOPTWO(2,"topic.messageSec.sec"),
    DIRECTONE(3,"queueMessageThi"),
    FANOUTONE(4,"messageFour");

    private Integer code;
    private String msg;

    QueueNameEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public String toString() {
        return getMsg();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
