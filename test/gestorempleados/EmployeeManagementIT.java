/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package gestorempleados;

import java.sql.Connection;
import java.sql.SQLException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author amjpa
 */
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
    public void setUp() {
    }
    
    @After
    public void tearDown() {
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
     * Test of salir method, of class EmployeeManagement.
     */
    @Test
    public void testSalir() {
        System.out.println("salir");
        EmployeeManagement instance = new EmployeeManagement();
        instance.salir();
       
    }

    /**
     * Test of newEmployee method, of class EmployeeManagement.
     */
    @Test
    public void testNewEmployee() {
        System.out.println("newEmployee");
        int code = 0;
        String name = "";
        double salary = 0.0;
        String department = "";
        EmployeeManagement instance = new EmployeeManagement();
        String expResult = "";
        String result = instance.newEmployee(code, name, salary, department);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of dissmisEmployee method, of class EmployeeManagement.
     */
    @Test
    public void testDissmisEmployee() throws Exception {
        System.out.println("dissmisEmployee");
        int code = 0;
        EmployeeManagement instance = new EmployeeManagement();
        String expResult = "";
        String result = instance.dissmisEmployee(code);
        assertEquals(expResult, result);
       
    }

    /**
     * Test of list method, of class EmployeeManagement.
     */
    @Test
    public void testList() throws Exception {
        System.out.println("list");
        EmployeeManagement instance = new EmployeeManagement();
        String expResult = "";
        String result = instance.list();
        assertEquals(expResult, result);
      
    }

    /**
     * Test of orderCode method, of class EmployeeManagement.
     */
    @Test
    public void testOrderCode() throws Exception {
        System.out.println("orderCode");
        String order = "";
        EmployeeManagement instance = new EmployeeManagement();
        String expResult = "";
        String result = instance.orderCode(order);
        assertEquals(expResult, result);
       
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
