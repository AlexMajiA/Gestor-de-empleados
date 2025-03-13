/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestorempleados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.postgresql.PGProperty;

/**
 *
 * @author amjpa
 */
public class EmployeeManagement {
    
    private static final String URL = "jdbc:postgresql://localhost:5432/Employees";
    private static final String USER = "postgres";
    private static final String PASSWORD = "postgre";
    
    public static Connection obtenerConexion (){
        
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
    public void salir(){
        System.exit(0);
    }
    
    

    //Método para crear y contratar empleados.
    public String crearEmpleado(int code, String name, double salary, String department) {
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


    //Método para listar los empleados existentes.
    public String list() {
        StringBuilder text = new StringBuilder();
        for (int i = 0; i < employeeList.size(); i++) {
            text.append("Codigo ").append(employeeList.get(i).getCode()).append(System.lineSeparator());
            text.append("Nombre: ").append(employeeList.get(i).getName()).append(System.lineSeparator());
            text.append("Salario: ").append(employeeList.get(i).getSalary()).append(System.lineSeparator());
            text.append("Departamento: ").append(employeeList.get(i).getDepartment()).append(System.lineSeparator());
            text.append("---------------------------------------------------").append(System.lineSeparator());
        }
        
        //Al utilizar un StringBuilder, debo convertirlo a String para poder hacer el return.
        return text.toString();  
    }

    //Método para insertar a empleados.
    public void insertar() {

    }

}
