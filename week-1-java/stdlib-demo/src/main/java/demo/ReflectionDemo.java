package demo;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class ReflectionDemo {
	public static void main(String... args) {
		Dude dude = new Dude("Bob", 40);
		// Introspection
		System.out.println(dude.getClass().getName());
		System.out.println(Arrays.toString(dude.getClass().getDeclaredFields()));
		
		// Invocation
		Method m;
		try {
			m = dude.getClass().getMethod("birthday", new Class<?>[0]);
			m.invoke(dude);
		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
		
		// Modification
		Dude joe = new Dude("Joe", 30);
		try {
			Class<?> c = Class.forName(joe.getClass().getName());
			Field f = c.getDeclaredField("age");
			f.setAccessible(true);
			f.set(joe, -1000);
			System.out.println(joe);
		} catch (ClassNotFoundException | NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
	}

}

class Dude {
	private String name;
	private int age;
	public Dude(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	public Dude() {
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	
	public void birthday() {
		System.out.println("Happy Birthday!");
	}
}