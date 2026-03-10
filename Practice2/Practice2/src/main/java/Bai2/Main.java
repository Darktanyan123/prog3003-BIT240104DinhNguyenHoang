package Bai2;

public class Main {
    public static void main(String[] args) {

        Computer computer1 = new Computer.ComputerBuilder("1TB", "16GB")
                .isBluetoothEnabled(true)
                .build();

        Computer computer2 = new Computer.ComputerBuilder("500GB", "8GB")
                .build();

        computer1.show();
        computer2.show();
    }
}