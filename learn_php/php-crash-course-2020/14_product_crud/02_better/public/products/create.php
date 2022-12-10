<?php

/** @var $pdo \PDO */
require_once "../../database.php";
require_once "../../functions.php";

$errors = [];

$title = '';
$description = '';
$price = '';
$product = [
    'image' => '',
];

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
    // $title = $_POST['title'];
    // $description = $_POST['description'];
    // $price = $_POST['price'];
    // $date = date('Y-m-d H:i:s');



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

        require_once "../../validate_product.php";
        //     $image = $_FILES['image'] ?? null;
        //     $imagePath = '';
        //     // echo '<pre>';
        //     // var_dump($image);
        //     // echo '</pre>';
        //     // exit;

        //     if ($image && $image['tmp_name']) {
        //         $imagePath = 'images/' . randomString(8) . '/' . $image['name'];
        //         mkdir(dirname($imagePath));

        //         // echo '<pre>';
        //         // var_dump($imagePath);
        //         // echo '</pre>';
        //         // exit;
        //         move_uploaded_file($image['tmp_name'], $imagePath);
        //     }

        // exit;

        $statement = $pdo->prepare(
            "INSERT INTO products (title, image, description, price , create_date)
                VALUES(:title, :image ,:description,:price,:date)"
        );
        $statement->bindValue(':title', $title);
        $statement->bindValue(':image', $imagePath);
        $statement->bindValue(':description', $description);
        $statement->bindValue(':price', $price);
        $statement->bindValue(':date', date('Y-m-d H:i:s'));

        $statement->execute();
        header('Location:index.php');
    }
}






?>


<?php include_once "../../views/partials/header.php"; ?>

<p>
    <a href="index.php" class="btn btn-secondary">回到Products</a>
</p>

<h1>Create New Product</h1>

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