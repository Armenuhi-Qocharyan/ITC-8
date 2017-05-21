CC=g++ -std=c++11
PROG=client

all: $(PROG)

$(PROG): main.o clienthelper.o
	$(CC) main.o clienthelper.o -o $(PROG)

main1.o: main1.cpp clienthelper.hpp
	$(CC) -c main.cpp

clienthelper.o: clienthelper.cpp clienthelper.hpp
	$(CC) -c clienthelper.cpp

clean: 
	rm *.o $(PROG)
