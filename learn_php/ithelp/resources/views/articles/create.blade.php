@extends('layouts.article')

@section('main')
    <h1 class="font-bold text-6xl">文章 > 新增文章</h1>

    @if($errors->any())
        <div class="errors p-3 bg-red-600 text-red-100 font-thin rounded">
            <ul>
                @foreach($errors->all() as $error)
                    <li>{{ $error }}</li>
                @endforeach

            </ul>

        </div>
        @endif
    <form action="{{ route('articles.store') }}" method="post">
        @csrf
        <div class="field my-2" >
        <label for="">標題</label>
        <input type="text" value="{{ old('title') }}" name="title" class="border border-gray-300 p-2">

        </div>

        <div class="field my-2" >
            <label for="">內文</label>
            <textarea name="content" rows="10" cols="30" class="border border-gray-300 p-2">{{ old("content") }}</textarea>



        </div>

        <div class="actions">
            <button type="submit" class="px-3 py-2 rounded bg-gray-200 hover:bg=gray-300">新增文章</button>


        </div>




    </form>

@endsection
