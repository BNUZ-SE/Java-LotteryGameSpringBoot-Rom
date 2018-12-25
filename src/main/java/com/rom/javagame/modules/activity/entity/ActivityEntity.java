package com.rom.javagame.modules.activity.entity;

import java.util.Date;
import java.util.List;

public class ActivityEntity implements java.io.Serializable {
    private int id;
    private String act_name;
    private String act_desc;
    private long act_person_num;
    private Date start_time;
    private Date end_time;
    private Date create_time;

    public ActivityEntity() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAct_desc() {
        return act_desc;
    }

    public void setAct_desc(String act_desc) {
        this.act_desc = act_desc;
    }

    public long getAct_person_num() {
        return act_person_num;
    }

    public void setAct_person_num(long act_person_num) {
        this.act_person_num = act_person_num;
    }

    public String getAct_name() {
        return act_name;
    }

    public void setAct_name(String act_name) {
        this.act_name = act_name;
    }

    public Date getStart_time() {
        return start_time;
    }

    public void setStart_time(Date start_time) {
        this.start_time = start_time;
    }

    public Date getEnd_time() {
        return end_time;
    }

    public void setEnd_time(Date end_time) {
        this.end_time = end_time;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }
}
