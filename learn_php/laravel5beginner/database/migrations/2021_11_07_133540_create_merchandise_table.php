<?php

use Illuminate\Support\Facades\Schema;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Database\Migrations\Migration;

class CreateMerchandiseTable extends Migration
{
    /**
     * Run the migrations.
     *
     * @return void
     */
    public function up()
    {
        Schema::create('merchandise', function (Blueprint $table) {
            //商品編號
            $table->increments('id');
            //商品狀態
            //C(Create):建立中
            //S(Sell):可販售
            $table->string('status',1)->default('C');
            //商店名稱
            $table->string('name',80)->nullable();
            //商品英文名稱
            $table->string('name_en',80)->nullable();
            //商品介紹
            $table->text('introduction');
            //商品介紹英文
            $table->text('introduction_en');
            //商品照片
            $table->string('photo',50)->nullable();
            //價格
            $table->integer('price')->default(0);
            //商品剩餘數量
            $table->integer('remain_count')->default(0);
            //時間戳記
            $table->timestamps();

            //索引設定
            $table->index(['status'],'merchandise_status_idx');



        });
    }

    /**
     * Reverse the migrations.
     *
     * @return void
     */
    public function down()
    {
        Schema::dropIfExists('merchandise');
    }
}
