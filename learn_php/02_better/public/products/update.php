<?php

/** @var $pdo \PDO */
require_once "../../database.php";
require_once "../../functions.php";

$id = $_GET['id'] ?? null;

if (!$id) {
    header('Location:index.php');
    exit;
}

$statement = $pdo->prepare('SELECT * FROM products WHERE id = :id');
$statement->bindValue(':id', $id);
$statement->execute();
$product = $statement->fetch(PDO::FETCH_ASSOC);

// echo'<pre>';
// var_dump($product);
// echo '</pre>';
// exit;

$errors = [];

$title = $product['title'];
$description = $product['description'];
$price = $product['price'];

// echo '<pre>';
// var_dump($_FILES);
// echo '</pre>';
// exit;

// ?image=&title=&description=&price=

// echo '<pre>';
// var_dump($_POST);
// echo '</pre>';
// exit;

// echo '<pre>';
// var_dump($_SERVER);
// echo '</pre>';
// exit;

// echo $_SERVER['REQUEST_METHOD'] . '<br>';

if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    
    require_once "../../validate_product.php";
    // $title = $_POST['title'];
    // $description = $_POST['description'];
    // $price = $_POST['price'];




    // if (!$title) {
    //     $errors[] = 'Product title is required';
    // }
    // if (!$price) {
    //     $errors[] = 'Product price is required';
    // }
    // if (!is_dir('images')) {
    //     mkdir('images');
    // }

    if (empty($errors)) {
        // $image = $_FILES['image'] ?? null;
        // $imagePath = $product['image'];
        // echo '<pre>';
        // var_dump($image);
        // echo '</pre>';
        // exit;



        // if ($image && $image['tmp_name']) {
        //     if ($product['image']) {
        //         unlink($product['image']);
        //     }


        //     $imagePath = 'images/' . randomString(8) . '/' . $image['name'];
        //     mkdir(dirname($imagePath));

        //     // echo '<pre>';
        //     // var_dump($imagePath);
        //     // echo '</pre>';
        //     // exit;
        //     move_uploaded_file($image['tmp_name'], $imagePath);
        // }

        // exit;

        $statement = $pdo->prepare(
            "UPDATE products SET title = :title, image = :image,
             description = :description, price = :price WHERE id = :id "
        );
        $statement->bindValue(':title', $title);
        $statement->bindValue(':image', $imagePath);
        $statement->bindValue(':description', $description);
        $statement->bindValue(':price', $price);
        $statement->bindValue(':id', $id);
        // $statement->bindValue(':date', $date);

        $statement->execute();
        header('Location:index.php');
    }
}

// function randomString($n)
// {
//     $characters = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ';
//     $str = '';
//     for ($i = 0; $i < $n; $i++) {
//         $index = rand(0, strlen($characters) - 1);
//         $str .= $characters[$index];
//     }

//     return $str;
// }




?>


<!doctype html>
<html lang="en">

<?php include_once "../../views/partials/header.php"; ?>

<p>
    <a href="index.php" class="btn btn-secondary">回到Products</a>
</p>

<h1>編輯 Product <b><?php echo $product['title'] ?></b> </h1>

<?php include_once "../../views/products/form.php" ?>











<!-- Optional JavaScript; choose one of the two! -->

<!-- Option 1: Bootstrap Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ" crossorigin="anonymous"></script>

<!-- Option 2: Separate Popper and Bootstrap JS -->
<!--
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.1/dist/umd/popper.min.js" integrity="sha384-W8fXfP3gkOKtndU4JGtKDvXbO53Wy8SZCQHczT5FMiiqmQfUpWbYdTil/SxwZgAN" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.min.js" integrity="sha384-skAcpIdS7UcVUC05LJ9Dxay8AXcDYfBJqt1CJ85S/CFujBsIzCIv+l9liuYLaMQ/" crossorigin="anonymous"></script>
    -->
</body>

</html>