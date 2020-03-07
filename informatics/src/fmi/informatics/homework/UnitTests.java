package fmi.informatics.homework;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.Assert;
import org.junit.Test;

import fmi.informatics.extending.Student;
import fmi.informatics.functional.IGravity;
import fmi.informatics.functional.Rock;

public class UnitTests {

	@Test
	public void Task1() {
		List<Student> students = new ArrayList<>();

		Stream.of(Student.StudentGenerator.make(), Student.StudentGenerator.make(), Student.StudentGenerator.make(),
				Student.StudentGenerator.make())
				.filter(s -> s.getName()
				.length() >= 5)
				.sorted((s1, s2) -> s1.getName()
				.compareTo(s2.getName()))
				.forEach(s -> students.add(s));

		Assert.assertNotEquals(students.get(1).getName(), "Lilly");
	}

	@Test
	public void Task2() {
		List<String> colours = new ArrayList<>();
		Stream.of("blue", "green", "yellow", "white")
		.map(String::toUpperCase)
		.collect(Collectors.toList())
		.forEach(s -> colours.add(s));

		Assert.assertEquals(colours.get(2), "YELLOW");
	}

	@Test
	public void Task3() {
		List<Student> students = new ArrayList<>();

		for (int i = 0; i <= 5; ++i) {
			students.add(Student.StudentGenerator.make());
		}

		String studentsNames = students
				.stream()
				.sorted((s1, s2) -> s1.getName().compareTo(s2.getName()))
				.map(s -> s.getName())
				.reduce((s1, s2) -> {
					if (s2 != null) {
						return s1 + ", " + s2;
					}else {
					return s1;
					}
				}).get();

		Assert.assertEquals(students.get(1).getName(), "Lilly");
	}

	@Test
	public void Task4() {
		List<Integer> expected = new ArrayList<>();
		Integer secondIndex = 8;
		IntStream.iterate(0, i -> i + 1)
		.skip(5)
		.limit(10)
		.forEach(i -> {
			if (i % 2 == 0) {
				expected.add(i);
				System.out.println(i);
			}
		});

		Assert.assertEquals(expected.get(1), secondIndex);
	}

	@Test
	public void Task5() {
		Rock test = new Rock();
		
		Assert.assertTrue(test.acceleration() == 9.80665);

	}
}
