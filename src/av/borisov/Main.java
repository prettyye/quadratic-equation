package av.borisov;

import java.util.*;

public final class Main {
	
	//Вывод корней на экран
	public static void printSolution(QuadraticEquation equation) {
		System.out.print("Ответ: ");
		if (!equation.isQuadratic()) {
			System.out.print("Уравнение не является квадратным.");
		}
		else if (!equation.hasRoots()) {
			System.out.print("Вещественных корней нет.");
		}
		else {
			for (float x : equation.solve()) {
				System.out.print(x + " ");
			}
		}
	}
	
	//Вывод коэффициентов на экран
	public static void printCoeff(QuadraticEquation equation) {
		Set<Character> keys = equation.getCoeff().keySet();
		for (char key : keys) {
			System.out.println(key + "=" + equation.getCoeff().get(key));
		}
	}
	
	public static void main(String[] args) {
		
		System.out.println("Уравнение без вещественных корней.");
		QuadraticEquation equation = new QuadraticEquation(1,1,1);
		printCoeff(equation);
		printSolution(equation);
		
		System.out.println("\n");
		
		System.out.println("Неквадратное уравнение.");
		equation.setCoeff(0, 1, 2);
		printCoeff(equation);
		printSolution(equation);
		
		System.out.println("\n");
		
		System.out.println("Уравнение с разными корнями.");
		equation.setCoeff(1, 0, -2);
		printCoeff(equation);
		printSolution(equation);
		
		System.out.println("\n");
		
		System.out.println("Уравнение с одинаковыми корнями.");
		equation.setCoeff(1, -2, 1);
		printCoeff(equation);
		printSolution(equation);
	}
}
