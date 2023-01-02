<!-- While Loop -->
<!-- https://www.php.net/manual/en/control-structures.while.php -->

<?php
$x = 1;

// while ($x <= 5) {
//   echo "The number is: $x <br>";
//   $x++;
// }

while ($x <= 5) :
  echo "The number is: $x <br>";
  $x++;
endwhile;
?>

<br /><br /><br /><br />

<!-- For Loop -->

<?php
for ($x = 0; $x <= 10; $x++) {
  echo "The number is: $x <br>";
}
?>