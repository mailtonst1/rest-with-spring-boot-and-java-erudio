package br.com.erudio.data.vo.v1;



import br.com.erudio.model.Person;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

public class PersonVO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private long id;
    private String firstName;
    private String lastName;
    private String address;
    private String gender;


    public PersonVO() {
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public String getGender() {
        return gender;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (!Objects.equals(firstName, person.getFirstName())) return false;
        if (!Objects.equals(lastName, person.getLastName())) return false;
        if (!Objects.equals(address, person.getAddress())) return false;
        return Objects.equals(gender, person.getGender());
    }

    public int hashCode() {
        int result = firstName != null ? firstName.hashCode() : 0;
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        return result;
    }
}
