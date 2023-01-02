{{--指定繼承 layout.master 母模板--}}
@extends('layout.master')

{{--//--}}
@section('title',$title)

{{--//--}}
@section('content')
    <div class="container">
        <h1>{{ $title }}</h1>

{{--        錯誤訊息模板元件--}}
        @include('components.validationErrorMessage')

        <form action="/user/auth/sign-up" method="post">
{{--            自動產生csrf_token隱藏欄位--}}
        {!! csrf_field() !!}

            <label for="">
                暱稱:
                <input type="text"
                       name="nickname"
                       placeholder="暱稱"
                       value="{{ old('nickname') }}"
                >
                
                
                
            </label>

            <label for="">
                Email:
                <input type="text"
                       name="email"
                       placeholder="Email"
                       value="{{ old('email') }}"
                >
                
            </label>

            <label for="">
                密碼:
                <input type="password"
                       name="password"
                       placeholder="密碼"
                >
            </label>

            <label for="">
                確認密碼:
                <input type="password"
                       name="password_confirmation"
                       placeholder="確認密碼"
                >
                
                
                
            </label>

            <label for="">
                帳號類型:
                <select name="type" id="">
                    <option value="G">一般會員</option>
                    <option value="A">管理者</option>

                </select>
            </label>
            
            <button type="submit">註冊</button>
        </form>
        
        
        
        
    </div>

@endsection
    
