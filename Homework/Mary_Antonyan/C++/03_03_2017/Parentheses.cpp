#include <iostream>
#include <string>

bool isBalanced(std::string str) {
    int top = 0;
    char* stack = new char(str.length());

    for (int i = 0; i < str.length(); ++i) {
	if ('{' == str[i] || '[' == str[i] || '(' == str[i]) {
	    ++top;
	    stack[top] = str[i];
	} else if ('}' == str[i]) {
	    if ('{' == stack[top]) {
		--top;
	    } else {
		return false;
	    }
	} else if (']' == str[i]) {
	    if ('[' == stack[top]) {
		--top;
	    } else {
		return false;
	    }
	} else if (')' == str[i]) {
	    if ('(' == stack[top]) { 
		--top; 
	    } else {
		return false;
	    }
	}
    }

    return (0 == top);
}

int main(int argc, char** argv) {
    if (2 < argc) {
	std::cout << "Error: too many arguments for main" << std::endl;
	return -1;
    } else if (2 > argc) {
	std::cout << "Error: too few arguments for main" << std::endl;
	return -1;
    }

    std::string str = argv[1];	
    if (isBalanced(str)) {
	std::cout << "YES" << std::endl;
    } else {
	std::cout << "NO" << std::endl;
    }

    return 0;
}
