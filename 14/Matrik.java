import java.util.Scanner;

class Objek {
    private int row, col;
    private int el[][] = new int[100][100];

    Objek(int i, int j) {
        row = i; col = j;
    }

    public void insert_elemen(int i, int j, int n) {
        if(i < row && j < col)
            el[i][j] = n;
    }

    public int get_elemen(int x, int y) {
        return el[x][y];
    }
}

public class Matrik {
    public static void main(String[] args) {
        int m,n,c;
        double rataan = 0.0;
        Scanner inp = new Scanner(System.in);
        m = inp.nextInt();
        n = inp.nextInt();
        Objek matrik = new Objek(m,n);

        String baris[];
        inp.nextLine();
        for(int i = 0; i < m; i++) {
            baris = inp.nextLine().split(" ");
            for(int j = 0; j < n; j++) {
                matrik.insert_elemen(i, j, Integer.parseInt(baris[j]));
            }
        }

        c = inp.nextInt();
        int a,b;
        for(int i = 0; i < c; i++) {
            a = inp.nextInt();
            b = inp.nextInt();
            rataan += matrik.get_elemen(a-1, b-1);
        }
        inp.close();
        rataan /= c;

        System.out.printf("%.2f\n", rataan);
    }
}
