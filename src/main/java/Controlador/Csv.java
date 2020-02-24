package Controlador;

import Model.Empleado;
import Model.Empresa;
import Model.Portatil;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Csv {
    public static void exportaEmpleadoCSV(File file, Empresa empresa) throws DadesException {   // solamente este es necesario según la practica pero hemos hecho los 2 ya que estábamos
        String row = "";
        String separador = ",";
        FileWriter fileWriter;

        try {
            fileWriter = new FileWriter(file);

            for (Empleado e : empresa.getEmpleados()) {
                row += e.toStringCSV(separador);
                row += System.getProperty("line.separator");
                fileWriter.write(row);
                row = "";
            }

            fileWriter.flush();
            fileWriter.close();

        } catch (IOException ex) {
            throw new DadesException(ex.toString());
        }
    }

    public static void exportaPortatilCSV(File file, Empresa empresa) throws DadesException {
        String row = "";
        String separador = ",";
        FileWriter fileWriter;

        try {
            fileWriter = new FileWriter(file);

            for (Empleado e : empresa.getEmpleados()) {
                for (Portatil j : e.getPortatils()) {
                    row += j.toStringCSV(separador);
                    row += System.getProperty("line.separator");
                    fileWriter.write(row);
                    row = "";
                }
            }

            fileWriter.flush();
            fileWriter.close();

        } catch (IOException ex) {
            throw new DadesException(ex.toString());
        }
    }
}
