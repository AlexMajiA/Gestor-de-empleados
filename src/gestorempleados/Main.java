/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package gestorempleados;

import java.sql.Connection;
//import gestorempleados.db.ConexionPostgres;
/**
 *
 * @author amjpa
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //Prueba de conexión con Postgre
        Connection conexion = EmployeeManagement.obtenerConexiConnection();
        if (conexion != null) {
            System.out.println("Conexion establecida correctamente.");
        } else {
            System.out.println("No se pudo conectar a la base de datos Postgre.");
        }
    }
    
}
