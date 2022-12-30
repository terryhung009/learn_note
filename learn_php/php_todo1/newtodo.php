<?php

// echo '<pre>';
// var_dump($_POST);
// echo '</pre>';

$todoName = $_POST['todo_name'] ?? false;
$todoName = trim($todoName);

if ($todoName) {
    // echo "Save todo";
    if (file_exists('todo.json')) {


        $json = file_get_contents('todo.json');
        // echo $json;
        $jsonArray = json_decode($json, true);
    } else {
        $jsonArray = [];
    }
    $jsonArray[$todoName] = ['completed' => false];


    // echo '<pre>';
    // var_dump($jsonArray);
    // echo '</pre>';

    $json_todo = file_put_contents('todo.json', json_encode($jsonArray, JSON_PRETTY_PRINT));

    // echo '<pre>';
    // var_dump($json_todo);
    // echo '</pre>';
}


header('Location:index.php');
