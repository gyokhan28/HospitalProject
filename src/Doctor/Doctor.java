package Doctor;

import java.util.Objects;

public class Doctor {
    protected int id;
    protected String firstName;
    protected String lastName;
    protected Specialities speciality;

    public Doctor(int id, String firstName, String lastName, Specialities speciality){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.speciality = speciality;
    }
    public Doctor(){
        setId(0);
        setFirstName("Unnamed");
        setLastName("Unnamed");
        setSpeciality(Specialities.DERMATOLOGY);
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

    public Specialities getSpeciality() {
        return speciality;
    }

    public void setSpeciality(Specialities speciality) {
        this.speciality = speciality;
    }

    @Override
    public String toString() {
        return "Doctor" +
                " ID:" + id +
                " First name: " + firstName +
                ", Last name: " + lastName +
                ", Speciality: " + speciality +
                "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Doctor doctor = (Doctor) o;
        return id == doctor.id && Objects.equals(firstName, doctor.firstName) && Objects.equals(lastName, doctor.lastName) && speciality == doctor.speciality;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, speciality);
    }
}