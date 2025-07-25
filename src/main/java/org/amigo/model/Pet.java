package org.amigo.model;

import com.mysql.cj.x.protobuf.MysqlxDatatypes;

import java.sql.Date;
import java.time.LocalDate;

public class Pet {
    private int idPet;
    private int idUser;
    private String nombre;
    private int age;
    private String sex;
    private String weight;
    private String size;
    private String photo;
    private int numVisit;
    private String condition;
    private String lastVisit;
    private String state;
    private String treatment;
    private String lastVaccines;
    private String race;

    // Getters y Setters
    public int getIdPet() { return idPet; }
    public void setIdPet(int idPet) { this.idPet = idPet; }

    public int getIdUser() { return idUser; }
    public void setIdUser(int idUser) { this.idUser = idUser; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public String getSex() { return sex; }
    public void setSex(String sex) { this.sex = sex; }

    public String getWeight() { return weight; }
    public void setWeight(String weight) { this.weight = weight; }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getPhoto() { return photo; }
    public void setPhoto(String photo) { this.photo = photo; }

    public int getNumVisit() { return numVisit; }
    public void setNumVisit(int numVisit) { this.numVisit = numVisit; }

    public String getCondition() { return condition; }
    public void setCondition(String condition) { this.condition = condition; }

    public String getLastVisit() {
        return lastVisit;
    }

    public void setLastVisit(String lastVisit) {
        this.lastVisit = lastVisit;
    }

    public String getState() { return state; }
    public void setState(String state) { this.state = state; }

    public String getTreatment() { return treatment; }
    public void setTreatment(String treatment) { this.treatment = treatment; }

    public String getLastVaccines() { return lastVaccines; }
    public void setLastVaccines(String lastVaccines) { this.lastVaccines = lastVaccines; }

    public String getRace() { return race; }
    public void setRace(String race) { this.race = race; }
}
