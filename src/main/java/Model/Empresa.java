package Model;

import java.util.ArrayList;

public class Empresa {

    String nombre;
    String nif; // clau
    int tel;
    String mail;
    private ArrayList<Empleado> empleados = new ArrayList<Empleado>();

    public Empresa() {
    }

    public Empresa(String nombre, String nif, int tel, String mail) {
        this.nombre = nombre;
        this.nif = nif;
        this.tel = tel;
        this.mail = mail;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public ArrayList<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(ArrayList<Empleado> empleados) {
        this.empleados = empleados;
    }
}
