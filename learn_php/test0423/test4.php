<?php
// 考題4: 請解釋底下這兩行Cron 指令所代表的意思?
// [user]$ crontab -l
// 0 2 * * * php /var/www/html/mshop/releaseSession.php

// [user]$ crontab -l =>
// 使用user帳號 查看自己的 crontab


// 0 2 * * * =>
// 每日02時整點執行一次

//php /var/www/html/mshop/releaseSession.php
//執行該路徑中的releaseSession.php檔案