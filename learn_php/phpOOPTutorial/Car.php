<?php

class Car
{
		public $color;
		public $weight;
		private $year;
		
		public function setYear($year){
			$this->year =$year;
		}
		public function getYear()
		{
			return $this->year;
		}
}

$myCar = new Car();
$myCar->color = 'red';
// echo $myCar->color;


//$myCar->year = 2020;
$myCar->setYear(2010);
echo $myCar->getYear();

