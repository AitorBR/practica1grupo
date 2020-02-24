package Controlador;


import Model.Empleado;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;




public class EmpleadoDaoImp implements EmpleadoDao {

    @Override
    public boolean registrar(Empleado empleado) {
        boolean registrar = false;

        Statement stm = null;
        ManageBD con = null;

        String sql = "INSERT INTO Empleado values (NULL,'" + empleado.getDni() + "','" + empleado.getNom() + "','" + empleado.getMail() + "','" + empleado.getEdad() + "')";

        try {

           ManageBD manageBD = new ManageBD();

            con = manageBD.getConnection();
            stm = con.createStatement();
            stm.execute(sql);
            registrar = true;
            stm.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Error: Clase EmpleadoDaoImple, método registrar");
            e.printStackTrace();
        } catch (AplicacioException e) {
            e.printStackTrace();
        }
        return registrar;
    }
    

    @Override
    public List<Empleado> obtener() {
        Connection co = null;
        Statement stm = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM Empleado ORDER BY dni";

        List<Empleado> listaEmpleado = new ArrayList<Empleado>();

        try {
            co = Conexion.conectar();
            stm = co.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                Empleado c = new Empleado();
                c.setDni(rs.getString(1));
                c.setNom(rs.getString(2));
                c.setMail(rs.getString(3));
                c.setEdad(rs.getInt(4));
                listaEmpleado.add(c);
            }
            stm.close();
            rs.close();
            co.close();
        } catch (SQLException e) {
            System.out.println("Error: Clase EmpleadoDaoImple, método obtener");
            e.printStackTrace();
        }

        return listaEmpleado;
    }

    @Override
    public boolean actualizar(Empleado empleado) {
        Connection connect = null;
        Statement stm = null;

        boolean actualizar = false;

        String sql = "UPDATE Empleado SET dni='" + empleado.getDni() + "', nom='" + empleado.getNom() + "', mail='" + empleado.getMail() + "', edat='" + empleado.getNom() + "'" + " WHERE dni=" + empleado.getDni();
        try {
            connect = Conexion.conectar();
            stm = connect.createStatement();
            stm.execute(sql);
            actualizar = true;
        } catch (SQLException e) {
            System.out.println("Error: Clase EmpleadoDaoImple, método actualizar");
            e.printStackTrace();
        }
        return actualizar;
    }

    @Override
    public boolean eliminar(Empleado empleado) {
        Connection connect = null;
        Statement stm = null;

        boolean eliminar = false;

        String sql = "DELETE FROM Empleado WHERE dni=" + empleado.getDni();
        try {
            connect = Conexion.conectar();
            stm = connect.createStatement();
            stm.execute(sql);
            eliminar = true;
        } catch (SQLException e) {
            System.out.println("Error: Clase EmpleadoDaoImple, método eliminar");
            e.printStackTrace();
        }
        return eliminar;
    }

}
    

