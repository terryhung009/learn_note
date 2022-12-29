<?php
defined('BASEPATH')or http_response_code(403);

class Url extends CI_Controller {
    public function __construct() //建構子
    {
        parent::__construct();
        $this->load->helper('url');
    }
    public function add()
    {
        $db = $this->load->database('default',true); //設定資料庫連線
        if (!isset($_POST['url'])) { //有沒有自訂url，沒有就亂數生一個
            $url = substr(
                md5(
                    uniqid("",true).rand()
                )
            ,0,6);
        } else if ($_POST['url'] == '') { //有沒有自訂url，沒有就亂數生一個
            $url = substr(
                md5(
                    uniqid("",true).rand()
                )
                ,0,6);
        } else {
            $urlExistQuery = $db //檢查url是否被占用
                ->from('urls')
                ->where('url_shorten',$_POST['url'])
                ->get();
            if ($urlExistQuery -> num_rows() > 0) { //已被占用
                http_response_code(409,'The url has been used'); //HTTP 409 Conflict (衝突)
                print_r(
                    json_encode(
                        array(
                            'error' => 409,
                            'message' => 'The url has been used, try another one.',
                            'url' => $_POST['url']
                        )
                    )
                );
                die();
            } else {
                $url = $_POST['url'];
            }
        }
        $dbdata = array( //設定資料值
            'url_shorten' => $url,
            'url_dest' => $_POST['dest'],
        );
        if (isset($_POST['comment']) && $_POST['comment'] != null) { //設定資料值(備註)
            $dbdata['comment'] = $_POST['comment'];
        }
        $db->insert('urls',$dbdata); //執行插入資料庫
        http_response_code(201); //HTTP201 Created(已新增)
        print_r(
            json_encode(
                array(
                    'status' => 'success',
                    'code' => 201,
                    'id' => $db->insert_id(),
                    'message' => 'Finish without mistake.',
                    'url' => base_url().$url,
                )
            )
        );
    }
}