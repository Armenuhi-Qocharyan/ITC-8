PROG=symmetric
CC=g++
FLAGS=-std=c++11

all: $(PROG)

$(PROG): main.o linkedlist.o stack.o helper.o
	$(CC) $(FLAGS) main.o linkedlist.o stack.o helper.o -o $(PROG)

main.o: main.cpp stack.hpp
	$(CC) -c $(FLAGS) main.cpp 

linkedlist.o: linkedlist.cpp linkedlist.hpp
	$(CC) -c $(FLAGS) linkedlist.cpp

stack.o: stack.cpp stack.hpp
	$(CC) -c $(FLAGS) stack.cpp

helper.o: helper.cpp helper.hpp
	$(CC) -c $(FLAGS) helper.cpp

clean:
	rm -f *.o $(PROG)
