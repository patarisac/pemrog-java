import java.util.Scanner;

interface AritmatikaDasar {
    public double tambah(double a, double b);
    public double kurang(double a, double b);
    public double kali(double a, double b);
    public double bagi(double a, double b);
}

interface AritmatikaLanjut {
    public double akarKuadrat(double a);
    public double pangkat(double a, double b);
}

interface KalkulatorSaintifik extends AritmatikaDasar, AritmatikaLanjut {
    public void clear();
}

class Kalkulator implements KalkulatorSaintifik {
    public double currentValue;

    public Kalkulator() { currentValue = 0.0; }

    public double tambah(double a, double b) {
        currentValue = a + b;
        return currentValue;
    }
    public double kurang(double a, double b) {
        currentValue = a - b;
        return currentValue;
    }
    public double kali(double a, double b) {
        currentValue = a * b;
        return currentValue;
    }
    public double bagi(double a, double b) {
        currentValue = a / b;
        return currentValue;
    }
    public double akarKuadrat(double a) {
        currentValue = Math.sqrt(a);
        return currentValue;
    }
    public double pangkat(double a, double b) {
        currentValue = Math.pow(a,b);
        return currentValue;
    }
    public void clear() {
        currentValue = 0.0;
    }
    public double getValue() {
        return currentValue;
    }
}

public class DriverKalkulator {
    public static void main(String[] args) {
        Kalkulator calc = new Kalkulator();
        char op = ' ';
        double x=0.0;
        Scanner inp = new Scanner(System.in);
        String baris[] = new String[2];
        while(op != '~') {
            baris = inp.nextLine().split(" ");
            op = baris[0].charAt(0);
            if(op != 'C' && op != '~') {
                x = Integer.parseInt(baris[1]);
            }
            switch (op) {
                case '+':
                    calc.tambah(calc.getValue(), x);
                    break;
                case '-':
                    calc.kurang(calc.getValue(), x);
                    break;
                case '*':
                    calc.kali(calc.getValue(), x);
                    break;
                case '/':
                    calc.bagi(calc.getValue(), x);
                    break;
                case '^':
                    calc.pangkat(calc.getValue(), x);
                    break;            
                case '#':
                    calc.akarKuadrat(calc.getValue());
                    break;
                case 'C':
                    calc.clear();
                    break;
                default:
                    break;
            }
            if(op != '~')
                System.out.printf("%.2f\n",calc.getValue());
        }
        inp.close();
    }
}
