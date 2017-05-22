PROG=vector
CC=g++
FLAGS=-std=c++11

all: $(PROG)

$(PROG): main.o vector.o
	$(CC) $(FLAGS) main.o vector.o -o $(PROG)

main.o: main.cpp vector.hpp
	$(CC) -c $(FLAGS) main.cpp

vector.o: vector.cpp vector.hpp
	$(CC) -c $(FLAGS) vector.cpp

clean:
	rm -f *.o $(PROG)
