package controllers;

public enum Test {
    MONDAY(2, "Thu hai"), TUESDAY(3, "Thu ba");
    int number;
    String name;

    private Test(int num, String name) {
        this.number = num;
        this.name = name;
    }

    public static void main(String[] args) {

    }
}
