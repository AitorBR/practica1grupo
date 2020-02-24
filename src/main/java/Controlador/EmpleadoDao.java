package Controlador;
import Model.Empleado;
import java.util.List;

public interface EmpleadoDao {
    public boolean registrar(Empleado empleado);
    public List<Empleado> obtener();
    public boolean actualizar(Empleado empleado);
    public boolean eliminar(Empleado empleado);
}




