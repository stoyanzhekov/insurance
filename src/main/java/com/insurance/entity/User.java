package com.insurance.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Stoyan on 2/19/2017.
 */
public class User implements Serializable {

    private short age;
    private String firstName;
    private String lastName;
    private String ID;
    private List<InsurancePolicy> insurancePolicy;

    public User(){}

    public User(short age, String firstName, String lastName, String ID, List<InsurancePolicy> insurancePolicy) {
        this.age = age;
        this.firstName = firstName;
        this.lastName = lastName;
        this.ID = ID;
        this.insurancePolicy = insurancePolicy;
    }

    public short getAge() {
        return age;
    }

    public void setAge(short age) {
        this.age = age;
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

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public List<InsurancePolicy> getInsurancePolicy() {
        return insurancePolicy;
    }

    public void setInsurancePolicy(List<InsurancePolicy> insurancePolicy) {
        this.insurancePolicy = insurancePolicy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (age != user.age) return false;
        if (!firstName.equals(user.firstName)) return false;
        if (!lastName.equals(user.lastName)) return false;
        return ID.equals(user.ID);

    }

    @Override
    public int hashCode() {
        int result = (int) age;
        result = 31 * result + firstName.hashCode();
        result = 31 * result + lastName.hashCode();
        result = 31 * result + ID.hashCode();
        return result;
    }
}
