<!-- Integer -->
<?php
$a = 1;
$b = 0;
$c = -300;

echo $a;
echo "<br>";
echo $b;
echo "<br>";
echo $c;
echo "<br>";
echo gettype($c);
echo "<br>";

?>

<br /><br /><br />
<!-- Float -->
<?php
$a = 1.1;
$b = 1.123;
$c = 1.234123;

echo $a;
echo "<br>";
echo $b;
echo "<br>";
echo $c;
echo "<br>";
echo gettype($c);
echo "<br>";
echo var_dump($c);
echo "<br>";

?>

<br /><br /><br />
<!-- https://stackoverflow.com/questions/3280892/difference-between-float-and-double-in-php -->

<!-- String -->

<?php
$a = "string";
$b = 'another string';
$c = "I'm another string";

echo $a;
echo "<br>";
echo $b;
echo "<br>";
echo $c;
echo "<br>";
echo gettype($c);
echo "<br>";
echo var_dump($c);
?>

<!-- String Concatenation -->