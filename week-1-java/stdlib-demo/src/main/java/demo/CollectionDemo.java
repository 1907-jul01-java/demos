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
		TreeSet<Person> persons = new TreeSet<>(new Comparator<Person>() {
			@Override
			public int compare(Person o1, Person o2) {
				return o1.firstName.compareTo(o2.firstName);
			}
		});

		// Using Lambda Comparator
		persons = new TreeSet<>((o1, o2) -> o1.firstName.compareTo(o2.firstName));
		persons.add(new Person("Bob", "Builder", 40));
		persons.add(new Person("Bruce", "Wayne", 85));

		System.out.println(persons);

		for (Person p : persons) {
			System.out.println(p);
		}
	}

}

class Person implements Comparable<Person> {
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
	public int compareTo(Person o) {
		return o.age - this.age;
	}

}

class PersonLastNameComparator implements Comparator<Person> {

	@Override
	public int compare(Person o1, Person o2) {
		return o1.lastName.compareTo(o2.lastName);
	}

}