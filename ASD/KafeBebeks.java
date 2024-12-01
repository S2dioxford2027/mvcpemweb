import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Pelanggan {
    String nama;
    int pesanan;

    Pelanggan(String nama, int pesanan) {
        this.nama = nama;
        this.pesanan = pesanan;
    }
}

public class KafeBebeks {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        sc.nextLine();

        Queue<Pelanggan> antrian = new LinkedList<>();
        
        for (int i = 0; i < n; i++) {
            String nama = sc.next();
            int pesanan = sc.nextInt();
            antrian.add(new Pelanggan(nama, pesanan));
        }

        Queue<String> selesai = new LinkedList<>();

        while (!antrian.isEmpty()) {
            Pelanggan current = antrian.poll();
            if (current.pesanan <= k) {
                selesai.add(current.nama);
            } else {
                current.pesanan -= k;
                antrian.add(current);
            }
        }

        while (!selesai.isEmpty()) {
            System.out.print(selesai.poll() + " ");
        }
    }
}
