package za.ac.cput.SmallProgram;
/* YasmeenSmallProgram.Java
 *  Author: Yasmeen Nel (219250553)
 *  Date: 29 March 2022
 * */
public class YasmeenSmallProgram {

    private String age, name, student;

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStudent() {
        return student;
    }

    public void setStudent(String student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "YasmeenClass{" + "age= " + age + ", name =" + name + ", student=" + student + '}';
    }
}
