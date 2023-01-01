<?php

// $listA = [];
$listA = array(2,7,7,6);

echo '<pre>';
var_dump($listA);
echo '</pre>';



// $listB = [];
$listB = array();

// $counter = 0;
$sum = 0;

for ($i = 0; $i < count($listA); $i++) {
    // $sum = 0;
    $sum = $sum + $listA[$i];
    echo $sum . '<br>';
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
