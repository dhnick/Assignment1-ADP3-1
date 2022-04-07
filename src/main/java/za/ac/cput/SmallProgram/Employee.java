/*
 * Author: Smangele Witness Mabaso (220047154)
 * Date: 30 March 2022
 */
package za.ac.cput.SmallProgram;

public class Employee {
    private String EmployeeName;
    private int EmployeeID;
    private String Job;
    private double Salary;

    public Employee(){
        this.EmployeeName=("Smangele");
        this.EmployeeID = 123;
        this.Job= ("Programmer Intern");
        this.Salary= 2500;
    }

    public Employee(String EmployeeName, int EmployeeID, String Job, double Salary){
        this.EmployeeName=EmployeeName;
        this.EmployeeID= EmployeeID;
        this.Job= Job;
        this.Salary=Salary;
    }

    //Getters and Setters
    public String getEmployeeName() {
        return EmployeeName;
    }

    public void setEmployeeName(String employeeName) {
        EmployeeName = employeeName;
    }

    public int getEmployeeID() {
        return EmployeeID;
    }

    public void setEmployeeID(int employeeID) {
        EmployeeID = employeeID;
    }

    public String getJob() {
        return Job;
    }

    public void setJob(String job) {
        Job = job;
    }

    public double getSalary() {
        return Salary;
    }

    public void setSalary(double salary) {
        Salary = salary;
    }

    //Display Output
    public String toString()
    {
        return("Employee Name: " + getEmployeeName()+
                "\nEmployee ID: " + getEmployeeID()+
                "\nJob: " + getJob()+
                "\nSalary: R"+ getSalary());
    }
}

