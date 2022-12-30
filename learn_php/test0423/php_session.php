<?php

ini_set('session.gc_maxlifetime', 10800);
echo "session過期時間:" . ini_get("session.gc_maxlifetime") . "<br>";

session_start();



?>



<!DOCTYPE html>
<html>

<body>

    <?php
    //第3題

    date_default_timezone_set("Asia/Taipei");
    echo "明天: ". date('Y-m-d H:i:s', strtotime('+1 day')) . "<br>";
    echo "下個月: " . date('Y-m-d H:i:s', strtotime('+1 month')) . "<br>";
    echo "下一年: " . date('Y-m-d H:i:s', strtotime('+1 year')) . "<br>";


    //第3題

    //第2題
    $time = time();
   
    $time = date("Y-m-d H:i:s", $time);
    
    $_SESSION["time"] = $time;

    $codeTime= $_SESSION["codeTime"];

    $codeTime[] = $_SESSION["time"];
    
    $_SESSION["codeTime"] = $codeTime;

    echo'<pre>';
    var_dump($codeTime);
    echo '</pre>';

    echo "現在時間: " . $_SESSION["time"];



    //第2題
    ?>

</body>

</html>