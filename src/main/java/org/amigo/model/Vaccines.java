package org.amigo.model;


public class Vaccines {
    private int IdPet;


    public Vaccines() {
        // constructor vacío
    }

    public Vaccines(int idPet) {
        this.IdPet = idPet;
    }
    public int getIdPet() { return IdPet; }
    public void setIdPet(int idPet) { this.IdPet = idPet; }
}