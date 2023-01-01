<?php
require_once('functionPrintList.php');


function randomNumber()
{
    $list = [];

    while (true) {


        $key = rand(1, 42);
        $list[$key] = true;



        echo $key . '<br>';
        if (count($list) == 7) {
            break;
        }
    }
    printList($list);
}

randomNumber();
