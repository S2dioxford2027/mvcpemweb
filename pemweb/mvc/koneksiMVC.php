<?php
$mysqli = new mysqli('root', 'root', '', 'localhost2');

if ($mysqli->connect_error) {
    die("Koneksi gagal: " . $mysqli->connect_error);
}
?>
