package com.studentapi;

import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final List<Student> students = new ArrayList<>();
    private final AtomicInteger nextId = new AtomicInteger(1);

    // GET - Get all students
    @GetMapping
    public List<Student> getAllStudents() {
        return students;
    }

    // GET - Get student by ID
    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable int id) {
        return students.stream()
                .filter(student -> student.getId() == id)
                .findFirst()
                .orElse(null);
    }

    // POST - Create new student
    @PostMapping
    public String addStudent(@RequestBody Student student) {
        student.setId(nextId.getAndIncrement());
        students.add(student);
        return "Student added successfully with ID: " + student.getId();
    }

    // PUT - Update student
    @PutMapping("/{id}")
    public String updateStudent(@PathVariable int id, @RequestBody Student updatedStudent) {
        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);
            if (student.getId() == id) {
                updatedStudent.setId(id);
                students.set(i, updatedStudent);
                return "Student updated successfully!";
            }
        }
        return "Student not found!";
    }

    // DELETE - Delete student
    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable int id) {
        boolean removed = students.removeIf(student -> student.getId() == id);
        return removed ? "Student deleted successfully!" : "Student not found!";
    }

    // Keep your original hello endpoint
    @GetMapping("/hello")
    public String sayHello() {
        return "Hello from Spring Boot! My Student API is working!";
    }
}