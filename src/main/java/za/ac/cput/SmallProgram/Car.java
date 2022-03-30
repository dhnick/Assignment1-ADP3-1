package za.ac.cput.SmallProgram;

/* Car.java
 * Car small program
 * Author: Smangele Witness Mabaso (220047154)
 * Date: 30 March 2022
 */

public class Car {
    private String make;
    private int yearModel;
    private double price;

    public Car(){

    }
    public Car( String make, int yearModel, double price){
        this.make = make;
        this.yearModel = yearModel;
        this.price = price;
    }
    public String getMake(){
        return make;
    }
    public int getYearModel(){
        return yearModel;
    }
    public double getPrice(){
        return price;
    }

    public void setMake(String make){
        this.make = make;
    }
    public void setYearModel(int yearModel){
        this.yearModel = yearModel;
    }
    public void setPrice( double price){
        this.price = price;
    }

    @Override
    public String toString() {
        return "make : " + make + " ,YearModel : " + yearModel + " , Price : " + price;
    }

    public void show(){
        System.out.println("=== Car details =====");
        System.out.println(" ");
        System.out.println("make "+ make);
        System.out.println("yearModel "+ yearModel);
        System.out.println("price "+ price );
    }
}

