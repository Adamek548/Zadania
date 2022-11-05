package hello;

import hello.Calculator;

class Main {
    public static void main(String[] args) {
		Calculator calculator = new Calculator();
        System.out.println("Addition result is: " + calculator.add(1,2));
    }
}
