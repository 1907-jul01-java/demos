package demo;

import java.util.Comparator;
import java.util.TreeSet;

public class CollectionDemo {

	public static void main(String[] args) {
		// ArrayList<Person> persons = new ArrayList<>();

		// TreeSet using natural ordering of Comparable compareTo()
		// TreeSet<Person> persons = new TreeSet<>();

		// Using Comparator
		// TreeSet<Person> persons = new TreeSet<Person>(new
		// PersonLastNameComparator());

		// Using Anonymous Comparator Class
		TreeSet<Dude> persons = new TreeSet<>(new Comparator<Dude>() {
			@Override
			public int compare(Dude o1, Dude o2) {
				return o1.firstName.compareTo(o2.firstName);
			}
		});

		// Using Lambda Comparator
		persons = new TreeSet<>((o1, o2) -> o1.firstName.compareTo(o2.firstName));
		persons.add(new Dude("Bob", "Builder", 40));
		persons.add(new Dude("Bruce", "Wayne", 85));

		System.out.println(persons);

		for (Dude p : persons) {
			System.out.println(p);
		}
	}

}

class Person implements Comparable<Dude> {
	public String firstName;
	public String lastName;
	public int age;

	public Person(String firstName, String lastName, int age) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person [firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + "]";
	}

	@Override
	public int compareTo(Dude o) {
		return o.age - this.age;
	}

}

class PersonLastNameComparator implements Comparator<Dude> {

	@Override
	public int compare(Dude o1, Dude o2) {
		return o1.lastName.compareTo(o2.lastName);
	}

}