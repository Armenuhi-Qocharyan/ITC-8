#ifndef FUNCTIONS_H
#define FUNCTION_H 1

#include <string>

//Operation for int
namespace operations {
int sum(const int&, const int&);
int diff(const int&, const int&);
int mult(const int&, const int&);
int div(const int&, const int&);
int mod(const int&, const int&);

//Operations for double
double sum(const double&, const double&);
double diff(const double&, const double&);
double mult(const double&, const double&);
double div(const double&, const double&);

//Operations for string
std::string sum(const std::string&, const std::string&);
}

//Input-functions
int input(const int&, bool&);
double input(const double&, bool&);
std::string input(const std::string&, bool&);

//Output-function
void printResult(const std::string&, bool&);

#endif
