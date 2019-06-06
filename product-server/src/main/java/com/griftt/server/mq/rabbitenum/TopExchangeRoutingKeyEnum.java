package com.griftt.server.mq.rabbitenum;

/**
 * 路由路径的枚举
 */
public enum TopExchangeRoutingKeyEnum {

    ROUTEONE(1,"top.*"),
    ROUTETWO(2,"top.#");

    TopExchangeRoutingKeyEnum(Integer rule, String routeKey) {
        this.rule = rule;
        this.routeKey = routeKey;
    }

    private Integer rule;
    private String routeKey;

    public Integer getRule() {
        return rule;
    }

    public void setRule(Integer rule) {
        this.rule = rule;
    }

    public String getRouteKey() {
        return routeKey;
    }

    public void setRouteKey(String routeKey) {
        this.routeKey = routeKey;
    }

    @Override
    public String toString() {
        return getRouteKey();
    }
}
