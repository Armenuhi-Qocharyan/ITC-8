#ifndef FUNCTIONS_H
#define FUNCTIONS_H 1

#include <iostream>
#include <string>

//Numeric arrays generating functons
int* generateMedals(const int&);
int* getTotal(int*, int*, int*, const int&);

//Swap functions
void swap(int&, int&);
void swap(std::string&, std::string&);

//Table-Manager functions
void printLine();
void sortTable(std::string*, int*, int*, int*, int*, const int&);
void printTable(std::string*, int*, int*, int*, int*, const int&);

#endif
