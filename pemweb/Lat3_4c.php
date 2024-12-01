<?php
session_start();
if (!isset($_SESSION['user'])) {
    header("Location: lat6_login.php");
    exit();
}
?>

<!DOCTYPE html>
<html>
<head>
    <title>Order Summary</title>
</head>
<body>
    <h2>Order Summary for <?php echo $_SESSION['user']; ?></h2>
    <?php
    $num_cd_order = $_COOKIE['cd_order'];
    $num_dvd_order = $_COOKIE['dvd_order'];

    echo "Ordered CD: " . $num_cd_order . " pieces<br>";
    echo "Ordered DVD: " . $num_dvd_order . " pieces<br>";
    ?>
    <a href="lat6_logout.php">Logout</a>
</body>
</html>
