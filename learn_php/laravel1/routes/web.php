<?php

use Illuminate\Support\Facades\Route;
use App\Http\Controllers\TitleController;
use App\Http\Controllers\AdController;
use App\Http\Controllers\ImageController;
use App\Http\Controllers\MvimController;
use App\Http\Controllers\TotalController;
use App\Http\Controllers\BottomController;
use App\Http\Controllers\NewsController;
use App\Http\Controllers\AdminController;
use App\Http\Controllers\MenuController;

/*
|--------------------------------------------------------------------------
| Web Routes
|--------------------------------------------------------------------------
|
| Here is where you can register web routes for your application. These
| routes are loaded by the RouteServiceProvider within a group which
| contains the "web" middleware group. Now create something great!
|
*/


Route::view('/', 'home');
Route::redirect('/admin', '/admin/title');
Route::prefix('admin')->group(function(){
    //get
    Route::get('/title',[TitleController::class,'index']);
    Route::get('/ad',[AdController::class,'index']);
    Route::get('/image',[ImageController::class,'index']);
    Route::get('/mvim',[MvimController::class,'index']);
    Route::get('/total',[TotalController::class,'index']);
    Route::get('/bottom',[BottomController::class,'index']);
    Route::get('/news',[NewsController::class,'index']);
    Route::get('/admin',[AdminController::class,'index']);
    Route::get('/menu',[MenuController::class,'index']);

    //post
    Route::post('/title',[TitleController::class,'store']);
    Route::post('/ad',[AdController::class,'store']);
    Route::post('/image',[ImageController::class,'store']);
    Route::post('/mvim',[MvimController::class,'store']);
    Route::post('/total',[TotalController::class,'store']);
    Route::post('/bottom',[BottomController::class,'store']);
    Route::post('/news',[NewsController::class,'store']);
    Route::post('/admin',[AdminController::class,'store']);
    Route::post('/menu',[MenuController::class,'store']);
});





//modals

Route::get("modals/addTitle", [TitleController::class,'create']);
Route::get("modals/addAd", [AdController::class,'create']);
Route::view("modals/addImage", 'modals.base_modal', ['modal_header' => "????????????????????????"]);

// Route::view("modals/addTitle", 'modals.base_modal', ['modal_header' => "??????????????????"]);
// Route::view("modals/addAd", 'modals.base_modal', ['modal_header' => "????????????????????????"]);
// Route::view("modals/addImage", 'modals.base_modal', ['modal_header' => "????????????????????????"]);

//?????????????????????
// Route::get('/', function () {
//     return view('welcome');
// });
// Route::view('/', 'welcome');
// Route::view('/home', 'home');

// Route::view('/admin', '/backend.module', ['header' => '??????????????????', 'module' => 'Title']);

//??????????????????
// Route::get('admin', [App\Http\Controllers\TitleController::class, 'index']);
//????????????namespace
// use App\Http\Controllers\TitleController;
// Route::get('admin',[TitleController::class,'index']);

//??????module??????+siwtch??????
// Route::get('admin/{module}', function ($module) {
// switch ($module) {
//     case "title":
//         return view('backend.module', ['header' => '??????????????????', 'module' => 'Title']);
//         break;
//     case "ad":
//         return view('backend.module', ['header' => '????????????????????????', 'module' => 'Ad']);
//         break;
//     case "image":
//         return view('backend.module', ['header' => '????????????????????????', 'module' => 'Image']);
//         break;
//     case "mvim":
//         return view('backend.module', ['header' => '??????????????????', 'module' => 'Mvim']);
//         break;
//     case "total":
//         return view('backend.module', ['header' => '??????????????????', 'module' => 'Total']);
//         break;
//     case "bottom":
//         return view('backend.module', ['header' => '??????????????????', 'module' => 'Bottom']);
//         break;
//     case "news":
//         return view('backend.module', ['header' => '??????????????????', 'module' => 'News']);
//         break;
//     case "admin":
//         return view('backend.module', ['header' => '?????????????????????', 'module' => 'Admin']);
//         break;
//     case "menu":
//         return view('backend.module', ['header' => '????????????', 'module' => 'Menu']);
//         break;
// }
// });


//?????????router??????
// Route::view('/admin/title', '/backend.title');
// Route::view('/admin/ad', '/backend.ad');
// Route::view('/admin/ad', '/backend.ad');
// Route::view('/admin/ad', '/backend.ad');
// Route::view('/admin/ad', '/backend.ad');
// Route::view('/admin/ad', '/backend.ad');
// Route::view('/admin/ad', '/backend.ad');
// Route::view('/admin/ad', '/backend.ad');
// Route::view('/admin/ad', '/backend.ad');

//??????prefix
// Route::prefix('admin')->group(function () {
//     Route::view('/', 'backend.title');
//     Route::view('/title', 'backend.title');
//     Route::view('/ad', 'backend.ad');
// });
