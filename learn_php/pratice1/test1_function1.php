<?php


function printList($list)
{
    echo '<pre>';
    var_dump($list);
    echo '</pre>';
}

function sum($listA)
{
    $listB = [];
    $sum = 0;
    printList($listA);

    foreach ($listA as $key => $value) {
        $sum = $sum + $listA[$key];
        // array_push($listB, $sum);
        $listB[] = $sum;
    }

    return $listB;
}

$listA = [
    1,
    3,
    5,
    8,
    10,
    5,
    1
];

$listB = sum($listA);

printList($listB);
