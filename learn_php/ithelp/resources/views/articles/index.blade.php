@extends('layouts.article')

@section('main')
    <h1 class="font-bold text-6xl">文章列表</h1>
    <a href="{{ route('articles.create') }}">新增文章</a>

    @foreach($articles as $article)
        <div class="bg-gray-200 m-1">
            <h2 class="font-bold text-lg">
                <a href="{{ route('articles.show',$article) }}">
                {{ $article->title }}
                </a>
            </h2>

            <p>
                {{ $article->created_at}}由{{$article->user->name}}分享


            </p>
            <p>
                {{ $article->content }}
            </p>

{{--            <a href="{{ route('articles.edit' , ['article' => $article->id])}}">編輯文章</a>--}}
            <div class="flex">
            <a class="mr-3" href="{{ route('articles.edit' , ['article' => $article] )}}">編輯文章</a>

            <form action="{{ route('articles.destroy',$article) }}" method="post">
                @csrf
                @method('delete')

                <button type="submit" class="px-2 bg-red-600 text-red-100 rounded">刪除文章</button>
            </form>
            </div>

        </div>
    @endforeach
    {{ $articles->links() }}
@endsection

@section('bottom_js')
    <script>
        $().ready(function(){
            console.log('Hi,This is jQuery.AWESOME.');
        });


    </script>

@endsection
