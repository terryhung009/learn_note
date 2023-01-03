// 函式 function

function max_num(num1,num2,num3){
    if(num1>=num2 && num1>=num3){
        return num1;
    }
    else if(num2>=num1 &&num2>=num3){
        return num2;

    }else{
        return num3;
    }


}

document.write(max_num(2,5,88)) ;