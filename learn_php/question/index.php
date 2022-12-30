<?php
$DB_HOST = 'localhost'; // 主機
$DB_USER = 'root';  // 登入 MySQL server 的帳號
$DB_PASS = '!!!@@##'; // 密碼
$DB_NAME = 'test'; // 要登入的資料庫名稱

$connection = new mysqli($DB_HOST, $DB_USER, $DB_PASS, $DB_NAME);

if ($connection->connect_error) {
    die("連接失敗: " . $connection->error);
} else {
    $query = 'SELECT * from question';
    $result = $connection->query($query);

    $data = $result->fetch_all(MYSQLI_NUM);

    // print_array($data);

    foreach ($data as $key => $value) {
        // print_array($value);

        $str = implode(",", $value);
        // echo $str . '</br>';
        $count1 = substr_count("$str", "訂單");
        $count2 = substr_count("$str", "交貨");
        $count_total = $count1 + $count2;
        // echo $count_total . '</br>';

        $array[] = $count_total;
    };

    // print_array($array);
    // echo  '</br>';

    $key = array_search(max($array), $array);
    echo "出現最多'訂單'跟'交貨'的是第" . $key . "資料列";
}

function print_array($data)
{
    echo '<pre>';
    var_dump($data);
    echo '</pre>';
}

?>

使用技術：MySQL+PHP

使用mysqli函式取出資料庫中資料，存成陣列(一般陣列或關聯陣列都可)

使用foreach迴圈，將單一陣列中個欄位資料組合成新字串

使用substr_count()尋找"訂單""交貨"關鍵字並計算次數

將計算次數組合成新陣列

合併使用max()尋找陣列最大值及array_search()尋找陣列元素指標index

最後輸出index