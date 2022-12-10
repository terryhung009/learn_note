<?php

require_once __DIR__.'/../vendor/autoload.php';

use app\Router;
use app\controllers\ProductController;

// echo "Hello World";

$router = new Router();

$router->get('/',[ProductController::class,'index']);
$router->get('/producs', [ProductController::class, 'index']);
$router->get('/products/create', [ProductController::class, 'create']);
$router->post('/products/create', [ProductController::class, 'create']);
$router->get('/products/update', [ProductController::class, 'update']);
$router->post('/products/update', [ProductController::class, 'update']);
$router->post('/products/delete', [ProductController::class, 'delete']);

$router->resolve();
