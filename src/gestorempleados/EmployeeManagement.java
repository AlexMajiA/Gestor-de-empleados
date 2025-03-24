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
import javax.swing.JComboBox;

/**
 *
 * @author amjpa
 */
public class EmployeeManagement {

    private JComboBox<String> comboBox;

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
       //Instancio un nuevo empleado.
        Employee employee = new Employee();

        //Instancio fuera del Try para poder cerrar la conexión en el finally.
        PreparedStatement statement = null;
        
        //Establezco la conexión.
        Connection conexion = EmployeeManagement.obtenerConexion();

        //Verificación correcta de la conexión.
        if (conexion == null) {
            return "La conexión es nula, no se puede insertar empleado.";

        } else {

            try {
                //Realización de la consulta.
                statement = conexion.prepareStatement(
                        "INSERT INTO Employees (code, name, salary, department) VALUES (?, ?, ?, ?);");

                //Establezco los parametros del placeholder.
                statement.setInt(1, code);
                statement.setString(2, name);
                statement.setDouble(3, salary);
                statement.setString(4, department);

                //Ejecuto la consulta.
                int updateRow = statement.executeUpdate();

                //Verifico que contenga valores positivos.
                if (updateRow > 0) {
                    employee.setCode(code);
                    employee.setName(name);
                    employee.setSalary(salary);
                    employee.setDepartment(department);

                    //Añado los empleados al Array.
                    employeeList.add(employee);
                    return "Empleado contratado y guardado en base de datos.";
                } else {
                    return "El empleado no se ha insertado correctamente.";
                }

                //Capturo las excepciones.
            } catch (SQLException ex) {
                System.out.println("Error... " + ex.getMessage());
                return "Error al insertar el empleado: " + ex.getMessage();
            } finally {
                //Cierro las conexiones.
                try {
                    if (conexion != null) conexion.close();
                    if (statement != null) statement.close();
                    
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

        //Los declaro fuera del Try para poder cerrar en el finally.
        StringBuilder text = new StringBuilder();
        PreparedStatement statement = null;
        ResultSet res = null;

        try {
            //Hago la consulta a la BD.
            statement = conexion.prepareStatement(
                    "SELECT code, name, salary, department FROM Employees;");

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
        } finally {
            //Cierro las conexiones.
            if (res != null) res.close();
            if (statement != null)statement.close();
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
        
        //Los declaro fuera del Try para poder cerrar en el finally.
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        StringBuilder allResult = new StringBuilder();

        //Mapeo de valores del ComboBox a las columnas en la base de datos
        String columnToOrderBy;
        switch (order) {
            case "Codigo":
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
                return "Error: Opción de ordenación inválida.";

        }

        try {
            //Construyo la consulta en una variable.
            String query = "SELECT code, name, salary, department FROM Employees ORDER BY " + columnToOrderBy;
            statement = conexion.prepareStatement(query);

            //Ejecuto la consulta antes del bucle para obtener los resultados.
            resultSet = statement.executeQuery();

            //Verifico si hay empleados.
            boolean hasResult = false;

            while (resultSet.next()) {
                hasResult = true;
                allResult.append("Código: ").append(resultSet.getInt("code")).append("\n");
                allResult.append("Nombre: ").append(resultSet.getString("name")).append("\n");
                allResult.append("Salario: ").append(resultSet.getDouble("salary")).append("\n");
                allResult.append("Departamento: ").append(resultSet.getString("department")).append("\n");
                allResult.append("---------------------------\n");
            }

            //Si no hay resultados, mando un mensaje.
            if (!hasResult) {
                return "No hay empleados en la base de datos.";
            }

        } catch (SQLException ex) {
            System.out.println("Error: No se puede realizar la consulta." + ex.getMessage());
        } finally {
            //Cierro la conexión.
                try {
                     if (resultSet != null)resultSet.close();
                     if (statement != null) statement.close();
                     if (conexion != null) conexion.close();
                } catch (SQLException e) {
                    System.out.println("Error al cerrar los recursos. " + e.getMessage());
                }
           
        }
        return allResult.toString();

    }

    
    //Método para buscar empleados.
    public String searchEmployee(String codeConsult){
        
        //Se inicializa para que no de excepción 
        StringBuilder allResult = new StringBuilder();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        
        //Creo la conexión.
        Connection conexion = EmployeeManagement.obtenerConexion();
        
        //Compruebo la conexión.
        if (conexion == null) {
            return "No se ha podido realizar la conexión.";
        }
        
        //Compruebo que el código no este vacío ni tenga espacios.
        if (codeConsult.isBlank()) {
            return "Error, el código no puede estar vacío ni contener espacios";
        }
        
        try {
            //Hago la consulta
            String query = "SELECT code, name, salary, department FROM Employees WHERE code = ?";
            statement = conexion.prepareStatement(query );
            
            statement.setInt(1, Integer.parseInt(codeConsult));
            
            //Valido que el número sea positivo.
            if (Integer.parseInt(codeConsult) <= 0) {
                return "Error: El código debe ser un número positivo.";
            }
            
            //Ejecutando la consulta.
            resultSet = statement.executeQuery();
            
            //Verifico que si no devuelve nada, el empleado no existe.
            if (!resultSet.next()) {
                return "Empleado no encontrado.";
            }
            
            //Al llamar a resultSet.next(), puedo empezar a consultar directamente con uin Do while.
            do{
                allResult.append("Código: ").append(resultSet.getInt("code")).append("\n");
                allResult.append("Nombre: ").append(resultSet.getString("name")).append("\n");
                allResult.append("Salario: ").append(resultSet.getDouble("salary")).append("\n");
                allResult.append("Departamento: ").append(resultSet.getString("department")).append("\n");
                allResult.append("---------------------------\n");
            
             //Recorro la base de datos para obtener los valores.
            }  while (resultSet.next());

         
         } catch (NumberFormatException ex) {
            return "Error: solo se permiten números positivos.";
             
        } catch (SQLException ex) {
            return "Error: Código de empleado no encontrado.";
            
        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (conexion != null) conexion.close();
                
            } catch (SQLException ex) {
                System.out.println("Error al cerrar los recursos. " + ex.getMessage());
            }
        }
        return allResult.toString();
    }
    
    //Metodo para modificar empleados.
    public String modifyEmployees (int code, String name, double salary, String department){
        
       //Creo la conexión.
       Connection conexion = EmployeeManagement.obtenerConexion();
       
        //Verifico que la conexión es correcta.
        if (conexion == null) {
            return "Error en la conexión.";
        }
        
        
        PreparedStatement statement = null;
        String query = "UPDATE Employees SET name = ?, salary = ?, department = ? WHERE code = ?";
        
        
        try {
            
        //Hago la consulta.    
        statement = conexion.prepareStatement(query);
        
        statement.setString(1, name);
        statement.setDouble(2, salary);
        statement.setString(3, department);
        statement.setInt(4, code);
        
        //executeUpdate devuelve un número de filas afectadas, por lo que lo guardo en variable 
        //y lo uso para ver cuantas filas se han visto afectadas.
        int updateRows = statement.executeUpdate();
            
            if (updateRows == 0) {
                return "No se ha actualizado ninguna fila";
            }else {
                return "Filas actualizadas: " + updateRows + ". Proceso correcto.";
            }
            
             
        } catch (SQLException e) {
         return "Error durante la consulta: " + e.getMessage();
         
        } finally {
            try {
            if (statement != null) statement.close();
            if (conexion != null) conexion.close();
           
            } catch (SQLException ex) {
                System.out.println("Error al cerrar los recursos. " + ex.getMessage());
            }
            
        }
    }
    
}
