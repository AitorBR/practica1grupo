package Model;

import java.util.ArrayList;

public class Empleado {

    String dni; //clau
    String nom;
    String mail;
    int edad;
    private ArrayList<Portatil> portatils = new ArrayList<Portatil>();


    public Empleado() {
    }

    public Empleado(String dni, String nom, String mail, int edad) {
        this.dni = dni;
        this.nom = nom;
        this.mail = mail;
        this.edad = edad;
    }


    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public ArrayList<Portatil> getPortatils() {
        return portatils;
    }

    public void setPortatils(ArrayList<Portatil> portatils) {
        this.portatils = portatils;
    }

    public String toStringCSV(String separador) {
        String row = "";

        row += getDni() + separador;
        row += getNom() + separador;
        row += getMail() + separador;
        row += getEdad() + separador;

        return row;
    }

}
