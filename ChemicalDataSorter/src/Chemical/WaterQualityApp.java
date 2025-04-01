package Chemical;
class WaterSample {
    private String stationId;
    private String stationName;
    private double temperature;
    private double ph;
    private double chloride;
    private double fluoride;

    public WaterSample(String stationId, String stationName, double temperature, double ph, double chloride, double fluoride) {
        this.stationId = stationId;
        this.stationName = stationName;
        this.temperature = temperature;
        this.ph = ph;
        this.chloride = chloride;
        this.fluoride = fluoride;
    }

    public String getStationId() {
        return stationId;
    }

    public String getStationName() {
        return stationName;
    }

    public double getTemperature() {
        return temperature;
    }

    public double getPh() {
        return ph;
    }

    public double getChloride() {
        return chloride;
    }

    public double getFluoride() {
        return fluoride;
    }

    @Override
    public String toString() {
        return String.format("%-10s %-15s %-12.2f %-8.2f %-10.2f %-10.2f", 
                stationId, stationName, temperature, ph, chloride, fluoride);
    }
}

class WaterQualityManager {
    private WaterSample[] samples = new WaterSample[10];
    private int count = 0;

    public void addSample(String stationId, String stationName, double temperature, double ph, double chloride, double fluoride) {
        if (count < samples.length) {
            samples[count++] = new WaterSample(stationId, stationName, temperature, ph, chloride, fluoride);
        } else {
            System.out.println("Reached maximum capacity");
        }
    }

    public void displaySamples() {
        System.out.printf("%-10s %-15s %-12s %-8s %-10s %-10s%n", "St No", "Station Name", "Temperature", "pH", "Chloride", "Fluoride");
        System.out.println("--------------------------------------------------------------------------");

        for (int i = 0; i < count; i++) {
            System.out.println(samples[i]);
        }
    }

    public void sortByChloride() {
        for (int i = 0; i < count - 1; i++) {
            for (int j = 0; j < count - i - 1; j++) {
                if (samples[j].getChloride() > samples[j + 1].getChloride()) {
                    WaterSample temp = samples[j];
                    samples[j] = samples[j + 1];
                    samples[j + 1] = temp;
                }
            }
        }
    }
}

public class WaterQualityApp {
    public static void main(String[] args) {
        WaterQualityManager manager = new WaterQualityManager();

        manager.addSample("s1", "RAMPALLI", 27.05, 7.20, 289.11, 1.22);
        manager.addSample("s2", "ETHUR", 27.62, 7.70, 286.31, 1.23);
        manager.addSample("s3", "EDAGAPLLI", 28.97, 7.89, 348.62, 0.81);
        manager.addSample("s4", "SUGALMITTA", 28.91, 8.02, 45.91, 0.82);
        manager.addSample("s5", "DANDUPALYAM", 28.75, 8.10, 40.64, 0.55);
        manager.addSample("s6", "MELAPATULA", 29.50, 7.40, 75.20, 1.71);
        manager.addSample("s7", "ARADIGUNTA", 29.82, 7.57, 80.50, 2.00);
        manager.addSample("s8", "BHEMIGANPALLI", 29.67, 8.40, 88.12, 1.96);
        manager.addSample("s9", "BANDLAPALLE", 28.70, 7.07, 156.01, 3.01);
        manager.addSample("s10", "MANGALAM", 28.96, 7.88, 124.98, 1.97);

        manager.sortByChloride();
        manager.displaySamples();
    }
}
