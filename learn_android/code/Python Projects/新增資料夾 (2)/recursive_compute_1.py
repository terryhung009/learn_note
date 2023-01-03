def recursive_compute_sum(list):
	if len(list) == 0:
		return 0

	else:
		first = list[0]
		rest = list[1:]
		sum = first + recursive_compute_sum(rest)
		return sum
		
recursive_compute_sum([1,2,3])
	