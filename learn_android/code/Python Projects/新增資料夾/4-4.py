# -*- coding: utf-8 -*-
"""
Created on Fri Jan  8 01:21:40 2021

@author: terry
"""

import requests
from bs4 import BeautifulSoup
import time

today = time.strftime('%m/%d-5').lstrip('0')

def pttNBA(url):
    resp = requests.get(url)
    if resp.status_code != 200:
        print('URL發生錯誤：' + url)
        return
    
    soup = BeautifulSoup(resp.text, 'html5lib')
    paging = soup.find('div', 'btn-group btn-group-paging').find_all('a')[1]['href']
    
    articles = []
    rents = soup.find_all('div', 'r-ent')
    for rent in rents:
        title = rent.find('div', 'title').text.strip()
        count = rent.find('div', 'nrec').text.strip()
        date = rent.find('div', 'meta').find('div', 'date').text.strip()
        article = '%s:%s  :%s' % (title , count , date)
        
        try:
            if today == date and int(count) > 1:
                articles.append(article)
        except:
            if today == date and count == '爆':
                articles.append(article)
    
    if len(articles) != 0:
        for article in articles:
            print(article)
        pttNBA('https://www.ptt.cc' + paging)
    else:
        return
    
pttNBA('https://www.ptt.cc/bbs/NBA/index.html')
