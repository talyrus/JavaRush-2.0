package com.javarush.task.task30.task3012;

/* 
Получи заданное число
*/

public class Solution {
	public static void main(String[] args) {
		Solution solution = new Solution();
		solution.createExpression(74);
	}

	public void createExpression(int number) {
		int[] massive = {1, 3, 9, 27, 81, 243, 729, 2187};
		String stroka = "";
		int num = number;
		while (num > 0) // переведем в троичную систему счисления
		{
			if (num % 3 == 0) {
				stroka = stroka + "0";
				num /= 3;
			} else if (num % 3 == 1) {
				stroka = stroka + "+";
				num /= 3;
			} else if (num % 3 == 2) {
				stroka = stroka + "-";
				num /= 3;
				num++;
			}
		}
		int sum = 0;
		String str = "";
		for (int i = 0; i < stroka.length(); i++) { //проходим по полученной строке и ассоциируем ее символы с числами в массиве
			if (stroka.charAt(i) == '+') {
				str += " + " + massive[i];
				sum += massive[i];
			} else if (stroka.charAt(i) == '-') {
				str += " - " + massive[i];
				sum -= massive[i];
			}
		}
		System.out.println(sum + " =" + str);
	}
}

