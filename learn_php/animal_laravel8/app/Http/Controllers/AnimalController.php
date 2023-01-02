<?php

namespace App\Http\Controllers;

use App\Models\Animal;
use Illuminate\Http\Request;
use Symfony\Component\HttpFoundation\Response;
use  Illuminate\Support\Facades\Cache;

class AnimalController extends Controller
{
    /**
     * Display a listing of the resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function index(Request $request)
    {
        //使用網址設定為快取檔案名稱
        //取得網址
        $url = $request->url();
        //取得query的參數 例如：?limit=5&page=2 網址問號後面的參數
        $queryParams = $request->query();

        //每個人請求的query參數順序可能不同，使用參數第一個英文字排序
        ksort($queryParams);

        //利用htpp_build_query方法將查詢參數轉為字串
        $queryString = http_build_query($queryParams);

        //組合成完整網址
        $fullUrl = "{$url}?{$queryString}";

        //使用 Laravel的快取方法檢查是否有快取紀錄
        if(Cache::has($fullUrl)){
            //使用 return 直接回傳快取資料，不做其他程式邏輯
            return Cache::get($fullUrl);
        }



        //設定預設值
        $limit = $request ->limit ?? 10;

        //建立查詢建構器，分段的方式撰寫SQL語句。
        $query = Animal::query();

        //篩選程式邏輯，如果有設定filters參數
        if(isset($request->filters)){
            $filters = explode(',', $request->filters);
            foreach ($filters as $key =>$filter){
                list($key , $value) = explode(':', $filter);
                $query->where($key, 'like', "%$value");
            }
        }

        //排序順序
        if(isset($request->sorts)){
            $sorts = explode(',',$request->sorts);
            foreach ($sorts as $key => $sort){
                list($key, $value) = explode(':', $sort);
                if($value == 'asc' || $value == 'dsc'){
                    $query->orderBy($key, $value);
                }

            }


        }else{
            //將原本的排序方法移至這裡，如果沒有設定條件，預設id大到小
            $query->orderBy('id','desc');
        }



        $animals = Animal::orderBy('id','desc')
            ->paginate($limit) // 使用分頁方法，最多回傳$limit筆資料
            ->appends($request->query());

        //沒有快取紀錄記住資料，並設定60秒過期，快取名稱使用網址命名。
        return Cache::remember($fullUrl , 60 ,function() use ($animals){
            return response($animals, Response::HTTP_OK);
        });

        



        // //設定預設值
        // $limit = $request ->limit ?? 10;
        // //使用Model orderBy方法加入SQL語法排序條件，依照 id由大到小排序
        // $animals = Animal::orderBy('id','desc')
        //     ->paginate($limit) // 使用分頁方法，最多回傳$limit筆資料
        //     ->appends($request->query());

        // return response($animals, Response::HTTP_OK);    

        //
        // $animals = Animal::get();
        // return response(['data' => $animals], Response::HTTP_OK);
    }

    /**
     * Show the form for creating a new resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function create()
    {
        //
    }

    /**
     * Store a newly created resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @return \Illuminate\Http\Response
     */
    public function store(Request $request)
    {
        $this->validate($request,[
            //允許null 或 整數
            'type_id' => 'nullable|integer',   

             //必填文字最多255字元
            'name' => 'required|string|max:255',   

            //允許null或日期格式，使用php strtotime檢查傳入的日期字串
            'birthday' => 'nullable|date',

            //允許null 或文字 最多255字元
            'area' => 'nullable|string|max:255',

            //必填並且為布林值
            'fix' => 'required|boolean',

            //允許null
            'description' => 'nullable',

            //允許null
            'personality' => 'nullable'



        ]);
        
        /**
         * 一般來說不需要會員輸入自己的ID建立動物資源，而是使用登入狀態判斷，
         * 後續將於身分驗證章節修改這邊的內容，先將user_id強制寫成1寫入資料庫
         * 
         * 
         * 
         */
        $request['user_id'] = 1;
        


        //
        $animal = Animal::create($request->all());
        $animal = $animal->refresh();
        return response($animal, Response::HTTP_CREATED);
    }

    /**
     * Display the specified resource.
     *
     * @param  \App\Models\Animal  $animal
     * @return \Illuminate\Http\Response
     */
    public function show(Animal $animal)
    {
        //
        return response($animal, Response::HTTP_OK);

    }

    /**
     * Show the form for editing the specified resource.
     *
     * @param  \App\Models\Animal  $animal
     * @return \Illuminate\Http\Response
     */
    public function edit(Animal $animal)
    {
        //
    }

    /**
     * Update the specified resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @param  \App\Models\Animal  $animal
     * @return \Illuminate\Http\Response
     */
    public function update(Request $request, Animal $animal)
    {
        //
        $animal->update($request->all());
        return response($animal, Response::HTTP_OK);
    }

    /**
     * Remove the specified resource from storage.
     *
     * @param  \App\Models\Animal  $animal
     * @return \Illuminate\Http\Response
     */
    public function destroy(Animal $animal)
    {
        //
        $animal->delete();
        return response(null,Response::HTTP_NO_CONTENT);
    }
}
