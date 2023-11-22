public class Patient implements Comparable<Patient> {
    private int id;
    private String firstName;
    private String lastName;
    private int age;
    public Patient(int id, String firstName, String lastName, int age){
        this.id=id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }
    public Patient(){
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
        return "Patient " +
                "ID: " + id +
                ", Name: " + firstName +
                " " + lastName +
                ", Age: " + age;
    }

    @Override
    public int compareTo(Patient o) {
        if(this.getFirstName().compareTo(o.getFirstName())!=0){
            return this.getFirstName().compareTo(o.getFirstName());
        } else {
            return this.getLastName().compareTo(o.getLastName());
        }
    }
}
