package Model;

public class Portatil {

    String numSerie;
    String fabricante;
    String nom; // modelo
    float pulgadas;

    public Portatil() {
    }

    public Portatil(String numSerie, String fabricante, String nom, float pulgadas) {
        this.numSerie = numSerie;
        this.fabricante = fabricante;
        this.nom = nom;
        this.pulgadas = pulgadas;
    }

    public String getNumSerie() {
        return numSerie;
    }

    public void setNumSerie(String numSerie) {
        this.numSerie = numSerie;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public float getPulgadas() {
        return pulgadas;
    }

    public void setPulgadas(float pulgadas) {
        this.pulgadas = pulgadas;
    }

    public String toStringCSV(String separador){
        String row = "";

        row += this.getNumSerie() + separador;
        row += this.getFabricante() + separador;
        row += this.getNom() + separador;
        row += this.getPulgadas() + separador;

        return row;
    }

}
