PROG=tree
CC=g++
FLAGS=-std=c++11

all: $(PROG)

$(PROG): main.o binarytree.o helper.o
	$(CC) $(FLAGS) main.o binarytree.o helper.o -o $(PROG)

main.o: main.cpp binarytree.hpp helper.hpp
	$(CC) -c $(FLAGS) main.cpp 

binarytree.o: binarytree.cpp binarytree.hpp
	$(CC) -c $(FLAGS) binarytree.cpp

helper.o: helper.cpp helper.hpp
	$(CC) -c $(FLAGS) helper.cpp

clean:
	rm -f *.o $(PROG)
