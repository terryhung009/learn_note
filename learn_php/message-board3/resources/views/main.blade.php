<!-- {{-- resources/views/main.blade.php --}} -->
<!DOCTYPE html>
<html lang="en">
	<head>
		<title>Message Board</title>
	</head>
	<body>
		<table width="500" height="300" align="center" border="1">
		<tr>
			<td>
		<form method="post" action="/" enctype="multipart/form-data">
			@csrf
			<!-- <label for="title">標題：</label>
			<input id="title" name="title"> -->

			<label for="name">暱稱：</label>
			<input type=text id="name" name="name"><br/>

			<label for="content">留言：</label>
			<textarea style="height: 300px;width: 500px;resize: none;" id="content" name="content"></textarea><br/>

			<!-- <label for="attachment">附加圖檔：</label>
			<input id="attachment" name="attachment"> -->
			<div align="center">
            <button type="submit">送出</button>
			</div>
		</form>
		<hr>

		<p>留言(新到舊)</p>
		@foreach($messages as $message)
		<div>
			<!-- <h1>{{ $message->title }}</h1> -->
			
			<p>{{ $message->created_at }}{{ $message->name }}：{{ $message->content }}</p>
			<!-- {{-- 先以路徑的方式將 attachment 印出 --}}
			<code>{{ $message->attachment }}</code> -->
		</div>
		@endforeach
			</td>
		</tr>	
		</table>

        {{-- 使用 links() 就可以顯示頁碼工具 --}}
        {{ $messages->links() }}
	</body>
</html>