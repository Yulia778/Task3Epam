package by.minsk.epam.kozlova.task2.java.entity.builder.impl;
import java.util.Map;

public final class TabletPCBuilderImpl implements ApplianceBuilder<TabletPC> {
    private Integer batteryCapacity;
    private String displayInches;
    private Integer memoryRom;
    private Integer flashMemoryCapacity;
    private String color;

    public TabletPCBuilderImpl() {
    }

    public static TabletPCBuilderImpl builder() {
        return new TabletPCBuilderImpl();
    }

    public TabletPCBuilderImpl batteryCapacity(Integer batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
        return this;
    }

    public TabletPCBuilderImpl displayInches(String displayInches) {
        this.displayInches = displayInches;
        return this;
    }

    public TabletPCBuilderImpl memoryRom(Integer memoryRom) {
        this.memoryRom = memoryRom;
        return this;
    }

    public TabletPCBuilderImpl flashMemoryCapacity(Integer flashMemoryCapacity) {
        this.flashMemoryCapacity = flashMemoryCapacity;
        return this;
    }

    public TabletPCBuilderImpl color(String color) {
        this.color = color;
        return this;
    }

    @Override
    public TabletPCBuilderImpl properties(Map<String, Object> properties) {
        for (Map.Entry<String, Object> entry : properties.entrySet()) {
            switch (entry.getKey()) {
                case "BATTERY_CAPACITY":
                    batteryCapacity = ValueParser.parseInteger(String.valueOf(entry.getValue()));
                    break;
                case "DISPLAY_INCHES":
                    displayInches = String.valueOf(entry.getValue());
                    break;
                case "MEMORY_ROM":
                    memoryRom = ValueParser.parseInteger(String.valueOf(entry.getValue()));
                    break;
                case "FLASH_MEMORY_CAPACITY":
                    flashMemoryCapacity = ValueParser.parseInteger(String.valueOf(entry.getValue()));
                    break;
                case "COLOR":
                    color = String.valueOf(entry.getValue());
                    break;
            }
        }
        return this;
    }

    @Override
    public TabletPC build() {
        TabletPC tabletPC = new TabletPC();
        tabletPC.setBatteryCapacity(batteryCapacity);
        tabletPC.setDisplayInches(displayInches);
        tabletPC.setMemoryRom(memoryRom);
        tabletPC.setFlashMemoryCapacity(flashMemoryCapacity);
        tabletPC.setColor(color);
        return tabletPC;
    }
}
