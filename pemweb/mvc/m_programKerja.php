<?php
require "koneksiMVC.php";

class m_programKerja {
    private $nomorProgram;
    private $namaProgram;
    private $suratKeterangan;
    public $hasil = array();

    public function __construct($nomorProgram = null, $namaProgram = null, $suratKeterangan = null) {
        $this->nomorProgram = $nomorProgram;
        $this->namaProgram = $namaProgram;
        $this->suratKeterangan = $suratKeterangan;
    }

    public function setProgramKerja($namaProgram, $suratKeterangan) {
        global $mysqli;
        $query = "INSERT INTO proker (namaProgram, suratKeterangan) VALUES ('$namaProgram', '$suratKeterangan')";
        $mysqli->query($query);
    }

    public function getSemuaProgramKerja() {
        global $mysqli;
        $query = "SELECT * FROM proker";
        $rs = $mysqli->query($query);
        $rows = array();

        while ($row = $rs->fetch_assoc()) {
            $rows[] = $row;
        }
        $this->hasil = $rows;
        return $this->hasil;
    }

    public function updateProgramKerja($nomorProgram, $namaProgram, $suratKeterangan) {
        global $mysqli;
        $query = "UPDATE proker SET namaProgram = '$namaProgram', suratKeterangan = '$suratKeterangan' WHERE nomorProgram = $nomorProgram";
        $mysqli->query($query);
    }

    public function deleteProgramKerja($nomorProgram) {
        global $mysqli;
        $query = "DELETE FROM proker WHERE nomorProgram = $nomorProgram";
        $mysqli->query($query);
    }
}
?>
