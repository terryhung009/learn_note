<?php
require 'vendor/autoload.php';

$collection = (new MongoDB\Client)->test->users;

$document = $collection->findOne(['username' => 'admin']);

var_dump($document);
