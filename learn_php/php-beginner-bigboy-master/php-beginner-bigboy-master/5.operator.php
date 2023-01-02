<!-- syntax -->
<?php
$a = 1;
$b = true;
if ($a == $b) {
  echo "This is true";
} else {
  echo "This is false";
} ?>

<br /><br /><br /><br />

<!-- AND OPERATOR -->
<?php
$a = true;
$b = true;
if ($a and $b) {
  echo "This is true";
} else {
  echo "This is false";
}
?>
<br /><br /><br /><br />

<!-- OR OPERATOR -->

<?php
$a = true;
$b = false;
if ($a || $b) {
  echo "This is true";
} else {
  echo "This is false";
}
?>