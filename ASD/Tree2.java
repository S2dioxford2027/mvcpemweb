import java.util.ArrayList;

class Tree2 {
    String name;
    ArrayList<Tree2> subUnits;

    public Tree2(String name) {
        this.name = name;
        this.subUnits = new ArrayList<>();
    }

    public void addSubUnit(Tree2 unit) {
        subUnits.add(unit);
    }

    public void printStructure(String indent) {
        System.out.println(indent + name);
        for (Tree2 subUnit : subUnits) {
            subUnit.printStructure(indent + "  ");
        }
    }

    public static void main(String[] args) {
        Tree2 dekan = new Tree2("Dekan");

        Tree2 wdAkademik = new Tree2("Wakil Dekan Bidang Akademik");
        Tree2 wdUmumKeuangan = new Tree2("Wakil Dekan Bidang Umum, Keuangan, dan Sumber Daya");
        Tree2 wdKemahasiswaan = new Tree2("Wakil Dekan Bidang Kemahasiswaan, Alumni, dan Kewirausahaan Mahasiswa");

        dekan.addSubUnit(wdAkademik);
        dekan.addSubUnit(wdUmumKeuangan);
        dekan.addSubUnit(wdKemahasiswaan);

        Tree2 saf = new Tree2("SAF");
        Tree2 komisi = new Tree2("Komisi");
        dekan.addSubUnit(saf);
        dekan.addSubUnit(komisi);

        wdAkademik.addSubUnit(new Tree2("Laboratorium"));
        wdAkademik.addSubUnit(new Tree2("BPPM"));
        wdAkademik.addSubUnit(new Tree2("PSIK"));

        wdUmumKeuangan.addSubUnit(new Tree2("BPJ"));
        Tree2 tataUsaha = new Tree2("Bagian Tata Usaha");
        wdUmumKeuangan.addSubUnit(tataUsaha);
        tataUsaha.addSubUnit(new Tree2("Subbagian Akademik, Kemahasiswaan, Alumni, Kerjasama, dan Kewirausahaan Mahasiswa"));
        tataUsaha.addSubUnit(new Tree2("Subbagian Umum dan Aset"));
        tataUsaha.addSubUnit(new Tree2("Subbagian Keuangan dan Kepegawaian"));

        wdKemahasiswaan.addSubUnit(new Tree2("GJM"));
        wdKemahasiswaan.addSubUnit(new Tree2("IRO"));
        wdKemahasiswaan.addSubUnit(new Tree2("UPKP"));
        wdKemahasiswaan.addSubUnit(new Tree2("UPMD"));
        wdKemahasiswaan.addSubUnit(new Tree2("UKLTKSP"));

        Tree2 dti = new Tree2("Departemen Teknik Informatika");
        wdAkademik.addSubUnit(dti);
        dti.addSubUnit(new Tree2("Sekretaris Departemen"));
        dti.addSubUnit(new Tree2("Prodi Sarjana Teknik Informatika"));
        dti.addSubUnit(new Tree2("Prodi Sarjana Teknik Komputer"));
        dti.addSubUnit(new Tree2("Prodi Magister Ilmu Komputer"));
        dti.addSubUnit(new Tree2("UJM"));

        Tree2 dsi = new Tree2("Departemen Sistem Informasi");
        wdAkademik.addSubUnit(dsi);
        dsi.addSubUnit(new Tree2("Sekretaris Departemen"));
        dsi.addSubUnit(new Tree2("Prodi Sarjana Sistem Informasi"));
        dsi.addSubUnit(new Tree2("Prodi Sarjana Pendidikan Teknologi Informasi"));
        dsi.addSubUnit(new Tree2("Prodi Sarjana Teknologi Informasi"));
        dsi.addSubUnit(new Tree2("UJM"));

        dekan.printStructure("");
    }
}
