<?php
require 'vendor/autoload.php';



$collection = (new MongoDB\Client)->test->users;
// $collection->drop();

$collection->insertOne(['username' => 'User05']);
// $collection->insertOne(['name' => 'Alice', 'state' => 'ny']);
$deleteResult = $collection->deleteOne(['username' => 'User05']);

printf("Deleted %d document(s)\n", $deleteResult->getDeletedCount());
