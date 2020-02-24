package Controlador;
import Model.Empleado;
import java.util.List;

public interface EmpleadoDao {
    public boolean crear(Empleado empleado);
    public List<Empleado> mostrar();
    public boolean actualizar(Empleado empleado);
    public boolean eliminar(String primaryKey);
}




