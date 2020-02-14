public class Empleado {

    String dni; //clau
    String nom;
    String mail;
    int edad;

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
}
