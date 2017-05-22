#ifndef CLIENT_HELPER_HPP
#define CLIENT_HELPER_HPP

struct hostent;

namespace Client {
    //Report about error and terminate program
    void error(const char*);

    //Open new socket
    void openSocket(const int, const char*[], int&, int&);

    //Connect to Server
    void connectToServer(const char*[], const int, const int, struct hostent*, char[]);

    //Write in socket
    void writeInSocket(char[], const int);

    //Read from socket
    void readFromSocket(char[], const int);

    //Execute client
    void executeClient(const int, const char*[]);
}

#endif
