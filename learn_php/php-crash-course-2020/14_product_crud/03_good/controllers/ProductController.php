<?php

namespace app\controllers;

use app\Router;
use app\models\Product;

class ProductController
{
    public function index(Router $router)
    {
        $search = $_GET['search'] ?? '';
        $products = $router->db->getProducts($search);

        // echo '<pre>';
        // var_dump($products);
        // echo '</pre>';

        $router->renderView('products/index', [
            'products' => $products,
            'search' => $search,
        ]);
        // echo "Index Page";
    }
    public function create(Router $router)
    {
        $errors = [];
        $productData = [
            'title' => '',
            'description' => '',
            'image' => '',
            'price' => '',

        ];
        if ($_SERVER['REQUEST_METHOD'] === 'POST') {
            $productData['title'] = $_POST['title'];
            $productData['description'] = $_POST['description'];
            $productData['price'] = (float)$_POST['price'];
            $productData['imageFile'] = $_FILES['image'] ?? null;

            $product = new Product();
            $product->load($productData);
            $errors = $product->save();
            if (empty($errors)) {
                header('Location: /products');
                exit;
            }
        }
        // echo '<pre>';
        // var_dump($productData);
        // echo '</pre>';


        $router->renderView('products/create', [
            'product' => $productData,
            'errors' => $errors,
        ]);

        // echo "Create Page";
    }

    public function update(Router $router)
    {
        $id = $_GET['id'] ?? null;
        if (!$id) {
            header('Location: /products');
            exit;
        }
        $errors = [];
        $productData = $router->db->getProductById($id);

        if ($_SERVER['REQUEST_METHOD'] === "POST") {
            $productData['title'] = $_POST['title'];
            $productData['description'] = $_POST['description'];
            $productData['price'] = (float)$_POST['price'];
            $productData['imageFile'] = $_FILES['image'] ?? null;

            $product = new Product();
            $product->load($productData);
            $errors = $product->save();
            if (empty($errors)) {
                header('Location: /products');
                exit;
            }

            $router->renderView('products/update', [
                'prodcut' => $productData,
                'errors' => $errors,
            ]);
            // echo "Update Page";
        }
    }
    public function delete(Router $router)
    {
        $id = $_POST['id'] ?? null;
        if (!$id) {
            header('Location: /products');
            exit;
        }
        $router->db->deleteProduct($id);
        header('Location: /products');
        // echo "Delete Page";
    }
}
