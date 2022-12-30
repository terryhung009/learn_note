<?php
$DB_HOST = 'localhost'; // 主機
$DB_USER = 'root';  // 登入 MySQL server 的帳號
$DB_PASS = '088220'; // 密碼
$DB_NAME = 'test'; // 要登入的資料庫名稱

$connection = new mysqli($DB_HOST, $DB_USER, $DB_PASS, $DB_NAME);

if ($connection->connect_error) {
    die("連接失敗: " . $connection->error);
} else {
    $query = 'SELECT * from question';
    $result = $connection->query($query);
    // echo '<pre>';
    // var_dump($result);
    // echo '</pre>';
    // $data = $result->fetch_array();
    // $data = $result->fetch_assoc();
    $data = $result->fetch_all(MYSQLI_NUM);

    print_array($data);
    // echo '<pre>';
    // var_dump($data);
    // echo '</pre>';
    // $counter = 0;
    // $j=0;
    // foreach ($data as $key => $value) {
    //     // $result_array[] = preg_grep("/訂單/", $data[$counter]);
    //     $result_array[] = preg_match_all("/訂單/", $data[$counter][$j]);

    // };




    // print_array($result_array);

    // $counter = 0;
    // foreach ($data as $key => $value) {
    //     // $array[]=array_count_values($data[$counter]); 
    //     preg_grep

    // };
    // echo '<pre>';
    // var_dump($array);
    // echo '</pre>';
}

function print_array($data)
{
    echo '<pre>';
    var_dump($data);
    echo '</pre>';
}
