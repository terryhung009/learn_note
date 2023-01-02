<!-- Syntax -->
<?php
$array = array(1, 2, 3);
$array_two = [4, 5, 6];
$array_three = [4, 5, 6];

var_dump($array);
echo "<br/>";
var_dump($array_two === $array_three);
?>

<br /><br /><br /><br />

<?php
$food = array("burger", "fries", "coke");
echo "I like " . $food[0] . ", " . $food[1] . " and " . $food[2] . ".";
?>