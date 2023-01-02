<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use Illuminate\Support\Str;
use App\Models\Message;

class PostController extends Controller
{
    //
    public function __invoke(Request $request)
	{
		// 驗證資料
		// title 為必需字串；content 可以為空白字串；attachment 為可選圖片，但圖片小於 5MB
		$request->validate([
			'title' => 'required|string',
			'content' => 'string|nullable',
			'attachment' => 'image|max:5120', 
		]);

		if ($request->has('attachment')) {
            // 利用 store 將圖片儲存於 attachments/ 資料夾下
            $attachment = $request->attachment->store('attachments');
        }

		Message::create([
			'name' => Str::random(8),
			'title' => $request->title,
			// 當 content 為空時，使用「無內文」的預設值
			'content' => $request->content ?? '無內文',
			// 目前 $attachment 永遠未設定，所以此處必為 null
			'attachment' => $attachment ?? null,
		]);

		// 回傳字串表示成功建立，之後再修改
		return 'Success';
	}
}
