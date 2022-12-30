<?php

$payload =json_encode([
    "title" => "Updated title",

]);

$options = [
    "http" => [
        "method" => "PATCH",
        "header" => "content-type: application/json; charset=UTF-8",
        "content" => $payload
    ]
];

$context = stream_context_create($options);

$data = file_get_contents("https://jsonplaceholder.typicode.com/albums/1", false, $context);

var_dump($data);
// exit;
// echo "\r\n";

print_r($http_response_header);