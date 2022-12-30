<?php

// $area = "嘉義' or '%' = '";
$area = "嘉義";



header('Content-type:text/html;charset=utf8');
$dsn = 'mysql:host=localhost;port=3306;dbname=animal_laravel8';

$pdo = new PDO($dsn, 'WebAdmin', '123456');
// echo $pdo->errorCode() . '<br/>';
$pdo->query("SET NAMES 'utf8'");


// print_r($pdo->errorInfo());
// \n;

// $sql = "SELECT * FROM animals WHERE area LIKE '%{$area}%' LIMIT 10";
$sql = "SELECT * FROM animals WHERE area LIKE :area LIMIT 10";

// $query = $pdo->query($sql);
// $query->setFetchMode(PDO::FETCH_ASSOC);


$statment = $pdo->prepare($sql);
$statment->bindValue(':area',"%{$area}%");
$statment->execute();
// print_r($statment->errorInfo());
$query=$statment->fetchAll();

foreach ($query as $row) {
    echo $row['name'].'<br>'.$row['area'].'<br>';

}
