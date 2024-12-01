<?php
session_start();
session_destroy(); 
header("Location: lat6_login.php"); 
exit();
?>
