package com.mthree.vendingmachine;


import com.mthree.vendingmachine.controller.VendingMachineController;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("com.mthree.vendingmachine");
        context.refresh();
        VendingMachineController controller = context.getBean("vendingMachineController", VendingMachineController.class);
        controller.run();

    }
}
