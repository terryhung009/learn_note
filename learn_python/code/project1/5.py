from pytube import YouTube
# YouTube('https://www.youtube.com/watch?v=ZuGvSEY9e64').streams.first().download()

yt = YouTube(
    'https://www.youtube.com/watch?v=ZuGvSEY9e64')
print("開始下載影片")
yt.streams.get_highest_resolution().download()
print("影片下載完成")
# yt.streams.filter(res="1080p").first().download()
# ... .filter(progressive=True, file_extension='mp4')
# ... .order_by('resolution')
# ... .desc()
# ... .first()
# ... .download()

# from pytube import YouTube
# YouTube('https://youtu.be/2lAe1cqCOXo').streams.filter(res="1080p").first().download()
# yt = YouTube('http://youtube.com/watch?v=2lAe1cqCOXo')
# yt.streams.filter(res="1080p").first().download()
#   ... .filter(progressive=True, file_extension='mp4')
#   ... .order_by('resolution')
#   ... .desc()
#   ... .first()
#   ... .download()
