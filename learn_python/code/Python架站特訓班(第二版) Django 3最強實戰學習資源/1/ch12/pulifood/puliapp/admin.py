from django.contrib import admin
from puliapp.models import maplist

class maplistAdmin(admin.ModelAdmin):
    list_display=('mapName','mapDesc','mapLat','mapLng','mapTel','mapAddr')

admin.site.register(maplist,maplistAdmin)
