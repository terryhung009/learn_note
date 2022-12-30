<?php
$json = '{
  	"STATUS": 200,
  	"DATA": {
  		"ERROR": 0,
  		"MESSAGE": "Hello",
  		"SUCCESS": 1,
  		"erpkey": "2111LV11MD0Y_X_A01AR2111",
  		"EMAIL": "zzz@zzz.com"
  	}
  }
';

$data = json_decode($json);

$value = $data->DATA->erpkey;

echo $value;

