package av.borisov;

import static java.lang.Math.*;
import java.util.*;

/**
 * Класс {@code QuadraticEquation} описывает уравнение вида
 * <i><b>ax<sup>2</sup> + bx + c = 0</b></i> и содержит методы для его решения.
 *  @author Александр Борисов
 */	
public class QuadraticEquation {
	
	//Переменные, хранящие коэффициенты квадратного уравнения и его корни.
	private float a, b, c;
	
	//Переменная, хранящая дискриминант данного уравнения
	private Discriminant discriminant;
	
	/**
	 * Внутренний класс, описывающий дискриминант данного квадратного уравнения.
	 * @author Александр Борисов
	 */
	public class Discriminant {
		
		//Переменная значения дискриминанта
		private float value;
		
		//Конструктор, предназначенный для вызова только в пределах класса QuadraticEquation.
		private Discriminant() {
			value=(float)(pow(b,2)-4*a*c);
		}
		
		public float getValue() {
			return value;
		}
	}
	
	/**
	 * Конструктор класса {@code QuadraticEquation}.
	 * Используется для создания квадратного уравнения с произвольными коэффициентами.
	 * 
	 * @param	a	коэффициент при <i><b>x<sup>2</sup></b></i>
	 * @param   b	коэффициент при <i><b>x</b></i>
	 * @param   c	свободный член
	 * 
	 * @see {@link #setCoeff(float a, float b, float c)}
	 */
	public QuadraticEquation(float a, float b, float c) {
		setCoeff(a,b,c);
	}
	
	/**
	 * Сеттер-функция для коэффициентов квадратного уравнения.
	 * Присваивает заданные пользователем значения соответствующим переменным экземпляра и
	 * обновляет решение уравнения.
	 *
	 * @param	a	коэффициент при <i><b>x<sup>2</sup></b></i>
	 * @param   b	коэффициент при <i><b>x</b></i>
	 * @param   c	свободный член
	 * 
	 * @see {@link #solve()}
	 */
	public void setCoeff(float a, float b, float c) {
		this.a = a;
		this.b = b;
		this.c = c;
		discriminant = new Discriminant();
	}
	
	/**
	 * Метод, выполняющий проверку на на неравенство нулю старшего коэффициента уравнения.
	 * 
	 * @return 	Возвращает булеву переменную, показывающую, 
	 * 			равен ли нулю старший коэффициент данного уравнения.
	 */
	public boolean isQuadratic() {
		if (a==0) {
			return false;
		}
		else {
			return true;
		}
	}
	
	/**
	 * Метод, выполняющий проверку на наличие вещественных корней уравнения.
	 * 
	 * @return 	Возвращает булеву переменную, показывающую, 
	 * 			есть ли корни у данного квадратного уравнения.
	 */
	public boolean hasRoots() {
		if (discriminant.value<0) {
			return false;
		}
		else {
			return true;
		}
	}
	
	/**
	 * Метод, решающий квадратное уравнение.
	 * 
	 * <ul><li>	Если корень один, возвращает массив с двумя одинаковыми значениями.
	 * <li>		Если вещественных корней нет или уравнение не является квадратным,
	 * 			возвращает массив, заполненный NaN.</ul>
	 * 
	 * @return 	Возвращает массив размера 2, содержащий корни данного квадратного уравнения.
	 */
	public float[] solve() {
		float x1 = (-b + (float)sqrt(discriminant.value))/(2*a);
		float x2 = (-b - (float)sqrt(discriminant.value))/(2*a);
		float[] result = new float[] {x1,x2};
		return result;
	}
	
	/**
	 * Геттер-функция для коэффициентов квадратного уравнения.
	 * 
	 * @return 	Возвращает словарь, содержащий коэффициенты данного квадратного уравнения.
	 */
	public Map<Character,Float> getCoeff() {	
		Map<Character,Float> coeff = new HashMap<Character,Float>();	
		coeff.put('a', a);
		coeff.put('b', b);
		coeff.put('c', c);
		return coeff;
	}
}
