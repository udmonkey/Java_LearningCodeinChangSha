package com.itheima.pojo;

public class Card {
    private Integer id;
    private Integer number;
    private Person p;

    public Card() {
    }

    @Override
    public String toString() {
        return "Card{" +
                "id=" + id +
                ", number=" + number +
                ", p=" + p +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Person getP() {
        return p;
    }

    public void setP(Person p) {
        this.p = p;
    }

    public Card(Integer id, Integer number, Person p) {
        this.id = id;
        this.number = number;
        this.p = p;
    }
}
