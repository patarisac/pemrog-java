import java.util.Scanner;

class Shape {
    protected String color;
    protected double area;

    public Shape() {
    }
    public String getColor() {
        return color;
    }
    public double getArea() {
        return area;
    }
    public void print() {
        System.out.println("Color:" + color);
    }
}

class Rectangle extends Shape {
    protected double width;
    protected double height;

    public Rectangle(double b, double c) {
        // super(a);
        width = b;
        height = c;
        countArea();
    }
    public double getWidth() {
        return width;
    }
    public double getHeight() {
        return height;
    }
    public void print() {
        super.print();
        System.out.printf("W:%.2f H:%.2f\n", width, height);
    }
    private void countArea() {
        area = 2 * (width + height);
    }
}

class Circle extends Shape {
    protected double radius;

    public Circle(double r) {
        // super(a);
        radius = r;
        countArea();
    }

    public double getRadius() {
        return radius;
    }

    public void print() {
        super.print();
        System.out.printf("R:%.2f\n", radius);
    }
    private void countArea() {
        area = 2 * Math.PI * radius;
    }
}

public class DriverShape {
    public static void main(String[] args) {
        int N, op;
        Rectangle ppanjang[] = new Rectangle[100];
        Circle lingkaran[] = new Circle[100];
        int np = 0;
        int nl = 0;
        double rerata = 0.0;
        double total = 0.0;
        String baris[] = new String[3];
        Scanner inp = new Scanner(System.in);

        N = inp.nextInt();
        inp.nextLine();
        for(int i = 0; i < N; i++) {
            baris = inp.nextLine().split(" ");
            // System.out.println(baris[0]);
            op = Integer.parseInt(baris[0]);
            double b = Double.parseDouble(baris[1]);
            if(op == 0) {
                double c = Double.parseDouble(baris[2]);
                ppanjang[np] = new Rectangle(b, c);
                rerata += ppanjang[np++].getArea();
            } else
            if(op == 1) {
                lingkaran[nl] = new Circle(b);
                rerata += lingkaran[nl++].getArea();
            }
        }
        inp.close();
        rerata /= N;
        for(int i = 0; i < np; i++) {
            if(ppanjang[i].getArea() > rerata) {
                total += ppanjang[i].getArea();
            }
        }
        for(int i = 0; i < nl; i++) {
            if(lingkaran[i].getArea() > rerata) {
                total += lingkaran[i].getArea();
            }
        }
        System.out.printf("%.2f\n",total);
    }
}
