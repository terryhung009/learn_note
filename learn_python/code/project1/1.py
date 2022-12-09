from pytube import YouTube
# YouTube('https://youtu.be/9bZkp7q19f0').streams.first().download()
yt = YouTube(
    'https://www.youtube.com/watch?v=ZuGvSEY9e64&list=PLL26U2k-yzXtUSppbrYKYYiGDP2kHOaUC&index=6')
yt.streams.filter(res="1080p").first().download()
# ... .filter(progressive=True, file_extension='mp4')
# ... .order_by('resolution')
# ... .desc()
# ... .first()
# ... .download()
