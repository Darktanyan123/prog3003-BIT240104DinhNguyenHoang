package Bai2;

public class Computer {

    private String HDD;
    private String RAM;
    private boolean bluetooth;

    private Computer(ComputerBuilder builder) {
        this.HDD = builder.HDD;
        this.RAM = builder.RAM;
        this.bluetooth = builder.bluetooth;
    }

    public void show() {
        System.out.println("HDD: " + HDD);
        System.out.println("RAM: " + RAM);
        System.out.println("Bluetooth: " + bluetooth);
        System.out.println();
    }

    public static class ComputerBuilder {

        private String HDD;
        private String RAM;
        private boolean bluetooth;

        public ComputerBuilder(String HDD, String RAM) {
            this.HDD = HDD;
            this.RAM = RAM;
        }

        public ComputerBuilder isBluetoothEnabled(boolean bluetooth) {
            this.bluetooth = bluetooth;
            return this;
        }

        public Computer build() { // tạo object
            return new Computer(this);
        }
    }
}