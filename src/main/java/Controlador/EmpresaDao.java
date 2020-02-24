package Controlador;

import Model.Empresa;

import java.util.List;

public interface EmpresaDao {
    public boolean crear(Empresa empresa);
    public List<Empresa> mostrar();
    public boolean actualizar(Empresa empresa, String primarykey);
    public boolean eliminar(String primaryKey);
}
