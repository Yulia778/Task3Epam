package by.minsk.epam.kozlova.task2.java.entity.builder.impl;

import java.util.Map;

public final class SpeakersBuilderImpl implements ApplianceBuilder<Speakers> {
    private Integer powerConsumption;
    private Integer numberOfSpeakers;
    private String frequencyRange;
    private Float cordLength;

    public SpeakersBuilderImpl() {
    }

    public static SpeakersBuilderImpl builder() {
        return new SpeakersBuilderImpl();
    }

    public SpeakersBuilderImpl powerConsumption(Integer powerConsumption) {
        this.powerConsumption = powerConsumption;
        return this;
    }

    public SpeakersBuilderImpl numberOfSpeakers(Integer numberOfSpeakers) {
        this.numberOfSpeakers = numberOfSpeakers;
        return this;
    }

    public SpeakersBuilderImpl frequencyRange(String frequencyRange) {
        this.frequencyRange = frequencyRange;
        return this;
    }

    public SpeakersBuilderImpl cordLength(Float cordLength) {
        this.cordLength = cordLength;
        return this;
    }

    @Override
    public SpeakersBuilderImpl properties(Map<String, Object> properties) {
        for (Map.Entry<String, Object> entry : properties.entrySet()) {
            switch (entry.getKey()) {
                case "POWER_CONSUMPTION":
                    powerConsumption = ValueParser.parseInteger(String.valueOf(entry.getValue()));
                    break;
                case "NUMBER_OF_SPEAKERS":
                    numberOfSpeakers = ValueParser.parseInteger(String.valueOf(entry.getValue()));
                    break;
                case "FREQUENCY_RANGE":
                    frequencyRange = String.valueOf(entry.getValue());
                    break;
                case "CORD_LENGTH":
                    cordLength = ValueParser.parseFloat(String.valueOf(entry.getValue()));
                    break;
            }
        }
        return this;
    }

    @Override
    public Speakers build() {
        Speakers speakers = new Speakers();
        speakers.setPowerConsumption(powerConsumption);
        speakers.setNumberOfSpeakers(numberOfSpeakers);
        speakers.setFrequencyRange(frequencyRange);
        speakers.setCordLength(cordLength);
        return speakers;
    }
}

