<?php

namespace Tests\Feature;

use Illuminate\Foundation\Testing\RefreshDatabase;
use Illuminate\Foundation\Testing\WithFaker;
use Tests\TestCase;
use Illuminate\Support\Facades\Storage;
use Illuminate\Http\UploadedFile;
use App\Models\Message;



class PostTest extends TestCase
{
    use RefreshDatabase;
    /**
     * A basic feature test example.
     *
     * @return void
     */
    // public function test_example()
    // {
    //     $response = $this->get('/');

    //     $response->assertStatus(200);
    // }

    public function test_post()
	{
        // 根據 Message Factory 建立一組假的測資
		$post = Message::factory()->make();

        // 利用 $this->post 去對目前的應用程式模擬請求
		$response = $this->post(route('post'), [
			'title' => $post->title,
			'content' => $post->content,
		]);

        // 確定 $response 符合預期
		$response->assertSuccessful();
        // 確定資料庫中含有期望的資料
		$this->assertDatabaseHas('messages', [
			'title' => $post->title,
			'content' => $post->content,
		]);
	}

	public function test_post_without_content()
	{
		$post = Message::factory()->make();

		$response = $this->post(route('post'), [
			'title' => $post->title,
			'content' => '',
		]);

		$response->assertSuccessful();
		$this->assertDatabaseHas('messages', [
			'title' => $post->title,
			'content' => '無內文',
		]);
	}

    public function test_post_with_attachment()
    {
	// 建立一個假的儲存空間，每次測試結束後都會自動清空
	Storage::fake();

	$post = Message::factory()->make();

	$response = $this->post(route('post'), [
		'title' => $post->title,
		'content' => $post->content,
		// 由 Laravel 自動生成一張假的圖片供測試使用
		'attachment' => UploadedFile::fake()->image('attachment.png'),
	]);

	$response->assertSuccessful();
	$this->assertDatabaseHas('messages', [
		'title' => $post->title,
		'content' => $post->content,
	]);
	// 尋找剛剛生成的 Message
	// store 時 Laravel 會重新生成一個檔名用於儲存，所以需要先取得資料庫內的檔名才能做後續搜索
	$message = Message::where('title', $post->title)->first();
	// 確定 attachment 有被加入
	$this->assertNotNull($message->attachment);
	// 確定 attachment 的檔案存在
	Storage::assertExists($message->attachment);
    }
}
