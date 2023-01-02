<?php

namespace Database\Seeders;

use Illuminate\Database\Seeder;
use Illuminate\Support\Facades\DB;
use Illuminate\Support\Str;

class BookTableSeeder extends Seeder
{
    /**
     * Run the database seeds.
     *
     * @return void
     */
    public function run()
    {
//        \App\Models\Models\Book::factory(10)->create();

        DB::table('books')->insert([
            'name' => Str::random(10),
            'author' => Str::random(10),
            'price' => 1000,
            'publication_date' => '2021/11/04'

        ]);

    }
}
