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
        this.id = counter.getAndIncrement();
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
}
