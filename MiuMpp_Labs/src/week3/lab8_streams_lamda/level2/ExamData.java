package week3.lab8_streams_lamda.level2;

import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.function.ToDoubleFunction;
import java.util.stream.Collectors;

public class ExamData {
	private String studentName;
	private double testScore;

	public ExamData(String name, double score) {
		studentName = name;
		testScore = score;
	}

	public double getTestScore() {
		return this.testScore;
	}

	public static void main(String[] args) {
		List<ExamData> data = new ArrayList<ExamData>() {
			{
				add(new ExamData("George", 91.3));
				add(new ExamData("Tom", 88.9));
				add(new ExamData("Rick", 80));
				add(new ExamData("Harold", 90.8));
				add(new ExamData("Ignatius", 60.9));
				add(new ExamData("Anna", 77));
				add(new ExamData("Susan", 87.3));
				add(new ExamData("Phil", 99.1));
				add(new ExamData("Alex", 84));
			}
		};

		/*
		 * 4) Use DoubleSummaryStatistics to output to the console the top test score,
		 * lowest test score, and average among all test scores in a given list.
		 */
		System.out.println("04. DoubleSummaryStatistics (one way)");
		DoubleSummaryStatistics summaryStatistics1 = data.stream()
				.collect(Collectors.summarizingDouble(ExamData::getTestScore));
		double max1 = summaryStatistics1.getMax();
		double min1 = summaryStatistics1.getMin();
		double avg1 = summaryStatistics1.getAverage();

		System.out.println(
				String.format("Top Test Score : %.2f%nLowest Test Score: %.2f%nAverage: %.2f", max1, min1, avg1));

		System.out.println("\n04. DoubleSummaryStatistics (another way)");
		ToDoubleFunction<ExamData> func1 = new ToDoubleFunction<ExamData>() {
			@Override
			public double applyAsDouble(ExamData value) {
				return value.testScore;
			}
		};
		ToDoubleFunction<ExamData> func2 = d -> d.testScore;

		DoubleSummaryStatistics summaryStatistics2 = data.stream()
				.collect(Collectors.summarizingDouble(func2));
		double max2 = summaryStatistics2.getMax();
		double min2 = summaryStatistics2.getMin();
		double avg2 = summaryStatistics2.getAverage();

		System.out.println(
				String.format("Top Test Score : %.2f%nLowest Test Score: %.2f%nAverage: %.2f", max2, min2, avg2));
	}
}
