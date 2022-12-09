from pytube import YouTube
# YouTube('https://youtu.be/9bZkp7q19f0').streams.first().download()
yt = YouTube(
    'https://www.youtube.com/watch?v=0DXhog9-V0M')
yt.streams.filter(res="1080p").first().download()
# ... .filter(progressive=True, file_extension='mp4')
# ... .order_by('resolution')
# ... .desc()
# ... .first()
# ... .download()
