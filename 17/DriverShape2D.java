import java.util.Scanner;

interface Shape2D {
    public void set();
    public void print();
    public void keliling();
}

class Poligon implements Shape2D {
    protected int N;
    protected double titik[][] = new double[100][2];
    protected double k; // keliling

    public Poligon() {
        k = 0;
        set();
        keliling();
    }

    public void set() {
        Scanner inp = new Scanner(System.in);
        String baris[] = new String[2];
        N = inp.nextInt();
        inp.nextLine();
        for(int i = 0; i < N; i++) {
            baris = inp.nextLine().split(" ");
            // System.out.println(baris[0]);
            // System.out.println(baris[1]);
            titik[i][0] = Double.parseDouble(baris[0]);
            titik[i][1] = Double.parseDouble(baris[1]);
        }
        inp.close();
    }

    public void keliling() {
        for(int i = 0; i < N; i++) {
            k += hitungJarak(titik[i], titik[(i+1)%N]);
        }
    }

    protected double hitungJarak(double a[], double b[]) {
        double x = (a[0]-b[0]) * (a[0]-b[0]);
        double y = (a[1]-b[1]) * (a[1]-b[1]);
        return Math.sqrt(x+y);
    }

    public void print() {
        System.out.printf("[%.2f,%.2f]-[%.2f,%.2f]\n", titik[0][0], titik[0][1], titik[N-1][0], titik[N-1][1]);
        System.out.printf("%.2f\n", k);
    }
}

public class DriverShape2D {
    public static void main(String[] args) {
        Poligon obj = new Poligon();
        obj.print();
    }
}