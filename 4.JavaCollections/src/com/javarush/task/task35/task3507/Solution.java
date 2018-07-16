package com.javarush.task.task35.task3507;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.Set;

/* 
ClassLoader - что это такое?
*/
public class Solution {
	public static void main(String[] args) {
		Set<? extends Animal> allAnimals = getAllAnimals(Solution.class.getProtectionDomain().getCodeSource().getLocation().getPath() + Solution.class.getPackage().getName().replaceAll("[.]", "/") + "/data");
		System.out.println(allAnimals);
	}

	public static Set<? extends Animal> getAllAnimals(String pathToAnimals) {
		Set<Animal> animalSet = new HashSet<>();

		File[] files = new File(pathToAnimals).listFiles();
		for (File file : files) {
			if (file.isFile() && file.getName().endsWith(".class")) {
				String packageName = Solution.class.getPackage().getName() + ".data";
				Class clazz = new ClassFromPath().load(file.toPath(), packageName);

				int score = 0;
				Class[] interfaces = clazz.getInterfaces();
				for (Class interf : interfaces) {
					if (interf.getSimpleName().equals("Animal")) {
						score++;
						break;
					}
				}

				Constructor[] constructors = clazz.getConstructors();
				for (Constructor constructor : constructors) {
					if (constructor.getParameterCount() == 0) {
						score++;
					}
				}

				if (score == 2) {
					try {
						Animal animal = (Animal) clazz.newInstance();
						animalSet.add(animal);
					} catch (InstantiationException e) {
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					}
				}
			}
		}
		return animalSet;
	}

	public static class ClassFromPath extends ClassLoader {
		Class<?> load(Path path, String packageName) {
			try {
				String className = packageName + "." + path.getFileName().toString().replace(".class", "");
				byte[] bytes = Files.readAllBytes(path);
				return defineClass(className, bytes, 0, bytes.length);
			} catch (IOException e) {
				e.printStackTrace();
			}
			return null;
		}
	}
}
