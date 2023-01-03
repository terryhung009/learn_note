# -*- coding: utf-8 -*-
"""
Created on Sat Jan  9 21:21:29 2021

@author: terry
"""

marbles = [ 10 , 13 , 39 , 14 , 41 , 9 , 3 ]

def recursive_compute_sum(list):
    if len(list) == 0:
        return 0
    else:
        first = list[0]
        rest = list[1:]
        sum = first + recursive_compute_sum(rest)
        return sum
    
sum = recursive_compute_sum(marbles)
print("The total is",sum)