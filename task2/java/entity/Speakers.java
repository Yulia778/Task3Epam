package by.minsk.epam.kozlova.task2.java.entity;

public class Speakers implements Appliance{


    private Integer powerConsumption;
    private Integer numberOfSpeakers;
    private String frequencyRange;
    private Float cordLength;

    public Integer getPowerConsumption() {
        return powerConsumption;
    }

    public void setPowerConsumption(Integer powerConsumption) {
        this.powerConsumption = powerConsumption;
    }

    public Integer getNumberOfSpeakers() {
        return numberOfSpeakers;
    }

    public void setNumberOfSpeakers(Integer numberOfSpeakers) {
        this.numberOfSpeakers = numberOfSpeakers;
    }

    public String getFrequencyRange() {
        return frequencyRange;
    }

    public void setFrequencyRange(String frequencyRange) {
        this.frequencyRange = frequencyRange;
    }

    public Float getCordLength() {
        return cordLength;
    }

    public void setCordLength(Float cordLength) {
        this.cordLength = cordLength;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Speakers speakers = (Speakers) o;

        if (powerConsumption != null ? !powerConsumption.equals(speakers.powerConsumption) : speakers.powerConsumption != null)
            return false;
        if (numberOfSpeakers != null ? !numberOfSpeakers.equals(speakers.numberOfSpeakers) : speakers.numberOfSpeakers != null)
            return false;
        if (frequencyRange != null ? !frequencyRange.equals(speakers.frequencyRange) : speakers.frequencyRange != null)
            return false;
        return cordLength != null ? cordLength.equals(speakers.cordLength) : speakers.cordLength == null;
    }

    @Override
    public int hashCode() {
        int result = powerConsumption != null ? powerConsumption.hashCode() : 0;
        result = 31 * result + (numberOfSpeakers != null ? numberOfSpeakers.hashCode() : 0);
        result = 31 * result + (frequencyRange != null ? frequencyRange.hashCode() : 0);
        result = 31 * result + (cordLength != null ? cordLength.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Speakers{" +
                "powerConsumption=" + powerConsumption +
                ", numberOfSpeakers=" + numberOfSpeakers +
                ", frequencyRange='" + frequencyRange + '\'' +
                ", cordLength=" + cordLength +
                '}';
    }
}
