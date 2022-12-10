<?php

namespace app;

class Router
{
    public array $getRoutes = [];
    public array $postRoutes = [];

    public function get($url, $fn)
    {
        $this->getRoutes[$url] = $fn;
    }

    public function post($url, $fn)
    {
        $this->postRoutes[$url] = $fn;
    }

    public function resolve()
    {
        // echo '<pre>';
        // echo var_dump($_SERVER);
        // echo '</pre>';
        $currentUrl = $_SERVER['PATH_INFO'] ?? '/';
        $method = $_SERVER["REQUEST_METHOD"];

        if ($method == 'GET') {
            $fn = $this->getRoutes[$currentUrl] ?? null;
        } else {
            $fn = $this->postRoutes[$currentUrl] ?? null;
        }
        // echo '<pre>';
        // echo var_dump($fn);
        // echo '</pre>';

        if ($fn) {
            echo '<pre>';
            echo var_dump($fn);
            echo '</pre>';
        } else {
            echo "Page not found";
        }
    }
}
