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

$insertManyResult = $collection->insertMany([
  [
    'username' => 'admin',
    'email' => 'admin@example.com',
    'name' => 'Admin User',
  ],
  [
    'username' => 'test',
    'email' => 'test@example.com',
    'name' => 'Test User',
  ],
]);

printf("Inserted %d document(s)\n", $insertManyResult->getInsertedCount());

var_dump($insertManyResult->getInsertedIds());
