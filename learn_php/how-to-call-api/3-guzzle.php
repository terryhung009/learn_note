<?php

require __DIR__ . "/vendor/autoload.php";

$payload = json_encode([
  "title" => "Updated title"
]);

$headers = [
  "Content-type" => "application/json; charset=UTF-8" 
];

$client = new GuzzleHttp\Client();

// $response = $client->request("GET", "https://jsonplaceholder.typicode.com/albums/1");

// $response = $client->get("https://jsonplaceholder.typicode.com/albums/1");

$response = $client->patch("https://jsonplaceholder.typicode.com/albums/1", [
  "headers" => $headers,
  "body" => $payload,
]);

$result = (string)$response->getBody();

$headers_result = $response->getHeader("Content-type");

$statuscode = $response->getStatusCode();
var_dump($statuscode);
var_dump($headers_result);
var_dump($result);