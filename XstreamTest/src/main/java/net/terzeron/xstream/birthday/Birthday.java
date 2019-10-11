package net.terzeron.xstream.birthday;
import java.util.Calendar;


public class Birthday {
	private Person person;
	private Calendar date;
	private char gender;
	
	public Person getPerson() {
		return person;
	}
	
	public void setPerson(Person person) {
		this.person = person;
	}
	
	public Calendar getDate() {
		return date;
	}
	
	public void setDate(Calendar date) {
		this.date = date;
	}
	
	public char getGender() {
		return gender;
	}
	
	public void setGenderMale() {
		this.gender = 'm';
	}
	
	public void setGenderFemale() {
		this.gender = 'f';
	}
	
}
