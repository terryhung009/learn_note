<?php
require 'vendor/autoload.php';



$collection = (new MongoDB\Client)->test->users;
// $collection->drop();

// $collection->insertOne(['name' => 'Bob', 'state' => 'ny']);
// $collection->insertOne(['name' => 'Alice', 'state' => 'ny']);
$updateResult = $collection->updateOne(
    ['username' => 'User01'],
    ['$set' => ['username' => 'User09']]
);

printf("Matched %d document(s)\n", $updateResult->getMatchedCount());
printf("Modified %d document(s)\n", $updateResult->getModifiedCount());
