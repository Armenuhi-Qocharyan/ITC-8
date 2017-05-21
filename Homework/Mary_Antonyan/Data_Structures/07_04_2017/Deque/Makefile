PROG=deque
CC=g++
FLAGS=-std=c++11

all: $(PROG)

$(PROG): main.o linkedlist.o deque.o
	$(CC) $(FLAGS) main.o linkedlist.o deque.o -o $(PROG)

main.o: main.cpp deque.hpp
	$(CC) -c $(FLAGS) main.cpp 

linkedlist.o: linkedlist.cpp linkedlist.hpp
	$(CC) -c $(FLAGS) linkedlist.cpp

deque.o: deque.cpp deque.hpp
	$(CC) -c $(FLAGS) deque.cpp

clean:
	rm -f *.o $(PROG)
