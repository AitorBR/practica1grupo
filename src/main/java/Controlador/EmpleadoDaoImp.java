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
        try {
            ManageBD manageBD = new ManageBD();
            Statement statement = manageBD.getConnection().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String sql = "INSERT INTO Empleado values (NULL,'" + empleado.getDni() + "','" + empleado.getNom() + "','" + empleado.getMail() + "','" + empleado.getEdad() + "')";
            statement.execute(sql);
            registrar = true;
            statement.close();
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

        List<Empleado> listaEmpleado = new ArrayList<Empleado>();

        try {

            ManageBD manageBD = new ManageBD();
            Statement statement = manageBD.getConnection().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

            String sql = "SELECT * FROM Empleado ORDER BY dni";

            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Empleado c = new Empleado();
                c.setDni(resultSet.getString(1));
                c.setNom(resultSet.getString(2));
                c.setMail(resultSet.getString(3));
                c.setEdad(resultSet.getInt(4));
                listaEmpleado.add(c);
            }
            statement.close();
            resultSet.close();
        } catch (SQLException e) {
            System.out.println("Error: Clase EmpleadoDaoImple, método obtener");
            e.printStackTrace();
        } catch (AplicacioException e) {
            e.printStackTrace();
        }

        return listaEmpleado;
    }

    @Override
    public boolean actualizar(Empleado empleado) {

        boolean actualizar = false;

        try {
            ManageBD manageBD = new ManageBD();
            Statement statement = manageBD.getConnection().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

            String sql = "UPDATE Empleado SET dni='" + empleado.getDni() + "', nom='" + empleado.getNom() + "', mail='" + empleado.getMail() + "', edat='" + empleado.getNom() + "'" + " WHERE dni=" + empleado.getDni();

            statement.execute(sql);
            actualizar = true;
        } catch (SQLException e) {
            System.out.println("Error: Clase EmpleadoDaoImple, método actualizar");
            e.printStackTrace();
        } catch (AplicacioException e) {
            e.printStackTrace();
        }
        return actualizar;
    }

    @Override
    public boolean eliminar(Empleado empleado) {
        Connection connect = null;
        Statement statement = null;

        boolean eliminar = false;

        String sql = "DELETE FROM Empleado WHERE dni=" + empleado.getDni();
        try {
            connect = Conexion.conectar();
            statement = connect.createStatement();
            statement.execute(sql);
            eliminar = true;
        } catch (SQLException e) {
            System.out.println("Error: Clase EmpleadoDaoImple, método eliminar");
            e.printStackTrace();
        }
        return eliminar;
    }

}
    

