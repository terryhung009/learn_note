<?php

namespace App\Http\Controllers;

use App\Animal;
use Illuminate\Http\Request;
use Symfony\Component\HttpFoundation\Response;
use App\Http\Resources\AnimalResource;
use Illuminate\Support\Facades\Auth;
//use Auth;

class AnimalController extends Controller
{
    /**
     * Display a listing of the resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function index(Request $request)
    {
        //
//        $animals = Animal::get();
//        return response(['animals' => $animals], Response::HTTP_OK);


        // 設定預設值
//        $marker = $request->marker==null ? 1:$request->marker;
//        $limit = $request->limit==null ? 10:$request->limit;
//
//        $animals = Animal::orderBy('id', 'asc')
//            ->where('id', '>=', $marker)
//            ->paginate($limit);
//
//        return response($animals, Response::HTTP_OK);

        // 設定預設值

//        $marker = isset($request->marker) ? $request->marker : 1;
//        $limit = isset($request->limit) ? $request->limit : 10;
//
//        $query = Animal::query();
//
//        // 篩選欄位條件
//        if (isset($request->filters)) {
//            $filters = explode(',', $request->filters);
//            foreach ($filters as $key => $filter) {
//                list($criteria, $value) = explode(':', $filter);
//                $query->where($criteria, 'like', "%$value%");
//
//            }
//        }
//
//        $animals = $query->where('id', '>=', $marker)->paginate($limit);
//
//        return response($animals, Response::HTTP_OK);

        // 設定預設值

        $marker = isset($request->marker) ? $request->marker : 1;
        $limit = isset($request->limit) ? $request->limit : 10;

        $query = Animal::query();

        // 篩選欄位條件
        if (isset($request->filters)) {
            $filters = explode(',', $request->filters);
            foreach ($filters as $key => $filter) {
                list($criteria, $value) = explode(':', $filter);
                $query->where($criteria, $value);
            }
        }

        //排列順序
        if (isset($request->sort)) {
            $sorts = explode(',', $request->sort);
            foreach ($sorts as $key => $sort) {
                list($criteria, $value) = explode(':', $sort);
                if ($value == 'asc' || $value == 'desc') {
                    $query->orderBy($criteria, $value);
                }
            }
        } else {
            $query->orderBy('id', 'asc');
        }

        $animals = $query->where('id', '>=', $marker)->paginate($limit);

        return response($animals, Response::HTTP_OK);
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

        $this->validate($request, [
            'type_id' => 'required',
            'name' => 'required|max:255',
            'birthday' => 'required|date',
            'area' => 'required|max:255',
            'fix' => 'required|boolean',
            'description' => 'nullable',
            'personality' => 'nullable'
        ]);
        //
        //Animal Model 有 create 寫好的方法，把請求的內容，
        //用all方法轉為陣列，傳入 create 方法中。
        $animal = Animal::create($request->all());

        // 回傳 animal 產生出來的實體物件資料，第二個參數設定狀態碼，
        //可以直接寫 201 表示創建成功的狀態碼或用下面 Response 功能

        return response($animal, Response::HTTP_CREATED);
    }

    /**
     * Display the specified resource.
     *
     * @param  \App\Animal  $animal
     * @return \Illuminate\Http\Response
     */
    public function show(Animal $animal)
    {
        //
//        return response($animal, Response::HTTP_OK);

        return response(new AnimalResource($animal), Response::HTTP_OK);
    }

    /**
     * Show the form for editing the specified resource.
     *
     * @param  \App\Animal  $animal
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
     * @param  \App\Animal  $animal
     * @return \Illuminate\Http\Response
     */
    public function update(Request $request, Animal $animal)
    {
        //
        $this->authorize('update', $animal);
        $animal->update($request->all());
        return response($animal, Response::HTTP_OK);
    }

    /**
     * Remove the specified resource from storage.
     *
     * @param  \App\Animal  $animal
     * @return \Illuminate\Http\Response
     */
    // 路由有設定 animal 變數，這裡設定它是 Animal 模型，所以
    //會自動找出該ID的實體物件
    public function destroy(Animal $animal)
    {
        //
        // 把這個實體物件刪除
        $animal->delete();
        // 回傳 null 並且給予 204 狀態碼
        return response(null, Response::HTTP_NO_CONTENT);


    }

    public function __construct()
    {
        $this->middleware('auth:api', ['except' => ['index','show']]);
    }

    /**
     * 動物加入或移除我的最愛
     *
     * @param  \App\Animal  $animal
     * @return \Illuminate\Http\Response
     */
    public function like(Animal $animal)
    {
        $animal->like()->toggle(Auth::user()->id);

        return response(null, Response::HTTP_NO_CONTENT);
    }
}
