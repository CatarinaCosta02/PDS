package e2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import thermoMVC.model.*;

public class FileDisplay implements ThermometerListener {

    private final Thermometer thermometer;
    private final String filePath;

    public FileDisplay(Thermometer t, String filePath) {
        this.thermometer = t;
        this.filePath = filePath;
    }

    @Override
    public void temperatureChanged() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
            writer.write("Temperature: " + thermometer.getTemperature());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
