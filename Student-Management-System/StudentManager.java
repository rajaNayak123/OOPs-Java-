import java.util.*;

public class StudentManager {
    ArrayList<Student> students = new ArrayList<>();

    // Add students 
    public void addStudent(Student student){
        students.add(student);
        System.out.print("Student added successfully");
    }

    public Student searchStudent(int id){
        for(Student s:students){
            if(s.getId(id) == id){
                return s;
            }
        }
        return null;
    }

    // remove student
    public void removeStudent(int id){
        Student s = searchStudent(id);
        if(s != null){
            students.remove(s);
            System.out.println("Student removed successfully!");
        }else{
            System.out.println("Student not found!");
        }
    }

    public void displayAll(){
        if (students.isEmpty()) {
            System.out.println("No students found!");
            return;
        }

        System.out.println("\n--- All Students ---");
        for (Student s : students) {
            System.out.println(s);
        }
    }

}
