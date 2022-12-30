<?php

$string_src = "BSA01,BSA02,BSA03,BSA04,BSA05,BSA06,BSA07";


$array = explode(",", $string_src);


foreach ($array as $k => $v) {
    $array[$k] = ($k + 1) . '->' . $v;
};

echo implode(", ", $array);

