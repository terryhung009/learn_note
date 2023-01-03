# -*- coding: utf-8 -*-
"""
Created on Mon Jan 11 22:32:24 2021

@author: terry
"""

import sqlite3

conn = sqlite3.connect('./test.db')
try:
    info = []
    cur = conn.cursor()
    rows = cur.execute('select * from person')
    for row in rows:
        id = row[0]
        height = row[3]
        weight = row[2]
        bmi = round(weight/height**2, 2)
        print(id,height,weight,bmi)
        info.append([bmi,id])
    for data in info:
        cur.execute('update person set bmi=%d where id=%d' % (data[0],data[1]))
    conn.commit()
    
    
finally:
    conn.close()