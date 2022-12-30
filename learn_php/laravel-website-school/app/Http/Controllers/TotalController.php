<?php

namespace App\Http\Controllers;


use Illuminate\Http\Request;
use App\Models\Total;


class TotalController extends Controller
{
    //
    public function index()
    {
        //
        $total = Total::first();
        // dd($all);
        $cols = ['進站總人數'];
        $rows =
            [
                [
                    'text' => $total->total,
                ],

                [
                    'tag' => 'button',
                    'type' => 'button',
                    'btn_color' => 'btn-info',
                    'action' => 'edit',
                    'id' => $total->id,
                    'text' => '編輯',

                ],
            ];



        // dd($rows);

        //使用物件導向繼承controller.php
        $this->view['header'] = '進站總人數管理';
        $this->view['module'] = 'Total';
        $this->view['cols'] = $cols;
        $this->view['rows'] = $rows;   
        return view('backend.module', $this->view);


        // $view = [
        //     'header' => '進站總人數管理',
        //     'module' => 'Total',
        //     'cols' => $cols,
        //     'rows' => $rows,
        // ];
        // return view('backend.module', $view);
    }

    /**
     * Show the form for editing the specified resource.
     *
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function edit($id)
    {
        //
        $total = Total::find($id);
        $view = [
            'action' => '/admin/total/' . $id,
            'method' => 'PATCH',
            'modal_header' => "編輯進站總人數",
            'modal_body' => [

                [
                    'label' => '進站總人數',
                    'tag' => 'input',
                    'type' => 'number',
                    'name' => 'total',
                    'value' => $total->total
                ],
            ],
        ];
        return view(" modals.base_modal", $view);
    }

    /**
     * Update the specified resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function update(Request $request, $id)
    {
        //
        $total = Total::find($id);
        // if ($request->hasFile('img') && $request->file('img')->isValid()) {

        //     $request->file('img')->storeAs('public', $request->file('img')->getClientOriginalName());

        //     $title->img = $request->file('img')->getClientOriginalName();
        // }

        if ($total->total != $request->input('total')) {
            $total->total = $request->input('total');
            $total->save();
        }






        // $title=Title::where("id",$id)->get();

        return redirect('admin/total');
        // return redirect('/admin/title');
    }









}
