package ua.edu.ucu.tempseries;

import lombok.Getter;

public class TempSummaryStatistics {
    @Getter
    final private double avgTemp;
    @Getter
    final private double devTemp;
    @Getter
    final private double minTemp;
    @Getter
    final private double maxTemp;

    public TempSummaryStatistics(TemperatureSeriesAnalysis temps){
        avgTemp = temps.average();
        devTemp = temps.deviation();
        minTemp = temps.min();
        maxTemp = temps.max();
    }


}
