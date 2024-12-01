<?php
include "menteri.php";

$menteri1 = new menteri("Atha Azzahra", "Menteri TI");

$menteri1->setNim("235150701111048");
$menteri1->setAngkatan(2021);
$menteri1->setFoto("atha.jpg");

$menteri1->tampilkanInfo();
?>
