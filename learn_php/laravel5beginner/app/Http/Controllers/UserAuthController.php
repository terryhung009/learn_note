<?php

namespace App\Http\Controllers;

use App\Http\Controllers\Controller;
use App\Shop\Entity\User;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\DB;
use Illuminate\Support\Facades\Mail;
use Validator;  //驗證器
use Hash;       //雜湊

class UserAuthController extends Controller{

    //註冊頁
    public function signUpPage(){
    $binding = [
        'title' =>'註冊',
        ];
    return view('auth.signUp',$binding);
    }

    //處理註冊資料
    public function signUpProcess(){
        //接收輸入資料
        $input = request()->all();

        //驗證規則
        $rules = [
            //暱稱
            'nickname' =>[
                'required',
                'max:50',

            ],
            //Email
            'email'=>[
                'required',
                'max:150',
                'email',
            ],
            //密碼
            'password' =>[
                'required',
                'same:password_confirmation',
                'min:6',
            ],
            //密碼驗證
            'password_confirmation' =>[
                'required',
//                'min:6',
            ],
            //帳號類型
            'type'=>[
                'required',
                'in:G,A',

            ],

        ];



        //驗證資料
        $validator = Validator::make($input,$rules);

        //密碼加密
        $input['password'] = Hash::make($input['password']);

        if ($validator->fails()){
            //資料驗證錯誤
            return redirect('/user/auth/sign-up')
                ->withErrors($validator)
                ->withInput();
        }

        //新增會員資料
        $Users = User::create($input);

        //寄送註冊通知信
//        $mail_binding = [
//            'nickname' => $input['nickname']
//
//
//        ];
//        Mail::send('email.signUpEmailNotification', $mail_binding,
//        function($mail) use ($input){
//            //寄件人
//            $mail->to($input['email']);
//            //收件人
//            $mail->from('kj@kejyun.com');
//            //郵件主旨
//            $mail->subject('恭喜註冊 Shop Laravel 成功');
//
//        });




//        var_dump($input);
//        exit;
        return redirect('/user/auth/sign-in');
    }

    public function signInPage(){
        $binding = [
            'title' => '登入',
        ];
        return view('auth.signIn',$binding);

    }

    public function signInProcess(){
        //接收輸入資料
        $input = request()->all();

        //驗證規則
        $rules = [
            //Email
            'email' => [
                'required',
                'max:150',
                'email',
            ],
            //密碼
            'password' => [
                'required',
                'min:6',

            ],
        ];

        //驗證資料
        $validator = Validator::make($input, $rules);

        if($validator->fails()){
            //資料驗證錯誤
            return redirect('user/auth/sign-in')
                ->withErrors($validator)
                ->withInput();
        }

        //啟用紀錄 SQL 語法
//        DB::enableQueryLog();


        //撈取使用者資料
        $User = User::where('email',$input['email'])->firstOrFail();

//            列印出資料庫目前所有執行的 SQL 語法
//        var_dump(DB::getQueryLog());
//        exit;

        //檢查密碼是否正確
        $is_password_correct = Hash::check($input['password'],$User->password);

        if (!$is_password_correct){
            //密碼錯誤回傳錯誤訊息
            $error_message =[
                'msg' => [
                    '密碼驗證錯誤',

                ],

            ];


        return redirect('/user/auth/sign-in')
                ->withErrors($error_message)
                ->withInput();

        }

        //session 紀錄會員編號
        session()->put('user_id',$User->id);

        //重新導向到原先使用者造訪頁面，沒有嘗試造訪網頁則重新導向回首頁
        return redirect()->intended('/');
    }

    public function signOut(){
        //清除session
        session()->forget('user_id');

        //重新導向回首頁
        return redirect('/');

    }

}
