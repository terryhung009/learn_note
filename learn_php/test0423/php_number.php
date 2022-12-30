<?php


if (isset($_POST['number'])) {
    $number = $_POST['number'];

    if (!preg_match("/(-?\d+)(\.\d+)?/", $_POST['number'])) {
        echo "<script>alert('請輸入數字');</script>";
    }else{
        echo "使用四捨五入後:" . round($number) . '<br>';

        echo "使用千分位表示法:" . number_format($number) . '<br>';
    }


}
?>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>

<body>
    <form action="" method="post">
        <h1>請輸入數字</h1>
        <input type="text" placeholder="請輸入數字" value="" name="number">
        <input type="submit" value="送出">
    </form>

</body>

</html>