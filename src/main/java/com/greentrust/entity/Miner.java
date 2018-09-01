package com.greentrust.entity;


import com.google.gson.Gson;

public class Miner {

    private Integer id ;
    private String name ;
    private MinerType type ;
    private float price ;
    private Integer stock ;

    public static Miner fromJSON(String jsonStr){
        Gson gson = new Gson();
        Miner miner = gson.fromJson(jsonStr,Miner.class);
        return miner;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", price=" + price +
                ", stock=" + stock +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MinerType getType() {
        return type;
    }

    public void setType(MinerType type) {
        this.type = type;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Miner() {
    }

    public Miner(Integer id, String name, MinerType type, float price, Integer stock) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.price = price;
        this.stock = stock;
    }
}
