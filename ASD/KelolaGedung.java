import java.util.*;

class Gedung {
    LinkedList<Character> lantai;  
    int posisi;

    public Gedung() {
        lantai = new LinkedList<>();
        posisi = 0;
    }

    public void tambahLantai(char simbol) {
        lantai.add(posisi, simbol); 
        posisi++;
    }

    public Character hapusLantai() {
        if (!lantai.isEmpty() && posisi > 0) {
            posisi--;
            return lantai.remove(posisi);  
        }
        return null;
    }

    public Character pindahLift(String arah) {
        if (arah.equals("ATAS") && posisi < lantai.size()) {
            posisi++;
        } else if (arah.equals("BAWAH") && posisi > 0) {
            posisi--;
        }
        return posisi > 0 ? lantai.get(posisi - 1) : null;  
    }

    public String tampilLantai() {
        StringBuilder sketsa = new StringBuilder();
        for (Character l : lantai) {
            sketsa.append(l);
        }
        return sketsa.toString();
    }

    public void gabungGedung(Gedung lain) {
        this.lantai.addAll(lain.lantai);
    }
}

public class KelolaGedung {
    private static final Map<String, Gedung> petaGedung = new HashMap<>();

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int jumlahPerintah = input.nextInt();
        input.nextLine();

        List<String> hasil = new ArrayList<>();

        for (int i = 0; i < jumlahPerintah; i++) {
            String[] bagian = input.nextLine().split(" ");
            String perintah = bagian[0];
            String namaGedung = bagian[1];

            switch (perintah) {
                case "FONDASI":
                    petaGedung.put(namaGedung, new Gedung());
                    break;

                case "BANGUN":
                    char simbolLantai = bagian[2].charAt(0);
                    petaGedung.get(namaGedung).tambahLantai(simbolLantai);
                    break;

                case "HANCURKAN":
                    Character hapus = petaGedung.get(namaGedung).hapusLantai();
                    if (hapus != null) {
                        hasil.add(String.valueOf(hapus));
                    }
                    break;

                case "LIFT":
                    Character pindah = petaGedung.get(namaGedung).pindahLift(bagian[2]);
                    if (pindah != null) {
                        hasil.add(String.valueOf(pindah));
                    }
                    break;

                case "SKETSA":
                    String sketsa = petaGedung.get(namaGedung).tampilLantai();
                    hasil.add(sketsa);
                    break;

                case "TIMPA":
                    String namaGedungKedua = bagian[2];
                    petaGedung.get(namaGedung).gabungGedung(petaGedung.get(namaGedungKedua));
                    petaGedung.remove(namaGedungKedua);
                    break;
            }
        }
        input.close();

        for (String output : hasil) {
            System.out.println(output);
        }
    }
}
