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


    public EmpleadoDao getEmpleadoDao() {
        return empleadoDao;
    }

    public void setEmpleadoDao(EmpleadoDao empleadoDao) {
        this.empleadoDao = empleadoDao;
    }

    public EmpresaDao getEmpresaDao() {
        return empresaDao;
    }

    public void setEmpresaDao(EmpresaDao empresaDao) {
        this.empresaDao = empresaDao;
    }

    public PortatilDao getPortatilDao() {
        return portatilDao;
    }

    public void setPortatilDao(PortatilDao portatilDao) {
        this.portatilDao = portatilDao;
    }
}
