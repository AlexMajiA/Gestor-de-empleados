/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestorempleados;

/**
 *
 * @author amjpa
 */
public class Employee {
    
    //Atributos de la clase.
    private int code;
    private String name;
    private double salary;
    private String department;
        
    
    //Constructores.
    public Employee() {
    }

    public Employee(int code, String name, double salary, String department) {
        this.code = code;
        this.name = name;
        this.salary = salary;
        this.department = department;
    }

    
    //Getter y setter.
    public int getCode(){
        return code;
    }
    
    public void setCode(int code){
        this.code = code;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
    
}
