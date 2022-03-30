/* StudentAccount.java
   Author Damone Hartnick(219093717)
   Date: March 2022
 */
package za.ac.cput.SmallProgram;

public class StudentAccount {
    String x;
    int y;

    public StudentAccount() {
    }

    public String getX() {
        return x;
    }

    public void setX(String x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "StudentAccount{" + "x=" + x + ", y=" + y + '}';
    }


}
