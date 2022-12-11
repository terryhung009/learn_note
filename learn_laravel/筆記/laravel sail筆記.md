## laravel sail筆記

[【入门教程】10 分钟学习 Laravel Sail 并建立开发环境](https://www.youtube.com/watch?v=wJUHe4iof7w&ab_channel=Dogcomp)

於ubuntu中輸入
curl -s https://laravel.build/test-project | bash

安裝好後，ubuntu中輸入
./vendor/bin/sail up -d

nano ~/.bashrc
將alias加在底部

alias sail='bash vendor/bin/sail'

. ~/.bashrc

sail up -d

sail artisan migrate

連接資料庫

ip:localhost
username:sail
password:password

使用vscode開啟

code .


