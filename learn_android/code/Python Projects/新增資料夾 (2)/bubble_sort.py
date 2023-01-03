def bubble_sort(scores):
	swapped =True
	
	while swapped:
		swapped = False
		for i in range(0, len(scores)-1):
			if scores[i] > scores[i+1]:
				temp = scores[i]
				scores[i] =scores[i+1]
				scores[i+1] = temp
				swapped = True

				
if  __name__ == "__main__" :
	scores = [60 , 50 , 60 , 58 , 54 , 54]
	bubble_sort(scores)
	print(scores)