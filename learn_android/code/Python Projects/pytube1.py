Python 3.9.1 (tags/v3.9.1:1e5d33e, Dec  7 2020, 17:08:21) [MSC v.1927 64 bit (AMD64)] on win32
Type "help", "copyright", "credits" or "license()" for more information.
>>>

from pytube import YouTube

url =input('https://www.youtube.com/watch?v=xnvj0gkrgss')
print('下載 來自'+url+' 的youtube影片中...')
YouTube(url).streams.first().download()