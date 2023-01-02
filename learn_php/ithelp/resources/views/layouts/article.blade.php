<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width,user-scalable=no,initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>iT 幫幫我!</title>
    <link rel="stylesheet" href="{{  asset('css/app.css')  }}">

</head>
<body>
<main class="m-4">

    @if(session()->has('notice'))
        <div class="bg-pink-300 px-3 py-2 rounded">
            {{ session()->get('notice') }}
        </div>


        @endif

    @yield('main')


</main>

<script src="{{  asset('js/app.js')  }}"></script>
@yield('bottom_js')
</body>
</html>

