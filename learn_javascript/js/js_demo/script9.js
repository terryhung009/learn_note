// class

class Phone{
    constructor(number, year,is_waterproof){
        this.number = number;
        this.year = year;
        this.is_waterproof = is_waterproof;

    }
    phone_age(){
        return 2021 - this.year;


    }
}

var phone1 = new Phone("123",2020,false);
var phone2 = new Phone("456",2019,false);
// document.write(phone1.phone_age());
document.write(phone2.number); 