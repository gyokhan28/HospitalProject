public class Doctor {
    protected int id;
    protected String firstName;
    protected String lastName;
    protected String speciality;

    public Doctor(int id, String firstName, String lastName, String speciality){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.speciality = speciality;
    }
    public Doctor(){
        setId(0);
        setFirstName("Unnamed");
        setLastName("Unnamed");
        setSpeciality("speciality");
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

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
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
}