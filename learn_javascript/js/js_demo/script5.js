// 密碼檢驗程式

var password = 123456;
var input;

var entry_count= 0;
var entry_limit= 3;
var entry_out_of_limit= false;


while(password!=input && !entry_out_of_limit){
    entry_count++;
    if(entry_count<=entry_limit){
        input=prompt("請輸入密碼");
    }
    else{
        entry_out_of_limit = true;
    }

    

}

if(entry_out_of_limit){
    alert("超出登入次數");
}else{
    alert("登入成功");
}

