all: overlap

overlap: main.o rectangle.o circle.o point.o functions.o
	g++ main.cpp rectangle.cpp circle.cpp point.cpp functions.cpp -o overlap

main.o: main.cpp rectangle.cpp rectangle.hpp circle.cpp circle.hpp point.cpp point.hpp functions.cpp
	g++ -c main.cpp rectangle.cpp circle.cpp point.cpp functions.cpp

functions.o: rectangle.cpp rectangle.hpp circle.cpp circle.hpp point.cpp point.hpp functions.cpp functions.hpp
	g++ -c rectangle.cpp circle.cpp point.cpp

rectangle.o: rectangle.cpp rectangle.hpp circle.cpp circle.hpp point.cpp point.hpp
	g++ -c rectangle.cpp circle.cpp point.cpp

circle.o: circle.cpp circle.hpp point.cpp point.hpp
	g++ -c circle.cpp point.cpp

point.o: point.cpp point.hpp
	g++ -c point.cpp

clean:
	rm *.o overlap
