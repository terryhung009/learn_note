{{-- resources/views/main.blade.php --}}
<html lang="en">
	<head>
		<title>Message Board</title>
	</head>
	<body>
		<form method="post" action="{{ route('post') }}" enctype="multipart/form-data">
			@csrf
			<label for="name">暱稱：</label>
			<input id="name" name="name">

			<label for="title">標題：</label>
			<input id="title" name="title">

			<label for="content">內文：</label>
			<textarea id="content" name="content"></textarea>

			<!-- <label for="attachment">附加圖檔：</label>
			<input id="attachment" name="attachment"> -->
            <button type="submit">送出</button>
		</form>

		@foreach($messages as $message)
		<div>
			<h1>{{ $message->title }}</h1>
			<p>{{ $message->content }}</p>
			{{-- 先以路徑的方式將 attachment 印出 --}}
			<code>{{ $message->attachment }}</code>
		</div>
		@endforeach

        {{-- 使用 links() 就可以顯示頁碼工具 --}}
        {{ $messages->links() }}
	</body>
</html>