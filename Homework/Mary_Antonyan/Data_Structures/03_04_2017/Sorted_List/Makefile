PROG=list
CC=g++
FLAGS=-std=c++11

all: $(PROG)

$(PROG): main.o sortedlist.o rectangle.o
	$(CC) $(FLAGS) main.o sortedlist.o rectangle.o -o $(PROG)

main.o: main.cpp sortedlist.hpp
	$(CC) -c $(FLAGS) main.cpp 

sortedlist.o: sortedlist.cpp sortedlist.hpp
	$(CC) -c $(FLAGS) sortedlist.cpp

rectangle.o: rectangle.cpp rectangle.hpp
	$(CC) -c $(FLAGS) rectangle.cpp

clean:
	rm -f *.o $(PROG)
