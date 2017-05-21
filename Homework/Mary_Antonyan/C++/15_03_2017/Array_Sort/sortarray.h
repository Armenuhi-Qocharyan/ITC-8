#ifndef SORTARRAY_H
#define SORTARRAY_H 1

//Array managment-functions
int* createArr(const int&); 
void printArr(int*, const int&);

//Sort-functions
void sortAscending(int*, const int&);
void sortDescending(int*, const int&);
void sort(int*, const int&, void function(int*, const int&));

#endif
