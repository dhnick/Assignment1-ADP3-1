package za.ac.cput.SmallProgram;
/*
    ArraySearching.java
    Small program that searches through arrays
    Author: Jody Heideman (219307725)
    Date: 27/03/2022
 */
public class ArraySearching {

    private int findMax;
    private int findMin;
    private int findSum;



    public int getFindMax() {
        return findMax;
    }

    public void setFindMax(int findMax) {
        this.findMax = findMax;
    }

    public int getFindMin() {
        return findMin;
    }

    public void setFindMin(int findMin) {
        this.findMin = findMin;
    }

    public int getFindSum() {
        return findSum;
    }

    public void setFindSum(int findSum) {
        this.findSum = findSum;
    }



    @Override
    public String toString() {
        return "arraySearch{" +
                "findMax=" + findMax +
                ", findMin=" + findMin +
                ", findSum=" + findSum +
                '}';
    }

    public int findMax(int[] evenNumbersArray){

        findMax = evenNumbersArray[0];

        for (int j : evenNumbersArray) {
            if (findMax < j) findMax = j;
        }
        return findMax;
    }

    public int findMin(int[] evenNumbersArray){
        findMin = evenNumbersArray[0];
        for (int i : evenNumbersArray){
            if (findMin > i)findMin = i;
        }
        return findMin;
    }

    public int findSum(int[] evenNumbersArray){

        findSum = 0;

        for (int i = 0; i < evenNumbersArray.length ; i++){

            findSum = findSum + evenNumbersArray[i];
        }
        return findSum;
    }
}
