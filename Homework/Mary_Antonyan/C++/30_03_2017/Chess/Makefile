CC=g++ -std=c++11
PROG=chess

all: $(PROG)

chess: main.o node.o figure.o board.o king.o queen.o knight.o rook.o bishop.o pawn.o
	$(CC) main.o node.o figure.o board.o king.o queen.o knight.o rook.o bishop.o pawn.o -o $(PROG)

main.o: main.cpp   
	$(CC) -c main.cpp

board.o: board.cpp board.hpp figure.cpp
	$(CC) -c board.cpp figure.cpp 

figure.o: figure.cpp figure.hpp board.cpp
	$(CC) -c figure.cpp board.cpp

king.o: king.cpp king.hpp board.cpp figure.cpp
	$(CC) -c king.cpp figure.cpp board.cpp

queen.o: queen.cpp queen.hpp board.cpp figure.cpp
	$(CC) -c queen.cpp figure.cpp board.cpp

knight.o: knight.cpp knight.hpp board.cpp figure.cpp
	$(CC) -c knight.cpp figure.cpp

rook.o: rook.cpp rook.hpp board.cpp figure.cpp
	$(CC) -c rook.cpp figure.cpp

bishop.o: bishop.cpp bishop.hpp board.cpp figure.cpp
	$(CC) -c bishop.cpp figure.cpp

pawn.o: pawn.cpp pawn.hpp board.cpp figure.cpp
	$(CC) -c pawn.cpp figure.cpp

clean:
	rm -rf *.o chess
