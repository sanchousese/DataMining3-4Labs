#!/usr/bin/python

import random

def normilize_boobs_size(src_size, min_size, max_size):
	src_size = round(src_size)
	if (src_size > max_size):
		return max_size
	elif (src_size < min_size):
		return min_size
	else:
		return src_size



def main():
	N_POINTS = 100

	MIN_IQ = 50
	MAX_IQ = 150

	MAX_BOOBS_SIZE = 5
	MIN_BOOBS_SIZE = 0

	MAX_DEVIATION_AMPLITUDE = 1

	#line equations used: y=ax+b
	a = (MIN_BOOBS_SIZE - MAX_BOOBS_SIZE) / float(MAX_IQ - MIN_IQ)
	b = -((MIN_BOOBS_SIZE - MAX_BOOBS_SIZE) / float(MAX_IQ - MIN_IQ)) * MIN_IQ + MAX_BOOBS_SIZE

	

	DATA_TEMPLATE_STR = ("@relation boobsDependingOnIQ\n\n"
							"@attribute 'boobsSize' {0, 1, 2, 3, 4, 5}\n"
							"@attribute 'IQ' NUMERIC\n\n"
							"@data\n")

	data = []
	for i in range(N_POINTS):
		x = round(random.uniform(MIN_IQ, MAX_IQ))
		deviation = random.uniform(-MAX_DEVIATION_AMPLITUDE, MAX_DEVIATION_AMPLITUDE)
		y = normilize_boobs_size(a * x + b + deviation, MIN_BOOBS_SIZE, MAX_BOOBS_SIZE)
		data.append({"x": int(x), "y": int(y)})



	output = open("data/boobs_dataset_1.arff", "w")
	output.write(DATA_TEMPLATE_STR)

	for point in data:
		output.write(str(point["y"]) + ", " + str(point["x"]) + "\n")

	output.close()

if __name__ == '__main__':
	main()