public class Student {
    // Student properties
    private int id;
    private String name;
    private int age;
    private double marks;

    // Constructor - to create Student objects
    public Student(int id, String name, int age, double marks) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.marks = marks;
    }

    // Getters - to access the private properties
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getMarks() {
        return marks;
    }

    // Setters - to update the properties
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }

    // Method to display student info
    public void displayInfo() {
        System.out.println("ID: " + id + " | Name: " + name + " | Age: " + age + " | Marks: " + marks);
    }
}