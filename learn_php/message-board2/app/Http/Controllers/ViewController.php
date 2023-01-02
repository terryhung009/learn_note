<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Models\Message;

class ViewController extends Controller
{
    //
    public function __invoke()
	{
		return view('main')
			->with('messages', Message::all());
	}
}
