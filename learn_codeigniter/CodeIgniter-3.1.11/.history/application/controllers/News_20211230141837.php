<?php
class News extends CI_Controller
{
    public function __construct()
    {
        parent::__construct();
        $this->load->model('news_model');
    }
    public function index()
    {
        $data['news'] = $this->news_model->get_news();
        $data['title'] = 'News archive';

        $this->load->view('temp/header', $data);
        $this->load->view('news/index', $data);
        $this->load->view('temp/footer');
    }
    public function view($slug)
    {
        $data['news'] = $this->news_model->get_news($slug);
    }
}