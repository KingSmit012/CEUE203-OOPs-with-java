abstract class Shape {
    abstract double Area();
}
 
class Circle extends Shape {
    double radius;
    Circle(double radius) {
        this.radius = radius;
    }
    double Area() {
        return (Math.PI * radius * radius);
    }
}
 
class Rectangle extends Shape {
    double length;
    double breadth;
    Rectangle(double length, double breadth) {
        this.length = length;
        this.breadth = breadth;
    }
    double Area() {
        return (length * breadth);
    }
}
 
class Triangle extends Shape {
    double base;
    double height;
    Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }
    double Area() {
        return (0.5 * base * height);
    }
}
 
public class ShapeArea {
    public static void main(String[] args) {
        Shape[] s = {
            new Circle(7),
            new Rectangle(6, 8),
            new Triangle(7, 22)
        };
        double TotalArea = 0;
        for(Shape SP : s){
            System.out.println("The Area of " + SP + " : " +SP.Area());
            TotalArea += SP.Area();
        }
        System.out.println("Total Area :- " + TotalArea);
 
    }
}