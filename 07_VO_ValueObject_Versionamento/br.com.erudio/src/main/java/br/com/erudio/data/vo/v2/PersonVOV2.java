package br.com.erudio.data.vo.v2;



import br.com.erudio.model.Person;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class PersonVOV2 implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private long id;
    private String firstName;
    private String lastName;
    private String address;
    private String gender;
    private Date birth;


    public PersonVOV2() {
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PersonVOV2 that = (PersonVOV2) o;

        if (id != that.id) return false;
        if (!firstName.equals(that.firstName)) return false;
        if (!lastName.equals(that.lastName)) return false;
        if (!address.equals(that.address)) return false;
        if (!gender.equals(that.gender)) return false;
        return birth.equals(that.birth);
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + firstName.hashCode();
        result = 31 * result + lastName.hashCode();
        result = 31 * result + address.hashCode();
        result = 31 * result + gender.hashCode();
        result = 31 * result + birth.hashCode();
        return result;
    }
}
