<?php

namespace Database\Factories;

use Illuminate\Database\Eloquent\Factories\Factory;
use Illuminate\Support\Str;

class MessageFactory extends Factory
{
    /**
     * Define the model's default state.
     *
     * @return array
     */
    public function definition()
    {
        return [
            'name' => Str::random(8),
			'title' => $this->faker->sentence,
			'content' => implode("\n", $this->faker->sentences),
			'attachment' => null,
        ];
    }
}
