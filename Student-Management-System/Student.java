public class Student {
    private int id;
    private String name;
    private double grade;

    Student(int id, String name, double grade){
        this.id = id;
        this.name = name;
        this.grade = grade;
    }

    public String getName(String name){
        return name;
    }

    public int getId(int id){
        return id;
    }

    public double getGrade(double grade){
        return grade;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setGrade(double grade){
        this.grade = grade;
    }
}
