#include "shuffle.hpp"

int main() {
    std::string word;
    do {
        std::cout << "Enter a word to get all possible combinations: \n";
        std::cin >> word;
    } while (!check(word) || 6 <= word.length());

    std::cout << "\n---Possible combinations---\n";
    shuffle(word, word.length());

    int count = getCount();
    if (count > 1) {
        std::cout << "There are " << count << " combinations for ";
        std::cout << word << std::endl;
    } else if (1 == count) {
        std::cout << "There is only 1 combination for " << word << std::endl;
    } else {
        std::cout << "There are no any possible combinations" << std::endl;
    }
    return 0; 
}
