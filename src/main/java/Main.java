import Controlador.*;
import Model.Empleado;
import Model.Empresa;
import Model.Portatil;
import Vista.View;

public class Main {



    public static void main(String[] args) {

        // A empresa
        // B trabajador
        // C portatil

        Empresa empresa = new Empresa("1", "1", 154, "15");
        Empresa empresa2 = new Empresa("1", "1", 154, "15");

        Empleado empleado = new Empleado("1", "asdasd", "masdasdasd", 15);
        Empleado empleado2 = new Empleado("1", "asdasdasdasd", "masdasdasdasdas", 17);

        Portatil portatil = new Portatil("1", "asdasd", "1", 15);
        Portatil portatil2 = new Portatil("1", "asdasd", "1", 15);

        EmpresaDao empresaDao = new EmpresaDaoImp();
        EmpleadoDao empleadoDao = new EmpleadoDaoImp();
        PortatilDao portatilDao = new PortatilDaoImp();

        empresaDao.crear(empresa);
        empresaDao.mostrar();
        empresaDao.actualizar(empresa2, "1");
        empresaDao.mostrar();
        empresaDao.eliminar("1");
        empresaDao.eliminar("1");
        empresaDao.mostrar();

        empleadoDao.crear(empleado);
        empleadoDao.mostrar();
        empleadoDao.actualizar(empleado2, "1");
        empleadoDao.mostrar();
        empleadoDao.eliminar("1");
        empleadoDao.eliminar("1");
        empleadoDao.mostrar();

        portatilDao.crear(portatil);
        portatilDao.mostrar();
        portatilDao.actualizar(portatil2, "1");
        portatilDao.mostrar();
        portatilDao.eliminar("1");
        portatilDao.eliminar("1");
        portatilDao.mostrar();


        System.out.println("hola");
        System.out.println("Adios");


        new View();

    }


}
