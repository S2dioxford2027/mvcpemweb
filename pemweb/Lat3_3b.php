<?php
session_start();

function hitungFaktorial($angka) {
    if ($angka == 0) {
        return 1;
    } else {
        return $angka * hitungFaktorial($angka - 1);
    }
}

if (isset($_POST['angka'])) {
    $angka = $_POST['angka'];

    $faktorial = hitungFaktorial($angka);

    $data = array(
        'angka' => $angka,
        'faktorial' => $faktorial,
        'nim' => '235150701111048', 
        'nama' => 'Atha Azzahra Khairun Nisa' 
    );

    $_SESSION['data'] = $data;
} else {
    echo "Tidak ada angka yang dimasukkan.";
    exit;
}
?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Hasil Faktorial</title>
</head>
<body>
    <h2>Hasil Perhitungan Faktorial</h2>
    <p>Angka yang dimasukkan: <?php echo $angka; ?></p>
    <p>Nilai faktorial: <?php echo $faktorial; ?></p>

    <a href="Lat3_3c.php">Lihat Data di Session</a>
</body>
</html>
