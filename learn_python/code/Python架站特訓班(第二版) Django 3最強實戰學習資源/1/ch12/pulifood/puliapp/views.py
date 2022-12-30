from django.shortcuts import render, redirect
from django.contrib.auth import authenticate
from datetime import datetime
from puliapp.models import maplist
from django.contrib import auth
from django.core.paginator import Paginator, EmptyPage, PageNotAnInteger

def index(request):
	all=maplist.objects.all()  #取得所有景點
	return render(request, "index.html", locals())
	
def login(request):  #登入
	messages = ''  #初始時清除訊息
	if request.method == 'POST':  #如果是以POST方式才處理
		name = request.POST['username'].strip()  #取得輸入帳號
		password = request.POST['password']  #取得輸入密碼
		user1 = authenticate(username=name, password=password)  #驗證
		if user1 is not None:  #驗證通過
			if user1.is_active:  #帳號有效
				auth.login(request, user1)  #登入
				return redirect('/adminmain/')  #開啟管理頁面
			else:  #帳號無效
				message = '帳號尚未啟用！'
		else:  #驗證未通過
			message = '登入失敗！'
	return render(request, "login.html", locals())
		
def logout(request):  #登出
	auth.logout(request)
	return redirect('/index/')

def adminmain(request):  #管理首頁
	map_list = maplist.objects.all().order_by('-id')  #遞減排序取得所有景點
	paginator = Paginator(map_list, 6)  #每頁資料筆數
	page = request.GET.get('page')  #取得目前頁數
	try:
		maps = paginator.page(page)
	except PageNotAnInteger:  #若頁數非整數就顯示第1頁
		maps = paginator.page(1)
	except EmptyPage:  #若頁數超出範圍就顯示最後1頁
		maps = paginator.page(paginator.num_pages)
	return render(request, "adminmain.html", locals())

def adminadd(request):  #新增景點
	if ('mapName' in request.POST):  #按確定新增鈕
		name = request.POST['mapName']
		desc = request.POST['mapDesc']   
		lat = request.POST['mapLat']
		lng = request.POST['mapLng']
		tel = request.POST['mapTel']
		addr = request.POST['mapAddr']
		rec=maplist(mapName=name,mapDesc=desc,mapLat=lat,mapLng=lng,mapTel=tel,mapAddr=addr)  #建立資料記錄
		rec.save()  #寫入資料表
		return redirect('/adminmain/')
	return render(request, "adminadd.html", locals())
	
def adminedit(request,editid=None):  #修改景點資料
	if editid != None:  #管理首頁按編輯鈕
		rec=maplist.objects.get(id=editid)  #取得景點資料
		return render(request, "adminedit.html", locals())
	else:  #按確定更新鈕
		editid1 =request.POST['editid']  #取得景點編號
		rec=maplist.objects.get(id=editid1)  #取得景點資料
		rec.mapName=request.POST['mapName']  #取得景點欄位值
		rec.mapDesc=request.POST['mapDesc'] 
		rec.mapLat=request.POST['mapLat'] 
		rec.mapLng=request.POST['mapLng'] 
		rec.mapTel=request.POST['mapTel'] 
		rec.mapAddr=request.POST['mapAddr']	
		rec.save()	#寫入資料庫
		return redirect('/adminmain/')
	
def admindelete(request):  #刪除景點
	delid=request.GET['id']  #取得景點編號
	rec=maplist.objects.get(id=delid)  #取得景點資料
	rec.delete()  #刪除景點資料
	return redirect('/adminmain/')   

