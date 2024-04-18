//*************************************************************************
// Title : A java programme to demonstrate Single Responsibility Principle.
// Author : Nayon Mondol, Undergrduate student, Khulna University.
//*************************************************************************
/**
 * This class represents a simple Student.
 */
class Student {
    private String name;
    private int age;
    private String course;

    /**
     * Constructs a new Student object with the given name, age, and course.
     *
     * @param name   The name of the student.
     * @param age    The age of the student.
     * @param course The course the student is enrolled in.
     */
    public Student(String name, int age, String course) {
        this.name = name;
        this.age = age;
        this.course = course;
    }

    /**
     * Retrieves the name of the student.
     *
     * @return The name of the student.
     */
    public String getName() {
        return name;
    }

    /**
     * Retrieves the age of the student.
     *
     * @return The age of the student.
     */
    public int getAge() {
        return age;
    }

    /**
     * Retrieves the course the student is enrolled in.
     *
     * @return The course the student is enrolled in.
     */
    public String getCourse() {
        return course;
    }
}

/**
 * This class represents a simple StudentManagementSystem.
 */
class StudentManagementSystem {

    /**
     * Prints the details of a student.
     *
     * @param student The student whose details to print.
     */
    public void printStudentDetails(Student student) {
        System.out.println("Student Details:");
        System.out.println("Name: " + student.getName());
        System.out.println("Age: " + student.getAge());
        System.out.println("Course: " + student.getCourse());
    }
}

/**
 * This class demonstrates the usage of Student and StudentManagementSystem classes.
 */
class SchoolDemo {
    public static void main(String[] args) {
        // Create a student
        Student student = new Student("Nayon", 21, "Computer Science");

        // Enroll the student in a course using StudentManagementSystem
        StudentManagementSystem sms = new StudentManagementSystem();

        // Print student details using StudentManagementSystem
        sms.printStudentDetails(student);
    }
}

/**
 * In the abovementioned programme it is not the student's duty to print the
 * details rather the studentManagementSystem handles it leaving the student
 * class with a single responsibility of storing the attributes of a student.
 */