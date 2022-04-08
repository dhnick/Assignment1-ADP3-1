package za.ac.cput.SmallProgramTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.SmallProgram.Employee;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {
    public static void main(String[] args){
        Employee employee = new Employee("Smangele", 123, "Programmer Intern", 2500) ;
        System.out.println(employee.toString());

    }
        private Employee salary1;
        private Employee salary2;
        private Employee salary3;

        @BeforeEach
        void setUp() {
            //this.employee =  new employee;
            salary1 = new Employee();
            salary2 = new Employee();
            salary1 = salary3;

        }

        @Test
        public void testEquality() {
            assertEquals(salary1, salary3);

        }
        @Test
        public void testIdentity(){
            assertSame(salary1, salary3);
        }

        @Test
        //Failing Test
        public void Failing() {
            int num1 = 5;
        }


        @org.junit.jupiter.api.Test
        void getSalary() {
        }

        @org.junit.jupiter.api.Test
        void setSalary() {
        }

    }
