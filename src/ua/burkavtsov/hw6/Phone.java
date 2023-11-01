package ua.burkavtsov.hw6;

public class Phone {
    private String number;
    private String model;
    private double weight;

    public Phone(String number, String model, double weight) {
        this.number = number;
        this.model = model;
        this.weight = weight;
    }

    public Phone(String number, String model) {
        this.number = number;
        this.model = model;
        this.weight = 0.0;
    }

    public Phone() {
        this.number = "";
        this.model = "";
        this.weight = 0.0;
    }

    public void receiveCall(String name) {
        System.out.println("Звонит " + name);
    }

    public String getNumber() {
        return number;
    }

    public static void main(String[] args) {
        ua.burkavtsov.hw6.Phone phone1 = new ua.burkavtsov.hw6.Phone("123-456-789", "Motorola", 150.5);
        ua.burkavtsov.hw6.Phone phone2 = new ua.burkavtsov.hw6.Phone("987-654-321", "iPhone");
        ua.burkavtsov.hw6.Phone phone3 = new ua.burkavtsov.hw6.Phone();

        phone1.receiveCall("The");
        System.out.println("Phone 1 number: " + phone1.getNumber());

        phone2.receiveCall("Bob");
        System.out.println("Phone 2 number: " + phone2.getNumber());

        phone3.receiveCall("Marley");
        System.out.println("Phone 3 number: " + phone3.getNumber());
    }
}
