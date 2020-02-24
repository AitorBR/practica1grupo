import Controlador.EmpleadoDao;
import Controlador.EmpleadoDaoImp;
import Model.Empleado;

public class Main {



    public static void main(String[] args) {

        // A empresa
        // B trabajador
        // C portatil

        Empleado empleado = new Empleado("sadasdasd", "asdasd", "masdasdasd", 15);
        Empleado empleado2 = new Empleado("sadasdasdasdas", "asdasdasdasd", "masdasdasdasdas", 17);

        EmpleadoDao empleadoDao = new EmpleadoDaoImp();

        empleadoDao.crear(empleado);
        empleadoDao.mostrar();
        empleadoDao.actualizar(empleado2);
        empleadoDao.mostrar();
        empleadoDao.eliminar(empleado2);
        empleadoDao.eliminar(empleado);
        empleadoDao.mostrar();

        System.out.println("hola");
        System.out.println("Adios");
    }


}
