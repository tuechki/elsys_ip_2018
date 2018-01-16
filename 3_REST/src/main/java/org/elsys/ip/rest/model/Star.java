package org.elsys.ip.rest.model;

import sun.invoke.empty.Empty;

public class Star {

    private int id;
    private String name;
    private long mass;
    private String evolutionaryStage;
    private long volume;
    private int escapeVelocity;
    private long age;
    private long distanceFromEarth;
    private String spectralType;
    private long temperature;
    private long equatorialRadius;

    public Star(int id, String name, long mass, String evolutionaryStage, long volume, int escapeVelocity,
                long age, long distanceFromEarth, String spectralType, long temperature, long equatorialRadius){
        this.id = id;
        this.name = name;
        this.mass = mass;
        this.evolutionaryStage = evolutionaryStage;
        this.volume = volume;
        this.escapeVelocity = escapeVelocity;
        this.age = age;
        this.distanceFromEarth = distanceFromEarth;
        this.spectralType = spectralType;
        this.temperature = temperature;
        this.equatorialRadius = equatorialRadius;


    }

    public Star(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getMass() {
        return mass;
    }

    public void setMass(long mass) {
        this.mass = mass;
    }

    public String getEvolutionaryStage() {
        return evolutionaryStage;
    }

    public void setEvolutionaryStage(String evolutionaryStage) {
        this.evolutionaryStage = evolutionaryStage;
    }

    public long getVolume() {
        return volume;
    }

    public void setVolume(long volume) {
        this.volume = volume;
    }

    public int getEscapeVelocity() {
        return escapeVelocity;
    }

    public void setEscapeVelocity(int escapeVelocity) {
        this.escapeVelocity = escapeVelocity;
    }

    public long getAge() {
        return age;
    }

    public void setAge(long age) {
        this.age = age;
    }

    public long getDistanceFromEarth() {
        return distanceFromEarth;
    }

    public void setDistanceFromEarth(long distanceFromEarth) {
        this.distanceFromEarth = distanceFromEarth;
    }

    public String getSpectralType() {
        return spectralType;
    }

    public void setSpectralType(String spectralType) {
        this.spectralType = spectralType;
    }

    public long getTemperature() {
        return temperature;
    }

    public void setTemperature(long temperature) {
        this.temperature = temperature;
    }

    public long getEquatorialRadius() {
        return equatorialRadius;
    }

    public void setEquatorialRadius(long equatorialRadius) {
        this.equatorialRadius = equatorialRadius;
    }

    public String toString(){

        return  getId() + "," +
                getName() + "," +
                getMass() + "," +
                getEvolutionaryStage() + "," +
                getVolume() + "," +
                getEscapeVelocity() + "," +
                getAge()  + ","  +
                getDistanceFromEarth() + "," +
                getSpectralType() + "," +
                getTemperature() + "," +
                getEquatorialRadius();


    }
}
