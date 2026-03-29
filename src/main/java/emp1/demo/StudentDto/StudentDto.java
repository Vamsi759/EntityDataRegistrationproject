package emp1.demo.StudentDto;

import java.time.LocalDate;

public class StudentDto {

    private Long id;
    private String firstName;
    private String lastName;
    private String course;
    private String gender;
    private LocalDate dateOfBirth;
    private Integer age;
    private String phoneNumber;
    private String email;

    // Constructors
    public StudentDto() {}

    public StudentDto(Long id, String firstName, String lastName, String course,
                      String gender, LocalDate dateOfBirth, Integer age,
                      String phoneNumber, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.course = course;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    // Getters & Setters

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getCourse() { return course; }
    public void setCourse(String course) { this.course = course; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    public LocalDate getDateOfBirth() { return dateOfBirth; }
    public void setDateOfBirth(LocalDate dateOfBirth) { this.dateOfBirth = dateOfBirth; }

    public Integer getAge() { return age; }
    public void setAge(Integer age) { this.age = age; }

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}