<?php

setcookie("username", "admin", time() + 30);
echo $_COOKIE['username'];

?>