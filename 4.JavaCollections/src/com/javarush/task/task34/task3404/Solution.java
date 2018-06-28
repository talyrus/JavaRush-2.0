package com.javarush.task.task34.task3404;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

/*
Рекурсия для мат. выражения
*/
public class Solution {
	public static void main(String[] args) {
		Solution solution = new Solution();
		solution.recursion("sin(2*(-5+1.5*4)+28)", 0); //expected output 0.5 6
	}

	public void recursion(final String expression, int countOperation) {

		// counting operations in separate place, later use this count
		// tried to count with recursion method but too many invokings not connected with math operations
		if (countOperation == 0) {
			String tmp = expression.replaceAll("sin", "bin");
			for (int i = 0; i < tmp.length(); i++) {
				if ("*^+-tcb//".contains(String.valueOf(tmp.charAt(i)))) {
					countOperation++;
				}
			}
		}

		// spaces before and after - to ensure that no outOfBoundException
		String expressionTmp = " " + expression.replaceAll(" ", "") + " ";

		// took pattern in someones' code
		String pattern = "#.##";
		DecimalFormat decimalFormat = new DecimalFormat(pattern);
		DecimalFormatSymbols otherSymbols = new DecimalFormatSymbols();
		otherSymbols.setDecimalSeparator('.');
		decimalFormat.setDecimalFormatSymbols(otherSymbols);

		int positionOfNextClosePar = 0;
		double tmpNumber = 0;

		// managing sinuses
		for (int i = 0; i < expressionTmp.length(); i++) {
			if ((expressionTmp.charAt(i) == 's') && (expressionTmp.charAt(i + 1) == 'i')) { //searching for "si"
				try {
					//trying to parse parameter of trig func
					positionOfNextClosePar = expressionTmp.indexOf(")", i);
					tmpNumber = Double.parseDouble(expressionTmp.substring(i + 4, positionOfNextClosePar));

					//if the parameter is parsed, counting value and changing in expression for its' value
					tmpNumber = Math.toRadians(tmpNumber);
					tmpNumber = Math.sin(tmpNumber);

					// result can be <0 then it'll be in parences
					String strToReplace = tmpNumber >= 0 ? decimalFormat.format(tmpNumber) : "(" + decimalFormat.format(tmpNumber) + ")";
					expressionTmp = expressionTmp.substring(0, i) + strToReplace + expressionTmp.substring(positionOfNextClosePar + 1);

					// invoking method with new string, operations count + 1
					recursion(expressionTmp, countOperation);
					return;
				} catch (Exception ignored) {
//                    e.printStackTrace();
				}
			}
		}

		// managing cosinuses
		for (int i = 0; i < expressionTmp.length(); i++) {
			if ((expressionTmp.charAt(i) == 'c') && (expressionTmp.charAt(i + 1) == 'o')) { //searching for "co"
				try {
					//trying to parse parameter of trig func
					positionOfNextClosePar = expressionTmp.indexOf(")", i);
					tmpNumber = Double.parseDouble(expressionTmp.substring(i + 4, positionOfNextClosePar));

					//if the parameter is parsed, counting value and changing in expression for its' value
					tmpNumber = Math.toRadians(tmpNumber);
					tmpNumber = Math.cos(tmpNumber);

					// result can be <0 then it'll be in parences
					String strToReplace = tmpNumber >= 0 ? decimalFormat.format(tmpNumber) : "(" + decimalFormat.format(tmpNumber) + ")";
					expressionTmp = expressionTmp.substring(0, i) + strToReplace + expressionTmp.substring(positionOfNextClosePar + 1);

					// invoking method with new string, operations count + 1
					recursion(expressionTmp, countOperation);
					return;
				} catch (Exception e) {
//                    e.printStackTrace();
				}
			}
		}

		// managing tang
		for (int i = 0; i < expressionTmp.length(); i++) {
			if ((expressionTmp.charAt(i) == 't') && (expressionTmp.charAt(i + 1) == 'a')) { //searching for "ta"
				try {
					//trying to parse parameter of trig func
					positionOfNextClosePar = expressionTmp.indexOf(")", i);
					tmpNumber = Double.parseDouble(expressionTmp.substring(i + 4, positionOfNextClosePar));

					//if the parameter is parsed, counting value and changing in expression for its' value
					tmpNumber = Math.toRadians(tmpNumber);
					tmpNumber = Math.tan(tmpNumber);

					// result can be <0 then it'll be in parences
					String strToReplace = tmpNumber >= 0 ? decimalFormat.format(tmpNumber) : "(" + decimalFormat.format(tmpNumber) + ")";
					expressionTmp = expressionTmp.substring(0, i) + strToReplace + expressionTmp.substring(positionOfNextClosePar + 1);

					// invoking method with new string, operations count + 1
					recursion(expressionTmp, countOperation);
					return;
				} catch (Exception e) {
//                    e.printStackTrace();
				}
			}
		}

		// managing ^
		String signs = "*+- tncs^()//";
		for (int i = 0; i < expressionTmp.length(); i++) {

			// it shouldn be like this - ( smth ) ^ (smth else) , we need to calc smth first
			if ((expressionTmp.charAt(i) == '^') && (expressionTmp.charAt(i + 1) != '(') && (expressionTmp.charAt(i - 1) != ')')) {
				try {

					// searching for nearest sings of other operations, parsing two dobles beetwing them and ^ sign
					int firstPos = 0, lastPos = expressionTmp.length() - 1;
					if (expressionTmp.charAt(i + 1) == '-')
						i = i + 1;
					for (int j = i + 1; j < expressionTmp.length(); j++) {
						if (signs.contains(String.valueOf(expressionTmp.charAt(j)))) {
							lastPos = j;
							break;
						}
					}
					if (expressionTmp.charAt(i) == '-')
						i = i - 1;
					for (int j = i - 1; j > 0; j--) {
						if (signs.contains(String.valueOf(expressionTmp.charAt(j)))) {
							firstPos = j;
							break;
						}
					}

					double num1, num2;
					num1 = Double.parseDouble(expressionTmp.substring(firstPos + 1, i));
					num2 = Double.parseDouble(expressionTmp.substring(i + 1, lastPos));
					tmpNumber = Math.pow(num1, num2);

					expressionTmp = expressionTmp.substring(0, firstPos + 1) + decimalFormat.format(tmpNumber) + expressionTmp.substring(lastPos);

					recursion(expressionTmp, countOperation);
					return;
				} catch (Exception ignored) {
//                    e.printStackTrace();
				}
			}
		}

		// managing * or /
		signs = "*+- tncs()//";

		for (int i = 0; i < expressionTmp.length(); i++) {
			if ((expressionTmp.charAt(i) == '*') && (expressionTmp.charAt(i + 1) != '(') && (expressionTmp.charAt(i - 1) != ')')) {
				try {
					int firstPos = 0, lastPos = expressionTmp.length() - 1;
					for (int j = i + 1; j < expressionTmp.length(); j++) {
						if (signs.contains(String.valueOf(expressionTmp.charAt(j)))) {
							lastPos = j;
							break;
						}
					}
					signs = "+- tncs()"; // before cant be * or / signs - wrong order
					for (int j = i - 1; j > 0; j--) {
						if (signs.contains(String.valueOf(expressionTmp.charAt(j)))) {
							firstPos = j;
							break;
						}
					}

					double num1, num2;
					num1 = Double.parseDouble(expressionTmp.substring(firstPos + 1, i));
					num2 = Double.parseDouble(expressionTmp.substring(i + 1, lastPos));
					tmpNumber = num1 * num2;
					expressionTmp = expressionTmp.substring(0, firstPos + 1) + decimalFormat.format(tmpNumber) + expressionTmp.substring(lastPos);

					recursion(expressionTmp, countOperation);
					return;
				} catch (Exception ignored) {
				}
			}

			if ((expressionTmp.charAt(i) == '/') && (expressionTmp.charAt(i + 1) != '(') && (expressionTmp.charAt(i - 1) != ')')) {
				try {
					int firstPos = 0, lastPos = expressionTmp.length() - 1;
					for (int j = i + 1; j < expressionTmp.length(); j++) {
						if (signs.contains(String.valueOf(expressionTmp.charAt(j)))) {
							lastPos = j;
							break;
						}
					}
					signs = "+- tncs()"; // before cant be * or / signs - it means wrong order of operations
					for (int j = i - 1; j > 0; j--) {
						if (signs.contains(String.valueOf(expressionTmp.charAt(j)))) {
							firstPos = j;
							break;
						}
					}

					double num1, num2;
					num1 = Double.parseDouble(expressionTmp.substring(firstPos + 1, i));
					num2 = Double.parseDouble(expressionTmp.substring(i + 1, lastPos));
					tmpNumber = num1 / num2;
					expressionTmp = expressionTmp.substring(0, firstPos + 1) + decimalFormat.format(tmpNumber) + expressionTmp.substring(lastPos);

					recursion(expressionTmp, countOperation);
					return;
				} catch (Exception ignored) {
				}
			}
		}

		// managing + or -
		signs = "- tncs()+";
		for (int i = 0; i < expressionTmp.length(); i++) {
			if ((expressionTmp.charAt(i) == '+') && (expressionTmp.charAt(i + 1) != '(') && (expressionTmp.charAt(i - 1) != ')')) {
				try {
					int firstPos = 0, lastPos = expressionTmp.length() - 1;
					for (int j = i + 1; j < expressionTmp.length(); j++) {
						if (signs.contains(String.valueOf(expressionTmp.charAt(j)))) {
							lastPos = j;
							break;
						}
					}
					signs = " tncs()";
					for (int j = i - 1; j > 0; j--) {
						if (expressionTmp.charAt(j) == '-' && (expressionTmp.charAt(j - 1) == '-')) {
							firstPos = j - 1;
							break;
						}
						if (signs.contains(String.valueOf(expressionTmp.charAt(j)))) {
							firstPos = j;
							break;
						}
					}

					double num1, num2;
					num1 = Double.parseDouble(expressionTmp.substring(firstPos + 1, i));
					num2 = Double.parseDouble(expressionTmp.substring(i + 1, lastPos));
					tmpNumber = num1 + num2;
					expressionTmp = expressionTmp.substring(0, firstPos + 1) + decimalFormat.format(tmpNumber) + expressionTmp.substring(lastPos);

					recursion(expressionTmp, countOperation);
					return;
				} catch (Exception ignored) {
				}
			}

			signs = "- tncs()+";
			if ((expressionTmp.charAt(i) == '-') && (expressionTmp.charAt(i + 1) != '(') && (expressionTmp.charAt(i - 1) != ')')) {
				try {
					int firstPos = 0, lastPos = expressionTmp.length() - 1;
					for (int j = i + 1; j < expressionTmp.length(); j++) {
						if (signs.contains(String.valueOf(expressionTmp.charAt(j)))) {
							lastPos = j;
							break;
						}
					}
					signs = " tncs()";
					for (int j = i - 1; j > 0; j--) {
						if (expressionTmp.charAt(j) == '-' && (expressionTmp.charAt(j - 1) == '-')) {
							firstPos = j - 1;
							break;
						}
						if (signs.contains(String.valueOf(expressionTmp.charAt(j)))) {
							firstPos = j;
							break;
						}
					}

					double num1, num2;
					num1 = Double.parseDouble(expressionTmp.substring(firstPos + 1, i));
					num2 = Double.parseDouble(expressionTmp.substring(i + 1, lastPos));
					tmpNumber = num1 - num2;
					expressionTmp = expressionTmp.substring(0, firstPos + 1) + decimalFormat.format(tmpNumber) + expressionTmp.substring(lastPos);

					recursion(expressionTmp, countOperation);
					return;
				} catch (Exception ignored) {
				}
			}
		}

		// managing (1.0) - removing parenteces, but if number inside is < 0,
		// making adjustments, looking on math sign before opening (
		for (int i = 0; i < expressionTmp.length(); i++) {
			if (expressionTmp.charAt(i) == '(') {
				try {
					tmpNumber = Double.parseDouble(expressionTmp.substring(i + 1, expressionTmp.indexOf(')', i)));
					if (tmpNumber >= 0) {
						expressionTmp = expressionTmp.substring(0, i) + decimalFormat.format(tmpNumber) + expressionTmp.substring(expressionTmp.indexOf(')', i) + 1);
						recursion(expressionTmp, countOperation);
						return;
					} else {
						for (int j = i - 1; j >= 0; j--) {
							if (expressionTmp.charAt(j) == '^') {
								expressionTmp = expressionTmp.substring(0, i) + String.valueOf(tmpNumber) + expressionTmp.substring(expressionTmp.indexOf(')', i) + 1);
								recursion(expressionTmp, countOperation);
								return;
							}
							if (expressionTmp.charAt(j) == '+') {
								expressionTmp = expressionTmp.substring(0, j) + "-" + expressionTmp.substring(j + 1, i) + String.valueOf(-tmpNumber) + expressionTmp.substring(expressionTmp.indexOf(')', i) + 1);
								recursion(expressionTmp, countOperation);
								return;
							}
							if (expressionTmp.charAt(j) == '-') {
								expressionTmp = expressionTmp.substring(0, j) + "+" + expressionTmp.substring(j + 1, i) + String.valueOf(-tmpNumber) + expressionTmp.substring(expressionTmp.indexOf(')', i) + 1);
								recursion(expressionTmp, countOperation);
								return;
							}
							if (expressionTmp.charAt(j) == '(') {
								expressionTmp = expressionTmp.substring(0, j) + "(-" + expressionTmp.substring(j + 1, i) + String.valueOf(-tmpNumber) + expressionTmp.substring(expressionTmp.indexOf(')', i) + 1);
								recursion(expressionTmp, countOperation);
								return;
							}
							if (expressionTmp.charAt(j) == ' ') {
								expressionTmp = expressionTmp.substring(0, j) + "-" + expressionTmp.substring(j + 1, i) + String.valueOf(-tmpNumber) + expressionTmp.substring(expressionTmp.indexOf(')', i) + 1);
								recursion(expressionTmp, countOperation);
								return;
							}
						}
					}
					continue;
				} catch (Exception e) {
					continue;
				}
			}
		}

		// finally printing the number
		tmpNumber = Double.parseDouble(expressionTmp.trim());
		System.out.println(decimalFormat.format(tmpNumber) + " " + countOperation);
	}

	public Solution() {
		//don't delete
	}
}
