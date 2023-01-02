<?php

namespace Database\Factories\Models;

use Illuminate\Database\Eloquent\Factories\Factory;
use Faker\Generator as Faker;


class BookFactory extends Factory
{
    /**
     * Define the model's default state.
     *
     * @return array
     */
    public function definition()
    {
        return [
            'name' => $this->faker->name,
            'author' => $this->faker->name,
            'price' => $this->faker->numberBetween(300,2500),
            'publication_date' => $this->faker->dateTimeBetween('-10 year', '+9 month'),
        ];
    }
}
