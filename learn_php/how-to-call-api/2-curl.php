<?php
// $ch = curl_init("https://jsonplaceholder.typicode.com/albums/1");

$payload =json_encode([
  "title" => "Updated title",

]);

$headers= [
  "Content-type: application/json; charset=UTF-8",
  "Accept-language: en"
];

$ch = curl_init();
/*
curl_setopt($ch, CURLOPT_URL, "https://jsonplaceholder.typicode.com/albums/1");
curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
*/
curl_setopt_array($ch,[
  // CURLOPT_URL => "https://jsonplaceholder.typicode.com/albums/1",
  CURLOPT_URL => "https://jsonplaceholder.typicode.com/invalid",
  CURLOPT_RETURNTRANSFER => true,
  CURLOPT_CUSTOMREQUEST => "PATCH",
  CURLOPT_POSTFIELDS => $payload,
  CURLOPT_HTTPHEADER => $headers,
  CURLOPT_HEADER => true
]);

$data = curl_exec($ch);

$status_code = curl_getinfo($ch, CURLINFO_HTTP_CODE);
curl_close($ch);

var_dump($status_code);
var_dump($data);