#include <iostream>

int inverse(int num) {
    if (0 > num) {
	std::cout << "Error: negative number" << std::endl;
	return -1;
    }

    int result = 0;
    while (0 < num) {
	result = result * 10 + num % 10;
	num /= 10; 
    }

    return result;
}

void amazing(const int& num) {
    int count = 0;
    if (1 > num) {
	std::cout << "Error: Invalid data" << std::endl;
	return;
    }
    for (int i = 0; i < num; ++i) {
	if (-1 != inverse(i) && inverse(i) + i == num) {
	    std::cout << i << std::endl;
	    ++count;
	}
    }	
    if (0 == count) {
	std::cout << num << " hasn't an amazing number" << std::endl;
    }
}

int main() {
    int num;
    do {
	std::cout << "Enter number: ";
   	std::cin >> num;
    } while (0 > num);

    amazing(num);
    return 0;
}
