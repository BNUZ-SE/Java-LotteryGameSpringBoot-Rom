package com.rom.javagame.modules.prize.entity;

public class PrizeEntity implements java.io.Serializable{
    private Long act_id;
    private String prize_name;
    private int prize_level;
    private String prize_desc;
    private Long prize_num;

    public  PrizeEntity() {

    }

    public Long getAct_id() {
        return act_id;
    }

    public void setAct_id(Long act_id) {
        this.act_id = act_id;
    }

    public String getPrize_name() {
        return prize_name;
    }

    public void setPrize_name(String prize_name) {
        this.prize_name = prize_name;
    }

    public int getPrize_level() {
        return prize_level;
    }

    public void setPrize_level(int prize_level) {
        this.prize_level = prize_level;
    }

    public String getPrize_desc() {
        return prize_desc;
    }

    public void setPrize_desc(String prize_desc) {
        this.prize_desc = prize_desc;
    }

    public Long getPrize_num() {
        return prize_num;
    }

    public void setPrize_num(Long prize_num) {
        this.prize_num = prize_num;
    }
}
