PROG=hashtable
CC=g++
FLAGS=-std=c++11

all: $(PROG)

$(PROG): main.o hashtable.o linkedlist.o vector.o
	$(CC) $(FLAGS) main.o hashtable.o linkedlist.o vector.o -o $(PROG)

main.o: main.cpp 
	$(CC) -c $(FLAGS) main.cpp 

hashtable.o: hashtable.cpp hashtable.hpp
	$(CC) -c $(FLAGS) hashtable.cpp

linkedlist.o: linkedlist.cpp linkedlist.hpp
	$(CC) -c $(FLAGS) linkedlist.cpp

vector.o: vector.cpp vector.hpp
	$(CC) -c $(FLAGS) vector.cpp

clean:
	rm -f *.o $(PROG)
