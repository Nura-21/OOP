package wspEnums;

import java.util.*;

public class TextGrade {
	private static final Map<Double, String> textGrade;
	private static final Map<String, Double> digitalGrade;

	static {
		textGrade = new TreeMap<>();
		textGrade.put(50.0, "F");
		textGrade.put(55.0, "D-");
		textGrade.put(60.0, "D+");
		textGrade.put(65.0, "C-");
		textGrade.put(70.0, "C");
		textGrade.put(75.0, "C+");
		textGrade.put(80.0, "B-");
		textGrade.put(85.0, "B");
		textGrade.put(90.0, "B+");
		textGrade.put(95.0, "A-");
		textGrade.put(101.0, "A");
		digitalGrade = new TreeMap<>();
		digitalGrade.put("F", 0.00);
		digitalGrade.put("D-", 1.00);
		digitalGrade.put("D+", 1.33);
		digitalGrade.put("C-", 1.67);
		digitalGrade.put("C", 2.00);
		digitalGrade.put("C+", 2.33);
		digitalGrade.put("B-", 2.67);
		digitalGrade.put("B", 3.00);
		digitalGrade.put("B+", 3.33);
		digitalGrade.put("A-", 3.67);
		digitalGrade.put("A", 4.00);
	}

	public static String getTextGrade(double score) {
		for (Map.Entry<Double, String> entry : textGrade.entrySet()) {
			double grade = entry.getKey();
			if (score < grade)
				return entry.getValue();
		}
		throw new AssertionError("Impossible case");
	}

	public static double getDigitalGrade(String score) {
		for (Map.Entry<String, Double> entry : digitalGrade.entrySet()) {
			String grade = entry.getKey();
			if (score == grade) {
				return entry.getValue();
			}
		}
		throw new AssertionError("Impossible case");
	}
}
