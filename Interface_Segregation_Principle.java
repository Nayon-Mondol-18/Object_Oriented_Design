//*************************************************************************
// Title : A java programme to demonstrate Interface Segregation Principle.
// Author : Nayon Mondol, Undergrduate student, Khulna University.
//*************************************************************************

import java.util.ArrayList;
import java.util.List;

// Interface representing the ability to fly
interface Flyable {
    void fly();
}

// Interface representing the ability to swim
interface Swimmable {
    void swim();
}

// Interface representing the ability to walk
interface Walkable {
    void walk();
}

// Class representing a Bird that can fly and walk
class Bird implements Flyable, Walkable {
    @Override
    public void fly() {
        System.out.println("Bird is flying.");
    }

    @Override
    public void walk() {
        System.out.println("Bird is walking.");
    }
}

// Class representing a Fish that can swim
class Fish implements Swimmable {
    @Override
    public void swim() {
        System.out.println("Fish is swimming.");
    }
}

// Demo class demonstrating the usage of animals and the Interface Segregation Principle
public class Interface_Segregation_Principle {
    public static void main(String[] args) {
        // Create a list of animals
        List<Object> animals = new ArrayList<>();
        animals.add(new Bird());
        animals.add(new Fish());

        // Perform actions on each animal
        for (Object animal : animals) {
            if (animal instanceof Flyable) {
                ((Flyable) animal).fly();
            }
            if (animal instanceof Swimmable) {
                ((Swimmable) animal).swim();
            }
            if (animal instanceof Walkable) {
                ((Walkable) animal).walk();
            }
            System.out.println();
        }
    }
}

/**
 * In the above programme there are three interfaces for specific tasks like
 * flying, swimming and walking instead of a fat interface containing all 
 * the three tasks. As a result the bird class can implement specific interfaces
 * like Flyable and Walkable and simillarly the fish class can use the specific
 * Swimmable class.
 */