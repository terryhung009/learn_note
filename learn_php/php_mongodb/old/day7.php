<?php
require 'vendor/autoload.php';




$collection = (new MongoDB\Client)->test->restaurants;

$cursor = $collection->find(
    [
        'cuisine' => 'Italian',
        'borough' => 'Manhattan',
    ],
    [
        'projection' => [
            'name' => 1,
            'borough' => 1,
            'cuisine' => 1,
        ],
        'limit' => 4,
    ]
);

foreach ($cursor as $restaurant) {
    var_dump($restaurant);
};
