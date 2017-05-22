#include <iostream>     //contains std::cout, std::cin, std::endl 
#include <string.h>     //contains strlen(), bzero()
#include <cstdlib>      //contains exit()
#include <cstdio>       //contains perror()
#include <sys/types.h>  //contains definitions of data 
                        //types used in system calls
#include <sys/socket.h> //contains definitions of structures
                        //needed for sockets
#include <netinet/in.h> //contains constants and structures
                        //needed for internet domain addresses
#include <netdb.h>      //contains definitions for network
#include <unistd.h>     //contains read(), write() and close()

//This function prints message about error and exits the program
//when system call fails. Function does not return a value
//
//message - is a string, containing message to be printed
//
//perror - prints message to stderr(standard error output stream)
//defined in header file <cstdio>
//
//exit - terminates program
//defined in header file <cstdlib>
void error(const char* message) {
    perror(message);
    exit(0);
}

int main(int argc, char* argv[]) {
    //user needs to enter server address and port number
    //if user fails, following code reports about error 
    //and program terminates
    if (3 > argc) {
        error("Error: Fail while entering host name and port number\n");
    }

    //Now we must get given arguments to main function
    int portNumber;     //port number on which server accepts connections

    //Cast port number from char* to integer
    portNumber = atoi(argv[2]);
    
    //Each running process has a file descriptor table which
    //contains pointers to all open i/o streams.  When a
    //process starts, three entries are created in the first
    //three cells of the table.  Entry 0 points to standard
    //input, entry 1 points to standard output, and entry 2
    //points to standard error.  Whenever a file or other i/o
    //stream is opened, a new entry is created in this table,
    //usually in the first available empty slot.
    //
    //The socket system call returns an entry into this
    //table. This value is used for other calls which use 
    //this socket. The accept system call returns another entry 
    //into this table.  The value returned by accept is used 
    //for reading and writing to that connection.
    
    //file descriptor needed for storing values returned by socket sys call
    int sockFileDesc;
                        
    //socket() system call creates a new socket and takes 3 arguments: 
    //1. domain address of socket
    //   (AF_INET - symbloic const)
    //2. type of socket (stream socket or datagram socket(reads by chunks))  
    //3. protocol (0 <=> the OS will choose the most corresponding protocol)
    //
    //socket sys call returns entry into file descriptor table
    //if socket call fails, it returns -1
    //function definition is in header file <sys/socket.h>
    sockFileDesc = socket(AF_INET, SOCK_STREAM, 0);

    //if socket call fails, i.g. function returns -1, 
    //program reports error and terminates by function error()    
    if (0 > sockFileDesc) {
        error("Error while opening socket\n");
    }

    //server is a pointer to a struct of type hostent
    //which is defined in header file <netdb.h>
    struct hostent* server; 

    //functions gethostbyname(char* name) returns a pointer to hostent struct
    //which contains info about that host. 
    //in case of failure it returns nullptr(NULL)
    //function definition is in header file <netdb.h>
    server = gethostbyname(argv[1]);   
    
    //if gethostbyname fails, program terminates by function error()
    if (nullptr == server) {
        error("Error: no such host to connect\n");
    }

    //server reads character from socket into this buffer
    char buffer[256];   

    //sockadd_in is a struct which contanin an internet address. 
    //this structure is defined in <netinet.h> header file
    //
    //serverAddress contains address of the server, to which we want to connect
    struct sockaddr_in serverAddress; 

    //function bzero() sets all values in buffer to 0, takes 2 args:
    //1. pointer to buffer
    //2. size of buffer
    //function definition is in header file <string.h>
    bzero((char*) &serverAddress, sizeof(serverAddress));

    //Let's set serverAdress' fields:
    //struct sockadd_in has following fields:
    //1. short sin_family - code for the address family
    //   (AF_INET - symbloic const)
    //2. unsigned short sin_port - port number
    //3. struct sin_addr - contains field struct s_addr, which contains 
    //   only one field - IP address of the host 
    serverAddress.sin_family = AF_INET;

    //htons() converts a port number in host byte order 
    //to a port number in network byte order
    //function definition is in header file <netinet/in.h>
    serverAddress.sin_port = htons(portNumber);
   
    //Field server->h_addr is a char string
    //bcopy(char* str1, char* str2, int length) copies length bytes
    //from str1 to str2 
    //function definition is in header file <string.h>
    bcopy((char*) &server->h_addr, 
          (char*) &serverAddress.sin_addr.s_addr, 
           server->h_length);

    //connect() function is called by the client to connect with server
    //it takes 3 args:
    //1. socket file descriptor
    //2. address of the host to connect
    //3. size of address
    //
    //if connection establsihed successfully, function returns 0, 
    //else returns -1 and the program terminates by function error()
    //
    //definition of function is in <sys/socket.h> header file
    if (0 > connect(sockFileDesc, (sockaddr*) &serverAddress, 
                    sizeof(serverAddress))) {
        error("Error while connecting\n");
    }
    
    //Now connection with server is established and we can talk with him :)
    //return value for read() and write() calls
    int returnValue;   
    std::cout << "Enter message to talk with server: ";
    bzero(buffer, 256);

    //fgets() reads chars from stream in string, takes 3 args:
    //1. pointer to char array where read string is copied 
    //2. max number of chars to be copied into string
    //3. pointer to object, which identifies an input stream 
    //(in this case it is stdin - standard input)
    //
    //these both are defined in <cstdio> header file
    fgets(buffer, 255, stdin);  

    //write() takes 3 args:
    //1. socket file descriptor
    //2. pointer to the buffer storing the data to be written
    //3. the length of data in bytes
    //
    //write() returns the number of bytes actually written successfully
    //in case of failure function returns -1  
    //
    //function definition is in header file <unistd.h>
    returnValue = write(sockFileDesc, buffer, strlen(buffer));

    //in case of failure program terminates by function error() 
    if (0 > returnValue) {
        error("Error while wrting in socket");
    }
    
    bzero(buffer, 256);    

    //read() takes 3 args:
    //1. socket file descriptor
    //2. pointer to the buffer storing the data to be read
    //3. the length of data in bytes
    //
    //read() returns number of bytes actually readen successfully.
    //in case of failure function returns -1
    //
    //function definition is in header file <unistd.h>
    returnValue = read(sockFileDesc, buffer, 255);

    //in case of failure program terminates by function error()
    if (0 > returnValue) {
        error("Error while reading from socket");
    }

    //Print buffer which contains read data from socket
    std::cout << buffer << std::endl;

    //After all we need to close socket
    close(sockFileDesc);
    return 0;
}

