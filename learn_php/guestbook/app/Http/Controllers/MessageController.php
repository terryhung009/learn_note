<?php

namespace App\Http\Controllers;


use Illuminate\Http\Request;
// use App\Http\Requests;
use App\Http\Models\Message;

class MessageController extends Controller
{
    //
    // public function __construct()
    // {
    //     $this->middleware('auth');
    // }

    /**
     * Display a list of all of the user's message.
     *
    * @param  Request  $request
    * @return Response
    */
    /*public function index(Request $request)
    {
        return view('messages.index');
    }
    */

    /**
    * Display a list of all of the user's message.
    *
    * @param  Request  $request
    * @return Response
    */
    public function index(Request $request)
    {
        // 等同於$messages = Message::where('user_id', $request->user()->id)->get();
        $messages = $request->user()->messages()->get();

        return view('messages.index', [
        'messages' => $messages,
        ]);
    }


    /**
    * Create a new message.
    *
    * @param  Request  $request
    * @return Response
    */
    public function store(Request $request)
    {
        $this->validate($request, [
            'name' => 'required|max:255',
        ]);

        $request->user()->messages()->create([
            'name' => $request->name,
        ]);

        return redirect('/messages');
    }
}
