package Controlador;

import Model.Portatil;

import java.util.List;

public interface PortatilDao {
    public boolean crear(Portatil portatil);
    public List<Portatil> mostrar();
    public boolean actualizar(Portatil portatil, String primaryKey);
    public boolean eliminar(String primaryKey);
}
