package ua.edu.ucu.tempseries;

import static org.junit.Assert.*;
import org.junit.Test;

import java.util.InputMismatchException;

public class TemperatureSeriesAnalysisTest {

    @Test
    public void testAverageWithOneElementArray() {
        // setup input data and expected result
        double[] temperatureSeries = {-1.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = -1.0;

        // call tested method
        double actualResult = seriesAnalysis.average();

        // compare expected result with actual result
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAverageWithEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);

        // expect exception here
        seriesAnalysis.average();
    }

    @Test
    public void testAverage() {
        double[] temperatureSeries = {3.0, -5.0, 1.0, 5.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 1.0;

        double actualResult = seriesAnalysis.average();
        
        assertEquals(expResult, actualResult, 0.00001);        
    }

    @Test
    public void testDeviationWithOneElementArray() {
        double[] temperatureSeries = {-1.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 0.0;
        double actualResult = seriesAnalysis.deviation();
        assertEquals(expResult, actualResult, 0.00001);
    }


    @Test(expected = IllegalArgumentException.class)
    public void testDeviationWithEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        seriesAnalysis.deviation();
    }

    @Test
    public void testDeviation() {
        double[] temperatureSeries = {3.0, -5.0, -3.0, 5.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 17.0;
        double actualResult = seriesAnalysis.deviation();
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testMinWithOneElementArray() {
        double[] temperatureSeries = {-1.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = -1.0;
        double actualResult = seriesAnalysis.min();
        assertEquals(expResult, actualResult, 0.00001);
    }


    @Test(expected = IllegalArgumentException.class)
    public void testMinWithEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        seriesAnalysis.min();
    }

    @Test
    public void testMin() {
        double[] temperatureSeries = {3.0, -5.0, -3.0, 5.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 5.0;
        double actualResult = seriesAnalysis.max();
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testMaxWithOneElementArray() {
        double[] temperatureSeries = {-1.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = -1.0;
        double actualResult = seriesAnalysis.max();
        assertEquals(expResult, actualResult, 0.00001);
    }


    @Test(expected = IllegalArgumentException.class)
    public void testMaxWithEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        seriesAnalysis.max();
    }

    @Test
    public void testMax() {
        double[] temperatureSeries = {3.0, -5.0, -3.0, 5.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 17.0;
        double actualResult = seriesAnalysis.deviation();
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testClosestToZeroWithOneElementArray() {
        double[] temperatureSeries = {-1.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = -1.0;
        double actualResult = seriesAnalysis.findTempClosestToZero();
        assertEquals(expResult, actualResult, 0.00001);
    }


    @Test(expected = IllegalArgumentException.class)
    public void testClosestToZeroWithEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        seriesAnalysis.findTempClosestToZero();
    }

    @Test
    public void testClosestToZero() {
        double[] temperatureSeries = {3.0, -5.0, -3.0, 5.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 3.0;
        double actualResult = seriesAnalysis.findTempClosestToZero();
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testClosestToValueWithOneElementArray() {
        double[] temperatureSeries = {-1.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = -1.0;
        double actualResult = seriesAnalysis.findTempClosestToValue(200.0);
        assertEquals(expResult, actualResult, 0.00001);
    }


    @Test(expected = IllegalArgumentException.class)
    public void testClosestToValueWithEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        seriesAnalysis.findTempClosestToValue(200.0);
    }

    @Test
    public void testClosestToValue() {
        double[] temperatureSeries = {3.0, -5.0, -3.0, 5.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 5.0;
        double actualResult = seriesAnalysis.findTempClosestToValue(4.0);
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testFindLessWithOneElementArray() {
        double[] temperatureSeries = {-1.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double[] expResult = {-1.0};
        double[] actualResult = seriesAnalysis.findTempsLessThen(0.0);
        assertArrayEquals(expResult, actualResult, 0.00001);
    }

    public void testFindLessWithEmptyArray() {
        double[] temperatureSeries = {};
        double[] expResult = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double[] actualResult = seriesAnalysis.findTempsLessThen(200.0);
        assertArrayEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testFindLess() {
        double[] temperatureSeries = {3.0, -5.0, -3.0, 5.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double[] expResult = {3.0, -5.0, -3.0};
        double[] actualResult = seriesAnalysis.findTempsLessThen(4.0);
        assertArrayEquals(expResult, actualResult, 0.00001);
    }


    @Test
    public void testFindGreaterWithOneElementArray() {
        double[] temperatureSeries = {-1.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double[] expResult = {};
        double[] actualResult = seriesAnalysis.findTempsGreaterThen(0.0);
        assertArrayEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testFindGreaterWithEmptyArray() {
        double[] temperatureSeries = {};
        double[] expResult = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double[] actualResult = seriesAnalysis.findTempsGreaterThen(200.0);
        assertArrayEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testFindGreater() {
        double[] temperatureSeries = {3.0, -5.0, -3.0, 5.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double[] expResult = {3.0, -3.0, 5.0};
        double[] actualResult = seriesAnalysis.findTempsGreaterThen(-4.0);
        assertArrayEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testSummaryStatistics() {
        double[] temperatureSeries = {3.0, -5.0, -3.0, 5.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double average = 0.0;
        double deviation = 17.0;
        double min = -5.0;
        double max = 5.0;
        TempSummaryStatistics actualResult = seriesAnalysis.summaryStatistics();
        assertEquals(average, actualResult.getAvgTemp(), 0.00001);
        assertEquals(deviation, actualResult.getDevTemp(), 0.00001);
        assertEquals(min, actualResult.getMinTemp(), 0.00001);
        assertEquals(max, actualResult.getMaxTemp(), 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSummaryStatisticsWithEmptyArray() {
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis();
        TempSummaryStatistics actualResult = seriesAnalysis.summaryStatistics();

    }

    @Test
    public void testAddTemps(){
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis();
        seriesAnalysis.addTemps(1.0, -1.0, 5.0, -5.0);
        double expResult = 0.0;
        double actualResult = seriesAnalysis.average();
        assertEquals(expResult, actualResult, 0.00001);

    }

    @Test(expected = InputMismatchException.class)
    public void testAddInvalidTemps(){
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis();
        seriesAnalysis.addTemps(1.0, -280.7, 5.0, -5.0);

    }








    

}
