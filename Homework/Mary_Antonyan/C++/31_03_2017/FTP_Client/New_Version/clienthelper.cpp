#include "clienthelper.hpp"
#include <iostream>
#include <string.h>
#include <cstdlib>
#include <cstdio>
#include <sys/types.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <netdb.h>
#include <unistd.h>

//Report about error and terminate program
void Client::error(const char* message) {
    perror(message);
    exit(0);
}

//Open new socket
void Client::openSocket(const int argc, const char* argv[], int& out_portNumber, int& out_sockFileDesc) {
    if (3 > argc) {
        error("Error: Fail while entering host name and port number\n");
    }

    out_portNumber = atoi(argv[2]);
    out_sockFileDesc = socket(AF_INET, SOCK_STREAM, 0);
    if (0 > out_sockFileDesc) {
        error("Error while opening socket\n");
    }
}

//Connect to Server
void Client::connectToServer(const char* argv[], const int sockFileDesc, const int portNumber,  
                        struct hostent* out_server, char out_buffer[256]) {
    out_server = gethostbyname(argv[1]);   
    if (nullptr == out_server) {
        error("Error: no such host to connect\n");
    }
 
    struct sockaddr_in serverAddress; 
    bzero((char*) &serverAddress, sizeof(serverAddress));
    serverAddress.sin_family = AF_INET;
    serverAddress.sin_port = htons(portNumber);
    bcopy((char*) &out_server->h_addr, 
          (char*) &serverAddress.sin_addr.s_addr, 
           out_server->h_length);

    if (0 > connect(sockFileDesc, (sockaddr*) &serverAddress, 
                    sizeof(serverAddress))) {
        error("Error while connecting\n");
    }
}

//Write in socket
void Client::writeInSocket(char buffer[256], const int sockFileDesc) { 
    std::cout << "Enter message to talk with server: ";
    bzero(buffer, 256);
    fgets(buffer, 255, stdin);  

    int returnValue = write(sockFileDesc, buffer, strlen(buffer));
    if (0 > returnValue) {
        error("Error while wrting in socket");
    }
}

//Read from socket
void Client::readFromSocket(char buffer[256], const int sockFileDesc) {
    bzero(buffer, 256);

    int returnValue = read(sockFileDesc, buffer, 255);
    if (0 > returnValue) {
        error("Error while reading from socket");
    }

    std::cout << buffer << std::endl;
}

void Client::executeClient(const int argc, const char* argv[]) {
    //Open socket
    int portNumber = 0;;
    int sockFileDesc = 0;
    Client::openSocket(argc, argv, portNumber, sockFileDesc);

    //Connect to server
    struct hostent* server = nullptr;   
    char buffer[256];
    Client::connectToServer(argv, sockFileDesc, portNumber, server, buffer);

    //Write in socket
    Client::writeInSocket(buffer, sockFileDesc);
    
    //Read from socket
    Client::readFromSocket(buffer, sockFileDesc);

    //At the end close socket
    close(sockFileDesc);
}
