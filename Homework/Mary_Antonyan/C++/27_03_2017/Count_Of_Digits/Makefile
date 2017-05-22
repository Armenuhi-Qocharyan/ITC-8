all: digits

digits: main.o functions.o
	g++ main.cpp functions.cpp -o digits

main.o: main.cpp functions.hpp
	g++ -c main.cpp

functions.o: functions.cpp functions.hpp
	g++ -c functions.cpp

clean:
	rm *.o digits
