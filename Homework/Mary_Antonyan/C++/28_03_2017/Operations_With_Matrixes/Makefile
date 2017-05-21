PROG=matrix
CC=g++ 
FLAGS=-std=c++11

all: $(PROG)

$(PROG): main.o matrix.o execute.o friends.o 
	$(CC) $(FLAGS) main.o matrix.o execute.o friends.o -o $(PROG)

main.o: main.cpp
	$(CC) -c $(FLAGS) main.cpp 

matrix.o: matrix.cpp matrix.hpp
	$(CC) -c $(FLAGS) matrix.cpp

execute.o: execute.cpp execute.hpp
	$(CC) -c $(FLAGS) execute.cpp

friends.o: friends.cpp friends.hpp
	$(CC) -c $(FLAGS) friends.cpp

clean:
	rm -f *.o $(PROG)
  
