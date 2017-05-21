#include <iostream>
#include <string>
#include <cstdlib>
#include <string.h>

void detect(const std::string&);
int convert(const std::string&);
void manager(const std::string&, const std::string&);

int main(int argc, char** argv) {
    if (3 == argc) {
        for (int i = 0; strlen(argv[1]) > i; ++i) {
	    if ('0' != argv[1][i] && '1' != argv[1][i]) {
	        std::cout << "Error: Unknown character at " << i << " : " << argv[1][i] << std::endl;
		return -1;		
	    }
	}
	manager(argv[1], argv[2]);
    } else if (3 > argc) {
        std::cout << "Error: Too few arguments" << std::endl;
    } else {
	std::cout << "Error: Too many arguments" << std::endl;
    }
    return 0;
}

int convert(const std::string& binary) {
    int decimal = 0;
    int size = binary.size();
    int pow = 1;

    for (int i = size - 1; 0 <= i; --i) {
        if ('1' == binary[i]) {
	    decimal += pow;
        }
        pow *= 2;
    }

    return decimal;
}
	
void detect(const std::string& str) {	
    if (0 == str.length() || 0 != str.length() % 8) {
	std::cout << "Error: uncorrect string length" << std::endl;
	return;
    }

    for (int i = 0; str.length() > i; ++i) {
	if ('0' != str[i] && '1' != str[i]) {
	    std::cout << "Error: unknown character in string: " << i << " : " << str[i] << std::endl;
	    return;
	}
    }

    for (int i = 0; str.length() - 8 >= i; i+=8) {
	int item = convert(str.substr(i, 8));			
	if (0 <= item && 256 > item) {
	    char c  = item;
	    std::cout << c;
	} else {
	    std::cout << "Error: character corresponding to this code not found\n"; 
	}
    }
 
    std::cout << std::endl;
}

void manager(const std::string& str, const std::string& type) {
    if ("int" == type) {
	std::cout << convert(str) << std::endl;
    } else if ("string" == type) {
	detect(str);
    } else {
	std::cout << "Error: Invalid type" << std::endl;
    }
}
