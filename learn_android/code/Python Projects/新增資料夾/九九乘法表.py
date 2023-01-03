# -*- coding: utf-8 -*-
"""
Created on Fri Jan  8 01:17:05 2021

@author: terry
"""

# 7-7.py

for i in range(2,9):
    if i !=2 and i !=6 : continue
    for j in range(1,10):
        for k in range(i,i+2):
            print("{}x{}={:>2}     ".format(k,j,k*j),end="")
        print()
    print()