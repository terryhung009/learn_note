// 物件 object

var person ={
    name:"小白",
    age:23,
    is_male:true,
    print_name:function(){
        document.write(this.name);
    }

};

// document.write(person.name);

person.print_name();