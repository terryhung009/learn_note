<?php

// $listA = [];
$listA = array();
array_push($listA, 1);
array_push($listA, 3);
array_push($listA, 5);
array_push($listA, 8);
array_push($listA, 10);
array_push($listA, 5);
array_push($listA, 1);
echo '<pre>';
var_dump($listA);
echo '</pre>';
// echo $listA[0];
// echo count($listA);


$listB = [];

// $counter = 0;
$sum = 0;

for ($i = 0; $i < count($listA); $i++) {
    // $sum = 0;
    $sum = $sum + $listA[$i];
    // echo $sum . '<br>';
    array_push($listB, $sum);
}

// if ($i = count($listA)) {
//     break;
// }
echo '<pre>';
var_dump($listB);
echo '</pre>';
//     // echo $sum.'<br>';
//     $sum = 0;
