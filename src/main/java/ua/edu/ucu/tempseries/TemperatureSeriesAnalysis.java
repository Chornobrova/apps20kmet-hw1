package ua.edu.ucu.tempseries;

import java.util.InputMismatchException;

public class TemperatureSeriesAnalysis {
    private static final double ABSOLUTE_ZERO = -273.0;
    private double[] temps;
    private int size;

    public TemperatureSeriesAnalysis() {
        size = 0;
        temps = new double[1];

    }

    public TemperatureSeriesAnalysis(double[] temperatureSeries) {
        size = 0;
        temps = new double[1];
        addTemps(temperatureSeries);
    }

    public double average() throws IllegalArgumentException {
        if (size == 0) {
            throw new IllegalArgumentException();
        }
        double sum = 0;
        for (int i = 0; i < size; i++) {
            sum += temps[i];
        }
        return sum/size;
    }

    public double deviation() throws IllegalArgumentException {
        double avgSquared = average() * average();
        double squaresSum = 0;
        for (int i = 0; i < size; i++) {
            squaresSum += temps[i] * temps[i];
        }
        return squaresSum/size - avgSquared;
    }

    public double min() throws IllegalArgumentException {
        if (size == 0) {
            throw new IllegalArgumentException();
        }
        double min = Double.POSITIVE_INFINITY;
        for (int i = 0; i < size; i++) {
            min = Math.min(min, temps[i]);
        }
        return min;
    }

    public double max() throws IllegalArgumentException {
        if (size == 0) {
            throw new IllegalArgumentException();
        }
        double max = Double.NEGATIVE_INFINITY;
        for (int i = 0; i < size; i++) {
            max = Math.max(max, temps[i]);
        }
        return max;
    }

    public double findTempClosestToZero()
            throws IllegalArgumentException {
        return findTempClosestToValue(0.0);
    }

    public double findTempClosestToValue(double tempValue)
            throws IllegalArgumentException {
        if (size == 0) {
            throw new IllegalArgumentException();
        }
        double result = Double.NEGATIVE_INFINITY;
        double minDiff = Double.POSITIVE_INFINITY;
        for (int i = 0; i < size; i++) {
            if (Math.abs(temps[i] - tempValue) < minDiff) {
                result = temps[i];
                minDiff = Math.abs(temps[i] - tempValue);
            } else if (Math.abs(temps[i] - tempValue) == minDiff) {
                result = Math.max(result, temps[i]);
            }
        }
        return result;
    }

    public double[] findTempsLessThen(double tempValue) {
        double[] less = new double[size];
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (temps[i] < tempValue) {
                less[count] = temps[i];
                count += 1;
            }
        }
        double[] result = new double[count];
        System.arraycopy(less, 0, result, 0, count);
        return result;

    }

    public double[] findTempsGreaterThen(double tempValue) {
        double[] greater = new double[size];
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (temps[i] > tempValue) {
                greater[count] = temps[i];
                count += 1;
            }
        }
        double[] result = new double[count];
        System.arraycopy(greater, 0, result, 0, count);
        return result;
    }

    public TempSummaryStatistics summaryStatistics()
            throws IllegalArgumentException {
        return new TempSummaryStatistics(this);
    }

    public int addTemps(double... temps)
            throws InputMismatchException {
        for (double temp: temps) {
            if (temp < ABSOLUTE_ZERO) {
                throw new InputMismatchException();
            }
        }
        for (double temp: temps) {
            if (size == this.temps.length) {
                double[] newTemps = new double[2 * size];
                System.arraycopy(
                        this.temps,
                        0,
                        newTemps,
                        0,
                        size);
                this.temps = newTemps;
            }
            this.temps[size] = temp;
            size += 1;
        }
        return 0;
    }
}
