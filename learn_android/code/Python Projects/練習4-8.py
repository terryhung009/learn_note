# -*- coding: utf-8 -*-
"""
Created on Tue Jan  5 17:08:01 2021

@author: terry
"""

from selenium import webdriver
from bs4 import BeautifulSoup
import time
import random

url = 'http://insider.espn.com/nba/hollinger/statistics/_/page/'

try:
    options = webdriver.ChromeOptions()
    
    chrome = webdriver.Chrome(options=options,
                             executable_path='./chromedriver')
    chrome.set_page_load_timeout(10)
    for i in range(1, 2):
        _url = url + str(i)
        print(_url)
        chrome.get(_url)
        soup = BeautifulSoup(chrome.page_source, 'html5lib')
        trs = soup.find('tbody').find_all('tr')
        for tr in trs:
            tds = [td for td in tr.children]
            rk = tds[0].text.strip()
            if rk =='RK' or len(tds)<2:
                continue
            name = tds[1].text
            per = tds[11].text
            print('%s :%s' % (name, per))
        wait = random.randint(2,6)
        print('wait time : %d' % wait)
        time.sleep(wait)
    
    
finally:
    chrome.quit()