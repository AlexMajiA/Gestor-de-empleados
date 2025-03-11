/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestorempleados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author amjpa
 */
public class EmployeeManagement {
    
    private static final String URL = "jdbc:postgresql:localhost:5432/employees";
    private static final String USER = "postgres";
    private static final String PASSWORD = "";
    
    public static Connection obtenerConexiConnection (){
        
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
    
    //final private String archivo = "empleados.dat";
    
 /*    public EmployeeManagement() throws FileNotFoundException{
        try {
        
       File employees = new File(archivo);
            
        //Verifico si el archivo no existe y lo creo en caso necesario
        if (!employees.exists()) {
            try {
                employees.createNewFile();
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
        
        //Abro un flujo de entrada para leer el archivo
        FileInputStream inputStream = new FileInputStream(archivo);
        DataInputStream dis = new DataInputStream(inputStream);
      
        // Crea un objeto auxiliar para almacenar los datos de un producto
        Employee employeeAux = new Employee();
        
        
            // Lee el primer código de producto del archivo
            while (dis.available() > 0) {                
                employeeAux.setCode(dis.readInt());
            }
            
            
            //Cierro el flujo
            dis.close();
            
        } catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
        }  
        
      return; 
    }
  */   
    //Método para cerrar la aplicación.
    public void salir(){
        System.exit(0);
    }
    
    

    //Método para crear empleados.
    public String crearEmpleado(int code, String name, double salary, String department) {
        Employee employee = new Employee();

        if (!name.isEmpty() && !department.isEmpty()) {
            employee.setCode(code);
            employee.setName(name);
            employee.setSalary(salary);
            employee.setDepartment(department);

            employeeList.add(employee);
        }
        return employee.toString();
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
