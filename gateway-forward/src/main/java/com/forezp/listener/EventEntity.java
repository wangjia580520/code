package com.forezp.listener;

import org.springframework.context.ApplicationEvent;

/***
 * 定义事件实体类 注意构造器
 */
public class EventEntity extends ApplicationEvent {
    private String id;
    public EventEntity(Object source,String id) {
        super(source);
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
