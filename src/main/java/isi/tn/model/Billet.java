package isi.tn.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Billet {
private long id;
private int number;
private long cin;
private String firstName;
private String lastName;
public Billet()
{}
public Billet(int number,long cin,String firstName,String lastName)
{
	this.number = number;
	this.cin = cin;
	this.firstName = firstName;
	this.lastName = lastName;	

}

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
public long getId() {
	
	return id;
}
public void setId(long id) {
	this.id = id;
}
@Column(name = "number", nullable = false)
public int getNumber() {
	return number;
}
public void setNumber(int number) {
	this.number = number;
}
@Column(name = "cin", nullable = false)
public long getCin() {
	return cin;
}
public void setCin(long cin) {
	this.cin = cin;
}
@Column(name = "firstName", nullable = false)
public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	firstName = firstName;
}
@Column(name = "lastName", nullable = false)
public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}

@Override
public String toString() {
	return "Billet [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", cin=" + cin
			+ "number " + number+"]";
}
}
