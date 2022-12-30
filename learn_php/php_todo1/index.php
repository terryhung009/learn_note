<?php

$todoItems = [];
if (file_exists('todo.json')) {
    $json = file_get_contents('todo.json');
    $todoItems = json_decode($json, true);
}
?>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>

<body>

    <form action="newtodo.php" method="post">
        <input type="text" name="todo_name" placeholder="Enter your todo">
        <button>New Todo</button>
    </form>
    <br>

    <?php foreach ($todoItems as $todoName => $todo) : ?>
        <div>
            <input type="checkbox" <?php echo $todo['completed'] ? 'checked' : '' ?>>
            <?php echo $todoName ?>
            <a href="delete.php?todo_name=<?php echo $todoName ?>">Delete</a>
        </div>
    <?php endforeach;  ?>




</body>

</html>