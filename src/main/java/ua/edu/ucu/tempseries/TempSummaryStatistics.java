package ua.edu.ucu.tempseries;

import lombok.Getter;

public class TempSummaryStatistics {
    @Getter
    private final double avgTemp;
    @Getter
    private final double devTemp;
    @Getter
    private final double minTemp;
    @Getter
    private final double maxTemp;

    public TempSummaryStatistics(TemperatureSeriesAnalysis temps) {
        avgTemp = temps.average();
        devTemp = temps.deviation();
        minTemp = temps.min();
        maxTemp = temps.max();
    }


}
