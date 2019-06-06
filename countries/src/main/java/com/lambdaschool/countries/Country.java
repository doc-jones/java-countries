package com.lambdaschool.countries;

import java.util.concurrent.atomic.AtomicLong;

public class Country {
    private static final AtomicLong counter = new AtomicLong();
    private long id;
    private String cname;
    private int population;
    private int size;
    private int age;

    public Country(String cname, int population, int size, int age) {
        this.id = counter.incrementAndGet();
        this.cname = cname;
        this.population = population;
        this.size = size;
        this.age = age;
    }

    public Country (Country toClone) {
        this.id = toClone.getId();
        this.cname = toClone.getCname();
        this.population = toClone.getPopulation();
        this.size = toClone.getSize();
        this.age = toClone.getAge();
    }

    public long getId() {
        return id;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Country{" +
                "id=" + id +
                ", cname='" + cname + '\'' +
                ", population=" + population +
                ", size=" + size +
                ", age=" + age +
                '}';
    }
}
