import java.util.Scanner;

class Tanaman {
    public Tanaman(double lahan, double ku, int kp){
        s = 0; p = 0; totalPupuk = 0;
        konstUrea = ku; konstPanen = kp; m = lahan;
    }
    protected double m; // luas lahan
    protected double s; // tingkat kesuburan
    protected double p; // banyak panen
    protected int totalPupuk;
    protected double konstUrea; // konstanta urea
    protected int konstPanen; // konstanta panen
    
    // beri pupuk urea only
    public void beriPupuk(String[] in){
        int u = Integer.parseInt(in[0]);
        s += konstUrea * u;
        totalPupuk++;
        if(totalPupuk == 3) {
            hitungHasil();
        }
    }

    protected void hitungHasil() {
        p = s * m / konstPanen;
    }

    public double getHasil() {
        return p;
    }
}

class Kentang extends Tanaman {
    public Kentang(double lahan) {
        super(lahan,0.75,100);
    }
}

class Wortel extends Tanaman {
    private double konstNPK = 0.75; // konstanta NPK
    public Wortel(double lahan) {
        super(lahan,0.50,200);
    }

    public void beriPupuk(String[] in) {
        // beri pupuk NPK
        int k = Integer.parseInt(in[1]); 
        s += k * konstNPK;
        // beri pupuk urea
        super.beriPupuk(in);
    }
}

public class TanamDriver {
    public static void main(String[] args) {
        int N;
        double lahan;
        Tanaman semua[] = new Tanaman[1000];
        double totalK = 0;
        double totalW = 0;
        Scanner inp = new Scanner(System.in);
        String baris[] = new String[2];
        baris = inp.nextLine().split(" ");
        N = Integer.parseInt(baris[0]);
        lahan = Double.parseDouble(baris[1]);
        for(int i=0; i < N; i++) {
            if(i % 2 == 0)
                semua[i] = new Kentang(lahan);
            else
                semua[i] = new Wortel(lahan);
            
            for(int j=0; j < 3; j++) {
                baris = inp.nextLine().split(" ");
                semua[i].beriPupuk(baris);
            }
            if(i % 2 == 0)
                totalK += semua[i].getHasil();
            else
                totalW += semua[i].getHasil();
        }
        System.out.printf("Kentang: %.2f kg Wortel: %.2f kg\n", totalK, totalW);

        inp.close();

    }
}
