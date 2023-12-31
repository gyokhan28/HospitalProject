package Patient;

public class Patient implements Comparable<Patient> {
    private int id;
    private String firstName;
    private String lastName;
    private int age;

    public Patient(int id, String firstName, String lastName, int age) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public Patient() {
        setId(0);
        setFirstName("Unnamed");
        setLastName("Unnamed");
        setAge(0);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Patient {" +
                "ID: " + id +
                ", Name: " + firstName +
                " " + lastName +
                ", Age: " + age +
                "}";
    }

    @Override
    public int compareTo(Patient patient) {
        if (this.getFirstName().compareTo(patient.getFirstName()) != 0) {
            return this.getFirstName().compareTo(patient.getFirstName());
        } else {
            return this.getLastName().compareTo(patient.getLastName());
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Patient)) {
            return false;
        }
        Patient patientRight = (Patient) obj;
        if (this.getId() == patientRight.getId() &&
                this.getAge() == patientRight.getAge() &&
                this.getFirstName().equals(patientRight.getFirstName()) &&
                this.getLastName().equals(patientRight.getLastName())) {
            return true;
        } else {
            return false;
        }
    }
}
