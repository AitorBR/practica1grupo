package Controlador;


import Model.Empleado;
import Vista.View;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class EmpleadoDaoImp implements EmpleadoDao {

    View view = new View();

    // lo hemos hecho así porque luego dependiendo del catch podemos mostrar cosas diferentes, es decir,
    // podemos añadir texto al final indicando de que es el error, también podría haber generado una default
    // para todos y solo cambiar el centro (es decir crear, mostrar, actualizar, eliminar)

    final String errorCreate = "Error al crear al empleado";
    final String errorRead = "Error al mostrar al empleado";
    final String errorUpdate = "Error al actualizar al empleado";
    final String errorDelete = "Error al eliminar al empleado";


    @Override
    public boolean crear(Empleado empleado) {
        boolean registrar = false;
        try {
            ManageBD manageBD = new ManageBD();
            Statement statement = manageBD.getConnection().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String sql = "INSERT INTO Empleado values ('" + empleado.getDni() + "','" + empleado.getNom() + "','" + empleado.getMail() + "','" + empleado.getEdad() + "')";
            statement.execute(sql);
            registrar = true;
            statement.close();
        } catch (SQLException e) {
            view.messageErrorDefault(errorCreate + " a causa de la base de datos");
            e.printStackTrace();
        } catch (AplicacioException e) {
            view.messageErrorDefault(errorCreate + " a causa de los datos");
            e.printStackTrace();
        }
        return registrar;
    }


    @Override
    public List<Empleado> mostrar() {

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
        } catch (SQLIntegrityConstraintViolationException e) {
            view.messageErrorDefault("El usuario ya existe");
            e.printStackTrace();
        } catch (SQLException e) {
            view.messageErrorDefault(errorRead + " a causa de la base de datos");
            e.printStackTrace();
        } catch (AplicacioException e) {
            view.messageErrorDefault(errorRead + " a causa de los datos");
            e.printStackTrace();
        }

        return listaEmpleado;
    }

    @Override
    public boolean actualizar(Empleado empleado, String primarykey) {

        boolean actualizar = false;

        try {
            ManageBD manageBD = new ManageBD();
            Statement statement = manageBD.getConnection().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

            String sql = "UPDATE Empleado SET dni='" + empleado.getDni() + "', nom='" + empleado.getNom() + "', mail='" + empleado.getMail() + "', edad='" + empleado.getNom() + "'" + " WHERE dni='" + primarykey + "'";

            statement.execute(sql);
            actualizar = true;
        } catch (SQLException e) {
            view.messageErrorDefault(errorUpdate + " a causa de la base de datos");
            e.printStackTrace();
        } catch (AplicacioException e) {
            view.messageErrorDefault(errorUpdate + " a causa de los datos");
            e.printStackTrace();
        }
        return actualizar;
    }

    @Override
    public boolean eliminar(String primaryKey) {        // mandar solo dni  String dni

        boolean eliminar = false;

        try {
            ManageBD manageBD = new ManageBD();
            Statement statement = manageBD.getConnection().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

            String sql = "DELETE FROM Empleado WHERE dni='" + primaryKey + "'";     // empleado.getDni() por dni

            statement.execute(sql);
            eliminar = true;
        } catch (SQLException e) {
            view.messageErrorDefault(errorDelete + " a causa de la base de datos");
            e.printStackTrace();
        } catch (AplicacioException e) {
            view.messageErrorDefault(errorDelete + " a causa de los datos");
            e.printStackTrace();
        }
        return eliminar;
    }

}
    

