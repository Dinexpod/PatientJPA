package mate.academy.jpddemo.model.model;

import java.util.Date;

public class Aanalis {
    private int cost;
    private String name;
    private Date date;

    public Aanalis() {
    }

    public Aanalis(int cost, String name, Date date) {
        this.cost = cost;
        this.name = name;
        this.date = date;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Aanalis{" +
                "cost=" + cost +
                ", name='" + name + '\'' +
                ", date=" + date +
                '}';
    }
}
