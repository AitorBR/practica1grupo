import Controlador.EmpleadoDao;
import Controlador.EmpleadoDaoImp;
import Model.Empleado;
import Vista.View;

public class Main {



    public static void main(String[] args) {

        // A empresa
        // B trabajador
        // C portatil

        Empleado empleado = new Empleado("1", "asdasd", "masdasdasd", 15);
        Empleado empleado2 = new Empleado("2", "asdasdasdasd", "masdasdasdasdas", 17);

        EmpleadoDao empleadoDao = new EmpleadoDaoImp();

        empleadoDao.crear(empleado);
        empleadoDao.mostrar();
        empleadoDao.actualizar(empleado2, "1");
        empleadoDao.mostrar();
        empleadoDao.eliminar("1");
        empleadoDao.eliminar("2");
        empleadoDao.mostrar();

        System.out.println("hola");
        System.out.println("Adios");


        new View();

    }


}
