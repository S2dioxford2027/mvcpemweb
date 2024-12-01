<?php
include "pengurusBEM.php";

class menteri extends pengurusBEM {

    public function __construct($nama, $jabatan) {
        $this->setNama($nama);
        $this->setJabatan($jabatan); // Set jabatan menggunakan setter
    }

    public function tampilkanInfo() {
        echo "Nama: " . $this->getNama() . "<br>";
        echo "NIM: " . $this->getNim() . "<br>";
        echo "Angkatan: " . $this->getAngkatan() . "<br>";
        echo "Jabatan: " . $this->getJabatan() . "<br>"; // Mengakses jabatan dengan getJabatan()
        echo "Foto: " . $this->getFoto() . "<br>";
    }
}
?>
