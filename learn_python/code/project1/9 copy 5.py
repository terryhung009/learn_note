from pytube import YouTube
# YouTube('https://youtu.be/9bZkp7q19f0').streams.first().download()
yt = YouTube(
    'https://www.youtube.com/watch?v=hOTGl1ku87k')
yt.streams.filter(res="1080p").first().download()
# ... .filter(progressive=True, file_extension='mp4')
# ... .order_by('resolution')
# ... .desc()
# ... .first()
# ... .download()
