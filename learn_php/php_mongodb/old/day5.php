<?php
require 'vendor/autoload.php';


$collection = (new MongoDB\Client)->test->users;

$cursor = $collection->find(['city' => 'JERSEY CITY', 'state' => 'NJ']);

foreach ($cursor as $document) {
    echo $document['_id'], "\n";
}
