<?php
require 'vendor/autoload.php';

// $collection = (new MongoDB\Client)->test->users;

// $insertOneResult = $collection->insertOne([
//   'username' => 'admin',
//   'email' => 'admin@example.com',
//   'name' => 'Admin User',
// ]);

// printf("Inserted %d document(s)\n", $insertOneResult->getInsertedCount());

// var_dump($insertOneResult->getInsertedId());
// <?php

$collection = (new MongoDB\Client)->test->users;

$insertOneResult = $collection->insertOne(['_id' => 1, 'name' => 'Alice']);

printf("Inserted %d document(s)\n", $insertOneResult->getInsertedCount());

var_dump($insertOneResult->getInsertedId());
