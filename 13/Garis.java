import java.util.Scanner;

class Objek {
    // <instanceVariable>*
    private double x1, x2, y1, y2, jarak;
    // <constructorMethod>*
    Objek(double a, double b, double c, double d) {
        x1 = a; y1 = b; x2 = c; y2 = d;
        jarak = Math.sqrt((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2));
    }
    public double panjang() {
        return jarak;
    }
}

public class Garis {
    public static void main(String[] args) {
        Objek garis[] = new Objek[100];
        double rataan = 0.0;
        int n, count = 0;
        Scanner inp = new Scanner(System.in);
        n = inp.nextInt();
        for(int i = 0; i < n; i++) {
            double x1,y1,x2,y2;
            x1 = inp.nextDouble();
            y1 = inp.nextDouble();
            x2 = inp.nextDouble();
            y2 = inp.nextDouble();
            garis[i] = new Objek(x1,y1,x2,y2);
            rataan += garis[i].panjang();
        }
        inp.close();
        rataan /= n;
        for(int i = 0; i < n; i++) {
            if(garis[i].panjang() <= rataan)
                count++;
        }
        System.out.printf("%.2f %d\n", rataan, count);
    }
}