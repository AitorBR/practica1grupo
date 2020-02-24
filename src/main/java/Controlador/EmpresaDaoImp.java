package Controlador;

import Model.Empresa;
import Vista.View;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmpresaDaoImp implements EmpresaDao {
    View view = new View();

    // lo hemos hecho así porque luego dependiendo del catch podemos mostrar cosas diferentes, es decir,
    // podemos añadir texto al final indicando de que es el error, también podría haber generado una default
    // para todos y solo cambiar el centro (es decir crear, mostrar, actualizar, eliminar)

    final String errorCreate = "Error al crear al empresa";
    final String errorRead = "Error al mostrar al empresa";
    final String errorUpdate = "Error al actualizar al empresa";
    final String errorDelete = "Error al eliminar al empresa";


    @Override
    public boolean crear(Empresa empresa) {
        boolean registrar = false;
        try {
            ManageBD manageBD = new ManageBD();
            Statement statement = manageBD.getConnection().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String sql = "INSERT INTO Empresa values ('" + empresa.getNombre() + "','" + empresa.getNif() + "','" + empresa.getTel() + "','" + empresa.getMail() + "')";
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
    public List<Empresa> mostrar() {

        List<Empresa> listaEmpresa = new ArrayList<Empresa>();

        try {
            ManageBD manageBD = new ManageBD();
            Statement statement = manageBD.getConnection().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

            String sql = "SELECT * FROM Empresa ORDER BY nif";

            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Empresa c = new Empresa();
                c.setNombre(resultSet.getString(1));
                c.setNif(resultSet.getString(2));
                c.setTel(resultSet.getInt(3));
                c.setMail(resultSet.getString(4));
                listaEmpresa.add(c);
            }
            statement.close();
            resultSet.close();
        } catch (SQLIntegrityConstraintViolationException e) {
            view.messageErrorDefault("El empresa ya existe");
            e.printStackTrace();
        } catch (SQLException e) {
            view.messageErrorDefault(errorRead + " a causa de la base de datos");
            e.printStackTrace();
        } catch (AplicacioException e) {
            view.messageErrorDefault(errorRead + " a causa de los datos");
            e.printStackTrace();
        }

        return listaEmpresa;
    }

    @Override
    public boolean actualizar(Empresa empresa, String primaryKey) {

        boolean actualizar = false;

        try {
            ManageBD manageBD = new ManageBD();
            Statement statement = manageBD.getConnection().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

            String sql = "UPDATE Empresa SET nombre='" + empresa.getNombre() + "', nif='" + empresa.getNif() + "', tel='" + empresa.getTel() + "', mail='" + empresa.getMail() + "'" + " WHERE nif='" + primaryKey + "'";

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
    public boolean eliminar(String primaryKey) {

        boolean eliminar = false;

        try {
            ManageBD manageBD = new ManageBD();
            Statement statement = manageBD.getConnection().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

            String sql = "DELETE FROM Empresa WHERE nom='" + primaryKey + "'";

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



