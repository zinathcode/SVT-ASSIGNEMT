public class GradeCalculator {

    public static String getGrade(int score) {
        if (score < 0 || score > 100) {
            throw new IllegalArgumentException("Invalid score: " );
        }

        if (score >= 90) {
            return "A";
        } else if (score >= 80) {
            return "B";
        } else if (score >= 70) {
            return "C";
        } else if (score >= 60) {
            return "D";
        } else {
            return "F";
        }
    }

}