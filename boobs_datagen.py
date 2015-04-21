#!/usr/bin/python

import random


def main():
	N_POINTS = 100

	MIN_IQ = 50
	MAX_IQ = 150

	MAX_BOOBS_SIZE = 5
	MIN_BOOBS_SIZE = 1

	MAX_DEVIATION_AMPLITUDE = 2

	#line equations used: y=ax+b
	a = (MIN_BOOBS_SIZE - MAX_BOOBS_SIZE) / float(MAX_IQ - MIN_IQ)
	b = -((MIN_BOOBS_SIZE - MAX_BOOBS_SIZE) / float(MAX_IQ - MIN_IQ)) * MIN_IQ + MAX_BOOBS_SIZE

	

	DATA_TEMPLATE_STR = ("@relation boobsDependingOnIQ\n\n"
							"@attribute 'boobsSize' {0, 1, 2, 3, 4, 5}\n"
							"@attribute 'IQ' NUMERIC\n\n"
							"@data")

	data = []
	for i in range(N_POINTS):
		x = random.uniform(MIN_IQ, MAX_IQ)
		deviation = random.uniform(-MAX_DEVIATION_AMPLITUDE, MAX_DEVIATION_AMPLITUDE)
		y = round(a * x + b + deviation)
		data.append({"x": x, "y": y})



	output = open("data/boobs_dataset_1.arff", "w")
	output.write(DATA_TEMPLATE_STR)

	for point in data:
		output.write(str(point["y"]) + ", " + str(point["x"]) + "\n")

	output.close()

if __name__ == '__main__':
	main()