<?php

namespace App\Traits;

trait ApiResponseTrait
{
    /*
    *定義統一例外回應方法
    *
    *@param mixed $message 錯誤訊息
    *@param mixed $status HTTP狀態碼
    *@parammixed|null $code 選填、自訂義錯誤編號
    *@return \Illuminate\Http\Response
    *
    */

    public function errorResponse($message, $status, $code = null)
    {
        $code = $code ?? $status; //$code為null時預設HTTP狀態碼

        return response()->json(
            [
                'message' => $message,
                'code' => $code,
            ],
            $status
        );
    }
}