<?php
session_start();
?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Data dari Session</title>
</head>
<body>
    <h2>Data dari Session</h2>
    <?php
    if (isset($_SESSION['data'])) {
        echo "<p>Angka: " . $_SESSION['data']['angka'] . "</p>";
        echo "<p>Nilai Faktorial: " . $_SESSION['data']['faktorial'] . "</p>";
        echo "<p>NIM: " . $_SESSION['data']['nim'] . "</p>";
        echo "<p>Nama: " . $_SESSION['data']['nama'] . "</p>";

        session_unset();
        session_destroy();
    } else {
        echo "<p>Data session tidak tersedia.</p>";
    }
    ?>
</body>
</html>
