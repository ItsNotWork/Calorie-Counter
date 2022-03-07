package Util;

public class Converter {

    private final int stepToKilometer;
    private final int stepToKilocalories;

    public Converter(int stepToKilometer, int stepToKilocalories) {
        this.stepToKilometer = stepToKilometer;
        this.stepToKilocalories = stepToKilocalories;
    }

    @Override
    public String toString() {
        return "Converter{" +
                "stepToKilometer=" + stepToKilometer +
                ", stepToKilocalories=" + stepToKilocalories +
                '}';
    }

    public static double getStepToKilometer(int step) {
        return (double) step * 0.00075;
    }

    public static double getStepToKilocalories(int step) {
        return step * 0.05;
    }
}