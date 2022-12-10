<?php

// What is class and instance

require_once "Person.php";
require_once "Student.php";

$student = new Student("Brad", "Traversy", 12345);
echo '<pre>';
var_dump($student);
echo '</pre>';





//first class zone
// class Person
// {
//     public $name;
//     public $surname;
//     protected $age;
//     public static $counter = 0;

//     public function __construct($name, $surname)
//     {
//         // echo $name. ' '.$surname;
//         $this->name = $name;
//         $this->surname = $surname;
//         $this->age= null;
//         self::$counter++;
//     }
//     public function setAge($age)
//     {
//         $this->age = $age;
//     }
//     public function getAge()
//     {
//         return $this->age;
//     }
//     public static function getCounter()
//     {
//         return self::$counter;
//     }
// $p = new Person("Brad", "Traversy");
// $p->setAge(30);

// echo '<pre>';
// var_dump($p);
// echo '</pre>';

// echo $p->getAge();



// $p2 = new Person("Brad", "Traversy");
// // $p->name="Brad";
// // $p->surname ="Traversy";

// echo'<pre>';
// var_dump($p);
// echo '</pre>';

// echo Person::$counter.'<br>';
// echo Person::getCounter();

// echo $p->name.'<br>';

// Create Person class in Person.php

// Create instance of Person

// Using setter and getter