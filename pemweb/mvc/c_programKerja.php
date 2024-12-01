<?php
include_once("m_programKerja.php");

class c_programKerja {
    public $model;

    public function __construct($nama = null) {
        $this->model = new m_programKerja();
    }

    public function invoke() {
        if (isset($_GET['action'])) {
            $action = $_GET['action'];

            if ($action == 'update' && isset($_GET['nomorProgram'])) {
                $nomorProgram = $_GET['nomorProgram'];

                if ($_SERVER['REQUEST_METHOD'] == 'POST') {
                    $namaProgram = $_POST['namaProgram'];
                    $suratKeterangan = $_POST['suratKeterangan'];
                    $this->model->updateProgramKerja($nomorProgram, $namaProgram, $suratKeterangan);
                } else {
                    $proker = $this->model->getSemuaProgramKerja();
                    $programToUpdate = null;
                    foreach ($proker as $row) {
                        if ($row['nomorProgram'] == $nomorProgram) {
                            $programToUpdate = $row;
                            break;
                        }
                    }
                    include 'v_programKerja.php';
                    return;
                }
            }

            if ($action == 'delete' && isset($_GET['nomorProgram'])) {
                $nomorProgram = $_GET['nomorProgram'];
                $this->model->deleteProgramKerja($nomorProgram);
            }

            if ($action == 'create' && $_SERVER['REQUEST_METHOD'] == 'POST') {
                $namaProgram = $_POST['namaProgram'];
                $suratKeterangan = $_POST['suratKeterangan'];
                $this->model->setProgramKerja($namaProgram, $suratKeterangan);
            }
        }

        $proker = $this->model->getSemuaProgramKerja();
        include 'v_programKerja.php';
    }
}
?>
