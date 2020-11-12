# apps20kmet-hw1

Task description:
=================
Implementation of methods for the **TemperatureSeriesAnalysis** class to work with a number of temperature values.
Create tests in **TemperatureSeriesAnalysisTest.java** to verify that the methods are correct.


Methods' description:
=====================
1. ***double average()***
***
Calculates the average temperature. If the row is empty, generates an IllegalArgumentException.

2. ***double deviation()***
***
Calculate the standard deviation. If the row is empty, generates an IllegalArgumentException.

3. ***double min()***
***
Returns the minimum temperature. If the row is empty, generates an IllegalArgumentException.

4. ***double max()***
***
Returns the maximum temperature. If the row is empty, generates an IllegalArgumentException.

5. ***double findTempClosestToZero()***
***
Returns the temperature value closest to 0. If the row is empty, generates an IllegalArgumentException.
If there are several values in the series that are equally close to 0, a larger value is returned.

6. ***double findTempClosestToValue (double tempValue)***
***
Similar to the previous method, but the value closest to the specified tempValue is returned.

7. ***double [] findTempsLessThan (double tempValue)***
***
Returns an array with temperature values that are less than the specified tempValue.

8. ***double [] findTempsGreaterThan (double tempValue)***
***
Returns an array with temperature values that are greater than the specified tempValue.

9. ***TempSummaryStatistics summaryStatistics()***
***
Returns an immutable instance of the **TempSummaryStatistics** class that contains information:
- double avgTemp;
- double devTemp;
- double minTemp;
- double maxTemp;
If the row is empty, generates an IllegalArgumentException.

10. ***int addTemps (double ... temps)***
***
Adds new temperature values to a series, and returns the total number of temperature values.


