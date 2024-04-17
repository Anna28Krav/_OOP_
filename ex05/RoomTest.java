package ex05;


public class RoomTest {

    public static void main(String[] args) {
        if (testCalculation() && testSolutionFinder()) {
            System.out.println("Коректність роботи програми підтверджена.");
        } else {
            System.out.println("Програма працює некоректно.");
        }
    }

    public static boolean testCalculation() {
        RoomCalculation calculation = new RoomCalculation();
        int testLength = 5;
        int testWidth = 4;
        int testHeight = 3;

        try {
            int perimeterResult = calculation.calculatePerimeter(testLength, testWidth);
            int expectedPerimeter = 18;
            if (perimeterResult != expectedPerimeter) {
                return false;
            }

            int areaResult = calculation.calculateArea(testLength, testWidth);
            int expectedArea = 20;
            if (areaResult != expectedArea) {
                return false;
            }

            int volumeResult = calculation.calculateVolume(testLength, testWidth, testHeight);
            int expectedVolume = 60;
            if (volumeResult != expectedVolume) {
                return false;
            }

            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean testSolutionFinder() {
        RoomSolutionFinder solutionFinder = new RoomSolutionFinder();

        try {
            int testLength = 5;
            int testWidth = 4;
            int testHeight = 3;

            int foundLength = solutionFinder.findLength();
            int foundWidth = solutionFinder.findWidth();
            int foundHeight = solutionFinder.findHeight();

            return foundLength == testLength && foundWidth == testWidth && foundHeight == testHeight;
        } catch (Exception e) {
            return false;
        }
    }
}
