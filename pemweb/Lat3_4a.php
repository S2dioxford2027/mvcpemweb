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
    <title>Order Form</title>
</head>
<body>
    <h2>Selamat datang, <?php echo $_SESSION['user']; ?>!</h2>
    <a href="lat6_logout.php">Logout</a>
    <form action="lat3_4b.php" method="post">
        <p>Order CD, amount:</p>
        <input type="text" name="cd_order" value="<?php echo isset($_COOKIE['cd_order']) ? $_COOKIE['cd_order'] : '0'; ?>" size="2" maxlength="2">
        
        <p>Order DVD, amount:</p>
        <input type="text" name="dvd_order" value="<?php echo isset($_COOKIE['dvd_order']) ? $_COOKIE['dvd_order'] : '0'; ?>" size="2" maxlength="2">
        
        <input type="submit" value="Add To Cart" name="submit">
    </form>
</body>
</html>
