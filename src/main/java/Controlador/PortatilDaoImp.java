package Controlador;

import Model.Portatil;
import Vista.View;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PortatilDaoImp implements PortatilDao {
    View view = new View();

    // lo hemos hecho así porque luego dependiendo del catch podemos mostrar cosas diferentes, es decir,
    // podemos añadir texto al final indicando de que es el error, también podría haber generado una default
    // para todos y solo cambiar el centro (es decir crear, mostrar, actualizar, eliminar)

    final String errorCreate = "Error al crear al portatil";
    final String errorRead = "Error al mostrar al portatil";
    final String errorUpdate = "Error al actualizar al portatil";
    final String errorDelete = "Error al eliminar al portatil";


    @Override
    public boolean crear(Portatil portatil) {
        boolean registrar = false;
        try {
            ManageBD manageBD = new ManageBD();
            Statement statement = manageBD.getConnection().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String sql = "INSERT INTO Portatil values ('" + portatil.getNumSerie() + "','" + portatil.getFabricante() + "','" + portatil.getNom() + "','" + portatil.getPulgadas() + "')";
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
    public List<Portatil> mostrar() {

        List<Portatil> listaPortatil = new ArrayList<Portatil>();

        try {
            ManageBD manageBD = new ManageBD();
            Statement statement = manageBD.getConnection().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

            String sql = "SELECT * FROM Portatil ORDER BY nom";

            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Portatil c = new Portatil();
                c.setNumSerie(resultSet.getString(1));
                c.setFabricante(resultSet.getString(2));
                c.setNom(resultSet.getString(3));
                c.setPulgadas(resultSet.getInt(4));
                listaPortatil.add(c);
            }
            statement.close();
            resultSet.close();
        } catch (SQLIntegrityConstraintViolationException e) {
            view.messageErrorDefault("El portatil ya existe");
            e.printStackTrace();
        } catch (SQLException e) {
            view.messageErrorDefault(errorRead + " a causa de la base de datos");
            e.printStackTrace();
        } catch (AplicacioException e) {
            view.messageErrorDefault(errorRead + " a causa de los datos");
            e.printStackTrace();
        }

        return listaPortatil;
    }

    @Override
    public boolean actualizar(Portatil portatil, String primaryKey) {

        boolean actualizar = false;

        try {
            ManageBD manageBD = new ManageBD();
            Statement statement = manageBD.getConnection().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

            String sql = "UPDATE Portatil SET dni='" + portatil.getDni() + "', nom='" + portatil.getNom() + "', mail='" + portatil.getMail() + "', edad='" + portatil.getNom() + "'" + " WHERE dni='" + primaryKey + "'";

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

            String sql = "DELETE FROM Portatil WHERE dni='" + primaryKey + "'";     // portatil.getDni() por dni

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


