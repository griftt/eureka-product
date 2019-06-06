package com.griftt.server.mq.rabbitenum;

/**
 * 交换机名字枚举
 */
public enum ExchangeNameEnum {
     TOPIC(1,"topicExchange"),
     HEADER(2,"headerExchange"),
     FANOUT(3,"fanoutExchange"),
     ;

    private Integer code;
    private String exchangeName;

    ExchangeNameEnum(Integer code, String exchangeName) {
        this.code = code;
        this.exchangeName = exchangeName;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getExchangeName() {
        return exchangeName;
    }

    public void setExchangeName(String exchangeName) {
        this.exchangeName = exchangeName;
    }

    @Override
    public String toString() {
        return getExchangeName();
    }
}
