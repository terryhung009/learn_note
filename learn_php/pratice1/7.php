<?php

$number = $_POST->mount;
$discount = $_POST->$discount;

if ($number >= 1) {
    $total = 2000 * $number * $discount;
    echo $total;
}

if ($number >= 3) {
    $total = 2000 * $number * $discount;
    echo $total;
}

?>

使用技術：php

使用superglobal變數$_POST抓$_POST->mount
=>如果$_POST->mount大於等於1
=>總金額= 2000*$_POST->mount *0.8
=>echo $總金額

=>如果$_POST->mount大於等於3
=>總金額= 2000*$_POST->mount *0.7
=>echo $總金額