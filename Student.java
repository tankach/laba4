package sumdu.edu.ua.webstudent;

public class Student {
    private String name;
    private String surname;
    private String email;
    private String group;
    private String faculty;

    public Student(String name, String surname, String email, String group, String faculty) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.group = group;
        this.faculty = faculty;
    }

    // Геттери і сеттери тут

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public String getGroup() {
        return group;
    }

    public String getFaculty() {
        return faculty;
    }
}
