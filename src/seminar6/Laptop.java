package seminar6;

public class Laptop {
    private Integer ram;
    private Integer hdd;
    private String operatingSystem;
    private String color;
    public Laptop(Integer ram, Integer hdd, String operatingSystem, String color){
        this.ram = ram;
        this.hdd = hdd;
        this.operatingSystem = operatingSystem;
        this.color = color;
    }

    @Override
    public String toString() {
        return "ОЗУ: " + ram + " Гб" + "\n" + "Объем HDD: " + hdd + " Мб" + "\n" + "ОС: " + operatingSystem + "\n" +
                "Цвет: " + color + "\n";
    }

    public int getRam() {
        return ram;
    }

    public int getHdd() {
        return hdd;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public String getColor() {
        return color;
    }
}
