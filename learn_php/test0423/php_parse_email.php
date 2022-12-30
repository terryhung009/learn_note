<?php


if (isset($_POST['email'])) {
    $email = $_POST['email'];
    $email = strstr($email,"@",true);
    echo $email;
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
        <h1>請輸入Email</h1>
        <input type="email" placeholder="請輸入Email" value="" name="email">
        <input type="submit" value="送出">
    </form>

</body>

</html>