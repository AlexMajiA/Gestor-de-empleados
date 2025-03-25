/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package gestorempleados;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

/**
 *
 * @author amjpa
 */

//Esta línea establece el orden de ejecución de los tests
@FixMethodOrder(MethodSorters.NAME_ASCENDING)  

public class EmployeeManagementIT {
    
    public EmployeeManagementIT() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws SQLException {
         // Limpiar empleados para asegurarse que la base de datos está limpia
       // EmployeeManagement instance = new EmployeeManagement();
       // instance.dissmisEmployee(101);  // Intentamos borrar cualquier empleado con el código 101 (si existe)
       //instance.newEmployee(101, "Test", 1, "TEst");
    }
    
    @After
    public void tearDown() throws SQLException {
        EmployeeManagement instance = new EmployeeManagement();
        instance.dissmisEmployee(102);
        //instance.dissmisEmployee(101);
    }

    /**
     * Test of obtenerConexion method, of class EmployeeManagement.
     */
    @Test
    public void testObtenerConexion() {
        System.out.println("obtenerConexion");
        Connection expResult = null;
        Connection result = EmployeeManagement.obtenerConexion();
       
        //Verifico que la conexión no es nula.
        assertNotNull(result);
        try {
            //Compruebo que la conexión es válida, con un retardo de 1 seg.
            assertTrue(result.isValid(1));
        } catch (SQLException ex) {
            fail("Error de conexión: " + ex.getMessage());
        }
    }

    /**
     * Test of newEmployee method, of class EmployeeManagement.
     */
    @Test
    public void testNewEmployee() throws InterruptedException {
        System.out.println("newEmployee");
        
        //Datos del nuevo empleado
        int code = 101;
        String name = "Test";
        double salary = 1.0;
        String department = "Test";
        
        //Creo instancia de EmployeeManagement
        EmployeeManagement instance = new EmployeeManagement();
        
        //Ejecuto el método para agregar empleado
        String expResult = "Empleado contratado y guardado en base de datos.";
        String result = instance.newEmployee(code, name, salary, department);
        
        //Verifico que el método devolvió el mensaje esperado
        assertEquals(expResult, result);
        
        //Thread.sleep(100);
        //Valido que el empleado realmente se guardó en la base de datos
        String searchResult = instance.searchEmployee(String.valueOf(code));
         
        //Thread.sleep(100);
        //El resultado de la búsqueda no debe ser "Empleado no encontrado."
        assertNotEquals("Empleado no encontrado.", searchResult);
        
        //Verifico también que los datos están correctos
        assertTrue(searchResult.contains("Código: " + code));
        assertTrue(searchResult.contains("Nombre: " + name));
        assertTrue(searchResult.contains("Salario: " + salary));
        assertTrue(searchResult.contains("Departamento: " + department));
    }  

    /**
     * Test of dissmisEmployee method, of class EmployeeManagement.
     */
    @Test
    public void testDissmisEmployee() throws Exception {
        System.out.println("dissmisEmployee");
        
        //String updateRow = null;
        //Introduzco código de empleado a borrar
        int code = 101;
        
        //Creo instancia de EmployeeManagement
        EmployeeManagement instance = new EmployeeManagement();
        
        //Verificación antes de eliminar.
        System.out.println("Antes de eliminar: " + instance.searchEmployee(String.valueOf(code)));
        

        
        String expResult = "Fila borrada correctamente: " + 1;
        String result = instance.dissmisEmployee(code);
        
        //Verifico que el método devolvió el mensaje esperado
        assertEquals(expResult, result);
       
    }

    /**
     * Test of list method, of class EmployeeManagement.
     */
    @Test
    public void testList() throws Exception {
       System.out.println("list");
    
    // Instancio la clase EmployeeManagement
    EmployeeManagement instance = new EmployeeManagement();
    
    // Uso el método para crear un nuevo empleado
    String expectedInsertMessage = instance.newEmployee(102, "Test2", 1.0, "Test2");
    
    System.out.println("Flag: " + expectedInsertMessage);
    
    // Verifico que el mensaje de inserción sea correcto
    assertEquals("Empleado contratado y guardado en base de datos.", expectedInsertMessage);
    
    // Obtengo la lista de empleados
    String result = instance.list();
    
    // Imprimir el resultado para depuración
    System.out.println("Flag2: " + result);
    
    
    // Verifico que el resultado contiene los detalles del nuevo empleado
    assertTrue(result.contains("Código: 102"));
    assertTrue(result.contains("Nombre: Test2"));
    assertTrue(result.contains("Salario: 1.0"));
    assertTrue(result.contains("Departamento: Test2"));

    }
    /**
     * Test of orderCode method, of class EmployeeManagement.
     */
    @Test
    public void testOrderCode() throws Exception {
        System.out.println("Test orderCode");
        
        String order = "Invalido";
        
        EmployeeManagement instance = new EmployeeManagement();
        
        String expResult = "Error: Opción de ordenación inválida.";
        String result = instance.orderCode(order);
        
        assertEquals(expResult, result);
        
        String orderCode = "Codigo";
        String expResult2 = "code";
        String expResult3 = "Código";
        
        String result2 = instance.orderCode(orderCode);
        
        //Compruebo que al ordenar contenta la palabra Código.
        assertTrue(result2.contains(expResult3));
        
    }

    /**
     * Test of searchEmployee method, of class EmployeeManagement.
     */
    @Test
    public void testSearchEmployee() {
        System.out.println("searchEmployee");
        String codeConsult = "";
        EmployeeManagement instance = new EmployeeManagement();
        String expResult = "";
        String result = instance.searchEmployee(codeConsult);
        assertEquals(expResult, result);
      
    }

    /**
     * Test of modifyEmployees method, of class EmployeeManagement.
     */
    @Test
    public void testModifyEmployees() {
        System.out.println("modifyEmployees");
        int code = 0;
        String name = "";
        double salary = 0.0;
        String department = "";
        EmployeeManagement instance = new EmployeeManagement();
        String expResult = "";
        String result = instance.modifyEmployees(code, name, salary, department);
        assertEquals(expResult, result);
       
    }
    
}
