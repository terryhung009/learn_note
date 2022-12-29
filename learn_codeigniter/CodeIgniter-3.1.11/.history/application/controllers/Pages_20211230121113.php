<?php
defined('BASEPATH') OR exit('No direct script access allowed');
class Pages extends CI_Controller {

	public function view($page = 'home')
	{
        if ( ! file_exists('application/views/'.$page.'.php'))
	{
		// 哇勒!我們沒有這個頁面!
		show_404();
	}
	
	$data['title'] = ucfirst($page); // 第一個字母大寫
	
	$this->load->view('temp/header', $data);
	$this->load->view($page, $data);
	$this->load->view('temp/footer', $data);
	}
}