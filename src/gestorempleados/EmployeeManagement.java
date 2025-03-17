/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestorempleados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;



/**
 *
 * @author amjpa
 */
public class EmployeeManagement {
    
    private JComboBox<String> comboBox;
   // private javax.swing.JComboBox<String> jComboBox;

    private static final String URL = "jdbc:postgresql://localhost:5432/Employees";
    private static final String USER = "postgres";
    private static final String PASSWORD = "postgre";

    //Método para obtener la conexión.
    public static Connection obtenerConexion() {

        try {
            //Establezco la conexión
            Connection conexion = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexion establecida");
            return conexion;

        } catch (SQLException e) {
            System.out.println("Error de conexión: " + e.getMessage());
            return null;
        }

    }
    //Creación de un ArrayList, para guardar los empleados.
    ArrayList<Employee> employeeList = new ArrayList<>();

    //Método para cerrar la aplicación.
    public void salir() {
        System.exit(0);
    }

    //Método para crear y contratar empleados.
    public String newEmployee(int code, String name, double salary, String department) {
        Employee employee = new Employee();

        Connection conexion = EmployeeManagement.obtenerConexion();

        if (conexion == null) {
            return "La conexión es nula, no se puede insertar empleado.";

        } else {

            try {
                PreparedStatement statement = conexion.prepareStatement(
                        "INSERT INTO Employees (code, name, salary, department) VALUES (?, ?, ?, ?);");

                statement.setInt(1, code);
                statement.setString(2, name);
                statement.setDouble(3, salary);
                statement.setString(4, department);

                int updateRow = statement.executeUpdate();

                if (updateRow > 0) {
                    employee.setCode(code);
                    employee.setName(name);
                    employee.setSalary(salary);
                    employee.setDepartment(department);

                    employeeList.add(employee);

                    return "Empleado contratado y guardado en base de datos.";
                } else {
                    return "El empleado no se ha insertado correctamente.";
                }

            } catch (SQLException ex) {
                System.out.println("Error... " + ex.getMessage());
                return "Error al insertar el empleado: " + ex.getMessage();
            } finally {

                try {
                    if (conexion != null) {
                        conexion.close();
                    }
                } catch (SQLException e) {
                    System.out.println("Error al cerrar la conexión: " + e.getMessage());
                }

            }

        }
    }
    
    //Método para despedir a un empleado, eliminandolo de la BD.
    public String dissmisEmployee(int code) throws SQLException {

        //Creo la conexión.
        Connection conexion = EmployeeManagement.obtenerConexion();

        //Compruebo que la conexión es correcta para continuar.
        if (conexion == null) {
            return "No se ha podido realizar la conexion";
        } else {

            try {
                //Hago la sentencia de borrado.
                PreparedStatement statement = conexion.prepareStatement(
                        "DELETE FROM Employees WHERE code = ?;");

                statement.setInt(1, code);

                //Ejecuto la consulta.
                int updateRow = statement.executeUpdate();

                //Compruebo que se ha completado la sentencia.
                if (updateRow > 0) {
                    return "Fila borrada correctamente: " + updateRow;
                } else {
                    return "No se ha encontrado ninguna fila con ese código: " + code;
                }

            } catch (SQLException ex) {
                System.out.println("Error... " + ex.getMessage());
                return "Error al borrar el empleado: " + ex.getMessage();

                //Hago un finally para asegurarme de cerrar siempre la conexión.
            } finally {
                if (conexion != null) conexion.close();
                
            }

        }

    }

    //Método para listar los empleados existentes.
    public String list() throws SQLException {
        
        //Establezco la conexión.
        Connection conexion = EmployeeManagement.obtenerConexion();
        
        //Verifico que la conexión sea correcta.
        if (conexion == null) {
            return "Conexión erronea";
        }
        
        StringBuilder text = new StringBuilder();
        PreparedStatement statement = null;
        ResultSet res = null;
        
        try {
            //Hago la consulta a la BD.
            statement = conexion.prepareStatement(
                    "SELECT * FROM Employees;");
            
            //Ejecuto la consulta con executeQuery, ya que es la necesaria para consultas con SELECT.
            res = statement.executeQuery();
            
            text = new StringBuilder();
            
            while (res.next()) {
                    //Recorro la base de datos y obtengo sus valores.
                    text.append("Codigo ").append(res.getInt("code")).append(System.lineSeparator());
                    text.append("Nombre: ").append(res.getString("name")).append(System.lineSeparator());
                    text.append("Salario: ").append(res.getDouble("salary")).append(System.lineSeparator());
                    text.append("Departamento: ").append(res.getString("department")).append(System.lineSeparator());
                    text.append("---------------------------------------------------").append(System.lineSeparator());
            }
            
        } catch (SQLException ex) {
             System.out.println("Error... " + ex.getMessage());
             return "Error al listar los empleados: " + ex.getMessage();
        }finally{
            //Cierro las conexiones.
            if (res != null) res.close();
            if (statement != null) statement.close();
            conexion.close();
        }
        //Al utilizar un StringBuilder, debo convertirlo a String para poder hacer el return.
        return text.toString();
    }
    
    
    //Método para ordenar a empleados.
    public String orderCode(String order) throws SQLException {

        //Creo la conexión.
        Connection conexion = EmployeeManagement.obtenerConexion();

        //Valido la conexión antes de seguir.
        if (conexion == null) {
            return "La conexión es invalida.";
        }

        PreparedStatement stament = null;
        ResultSet resultSet = null;
        StringBuilder allResult = new StringBuilder();
        
        //order = comboBox.getSelectedItem().toString();
        //comboBox = new JComboBox<>(new String[]{"Codigo", "Nombre", "Salario", "Departamento"});
        
        

         // Mapeo de valores del ComboBox a las columnas en la base de datos
        String columnToOrderBy;
        switch (order) {
            case "Código":
                columnToOrderBy = "code";
                break;
            case "Nombre":
                columnToOrderBy = "name";
                break;
            case "Salario":
                columnToOrderBy = "salary";
                break;
            case "Departamento":
                columnToOrderBy = "department";
                break;
            default:
                columnToOrderBy = "code"; // Valor por defecto en caso de error
                break;
        }
        
        try {
            //Construyo la consulta en una variable.
            String query = "SELECT * FROM Employees ORDER BY " + columnToOrderBy;
            stament = conexion.prepareStatement(query);

            //Ejecuto la consulta antes del bucle para obtener los resultados.
            resultSet = stament.executeQuery();

            while (resultSet.next()) {
                allResult.append("Código: ").append(resultSet.getInt("code")).append("\n");
                allResult.append("Nombre: ").append(resultSet.getString("name")).append("\n");
                allResult.append("Salario: ").append(resultSet.getDouble("salary")).append("\n");
                allResult.append("Departamento: ").append(resultSet.getString("department")).append("\n");
                allResult.append("---------------------------\n");
            }

        } catch (SQLException ex) {
            System.out.println("Error: No se puede realizar la consulta." + ex.getMessage());
        } finally {
            //Cierro la conexión.
                try {
                     if (resultSet != null)resultSet.close();
                     if (stament != null) stament.close();
                     if (conexion != null) conexion.close();
                } catch (SQLException e) {
                    System.out.println("Error: No se puede finalizar la consulta." + e.getMessage());
                }
           
        }
        return allResult.toString();

    }

}
