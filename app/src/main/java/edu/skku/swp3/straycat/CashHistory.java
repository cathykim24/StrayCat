package edu.skku.swp3.straycat;

import java.util.Date;

public class CashHistory {
    public String title;
    public int money;
    public Date date;

    public CashHistory(String title, int money, Date date) {
        this.title = title;
        this.money = money;
        this.date = date;
    }

    public CashHistory(String title, int money) {
        this(title, money, new Date());
    }
}
