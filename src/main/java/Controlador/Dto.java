package Controlador;

public class Dto {

    EmpleadoDao empleadoDao;
    EmpresaDao empresaDao;
    PortatilDao portatilDao;

    public Dto() {
        this.empleadoDao = new EmpleadoDaoImp();
        this.empresaDao = new EmpresaDaoImp();
        this.portatilDao = new PortatilDaoImp();
    }






}
