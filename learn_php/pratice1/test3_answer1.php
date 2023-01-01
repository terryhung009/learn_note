<?php
require_once('functionPrintList.php');

// $list = [1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42];
// print_list(range(0, 10));
function randomNumber()
{
    foreach (range(0, 12) as $key => $value) {
        $key = rand(0, 41);

        $list[$key] = true;

        // echo $key . '<br>';
        if (count($list) == 7) {
            break;
        }
        
    }
    printList($list);
    foreach($list as $key=>$value){
        echo $key . '<br>';
    }

    
}

randomNumber();

// foreach(range(1,7) as $number){

// }

// if ($key = 7) {
//     break;
// }
// echo rand(1, 42);

// for ($i = 0; $i < 7; $i++) {
//     $str = rand(1, 42);
//     echo $str . '<br>';
// }
