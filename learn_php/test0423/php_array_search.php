<?php



if (isset($_POST['number'])) {
    $number = $_POST['number'];

    $array = array("A01KA029", "A02KA032", "A03KA028", "A01KA029001", "A01KA029002", "A01KA029003", "A01KA029004", "A01KA029005", "A02KA032001", "A02KA032002", "A02KA032003", "A02KA032004", "A02KA032005", "A03KA028001", "A03KA028002", "A03KA028003", "A03KA028004", "A03KA028005");

   
    echo "找到的資料:<br> ";

    if ($result_array = preg_grep("/$number/", $array)) {
        foreach ($result_array as $k => $v) {
            echo $v . '<br>';
        }
    } else {
        echo "無找到";
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