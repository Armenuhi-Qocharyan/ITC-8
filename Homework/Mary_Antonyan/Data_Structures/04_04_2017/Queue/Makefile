PROG=queue
CC=g++
FLAGS=-std=c++11

all: $(PROG)

$(PROG): main.o linkedlist.o queue.o
	$(CC) $(FLAGS) main.o linkedlist.o queue.o -o $(PROG)

main.o: main.cpp queue.hpp
	$(CC) -c $(FLAGS) main.cpp 

linkedlist.o: linkedlist.cpp linkedlist.hpp
	$(CC) -c $(FLAGS) linkedlist.cpp

queue.o: queue.cpp queue.hpp
	$(CC) -c $(FLAGS) queue.cpp

clean:
	rm -f *.o $(PROG)
