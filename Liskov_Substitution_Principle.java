//***********************************************************************
// Title : A java programme to demonstrate Liskov Substitution Principle.
// Author : Nayon Mondol, Undergrduate student, Khulna University.
//***********************************************************************

import java.util.ArrayList;
import java.util.List;
/**
 * Interface representing a geometric shape.
 */
interface Shape {
    /**
     * Calculates the area of the shape.
     *
     * @return The area of the shape.
     */
    double calculateArea();
}

/**
 * Class representing a rectangle.
 */
class Rectangle implements Shape {
    private double width;
    private double height;

    /**
     * Constructs a new Rectangle object with the given width and height.
     *
     * @param width  The width of the rectangle.
     * @param height The height of the rectangle.
     */
    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return width * height;
    }
}

/**
 * Class representing a square, which is a special case of a rectangle.
 */
class Square implements Shape {
    private double side;

    /**
     * Constructs a new Square object with the given side length.
     *
     * @param side The side length of the square.
     */
    public Square(double side) {
        this.side = side;
    }

    @Override
    public double calculateArea() {
        return side * side;
    }
}

/**
 * Demo class demonstrating the usage of shapes and the Liskov Substitution Principle.
 */
class Liskov_Substitution_Principle {
    /**
     * Calculates the total area of shapes and prints it.
     *
     * @param shapes The list of shapes.
     */
    public static void calculateTotalArea(List<Shape> shapes) {
        double totalArea = 0;
        for (Shape shape : shapes) {
            totalArea += shape.calculateArea();
        }
        System.out.println("Total area of shapes: " + totalArea);
    }

    public static void main(String[] args) {
        // Create a list of shapes
        List<Shape> shapes = new ArrayList<>();
        shapes.add(new Rectangle(5, 4));
        shapes.add(new Square(3));

        // Calculate and print the total area of shapes
        calculateTotalArea(shapes);
    }
}

/**
 * The Square class is a subtype of Rectangle, and we can substitute
 * a Square object for a Rectangle object without affecting the correctness
 * of the program. This adheres to the Liskov Substitution Principle.
 */