#include <iostream>
#include <string>
#include <cstdlib>

std::string shorten(const std::string& str) {
    std::string shortStr = "";	
	
    for (int i = 0; i < str.length(); ++i) {
	if ('-' == str[i] && '-' == str[i + 1]) {
	    continue;
	} 	
	shortStr += str[i];				
    }
    return shortStr;
}

int countArrows(const std::string& str) {
    std::string shrt = shorten(str);
    if (4 > shrt.length()) {
	std::cout << "Error: Invalid string" << std::endl;
	return -1;
    }
    std::string left = "<-<<"; 	
    std::string right = ">>->";	
    int count = 0; 	
    for (int i = 0; i < shrt.length(); ++i) {
	std::string sub = shrt.substr(i, 4);
	if (sub == left || sub == right) {
	    ++count;
	}
    }
    return count;
}

int main() {
    std::string str;
    std::cout << "Enter string: ";
    std::cin >> str;
	
    std::string shrt = shorten(str);
    int count = countArrows(str);

    if (0 < count) {
	std::cout <<  "There are " << count << " arrows" << std::endl;
    } else {
	std::cout << "There are no arrows" << std::endl;
    }
    return 0;
}

