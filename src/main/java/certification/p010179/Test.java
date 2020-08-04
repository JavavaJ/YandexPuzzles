package certification.p010179;

class Student {
    String name;
    int marks;

    Student(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }

}

public class Test {

    public static void main(String[] args) {
        Student student = new Student("James", 25);
        int marks = 25;
        review(student, marks);
        System.out.println(marks + "-" + student.marks);
    }

    private static void review(Student stud, int marks) {
        marks = marks + 10;
        stud.marks += marks;
    }

}
