#include "shuffle.hpp"

static int count = 0;

bool check(const std::string& word) {
    int size = word.length();
    for (int i = 0; i < size; ++i) {
        for (int j = i + 1; j < size; ++j) {
            if (word[i] == word[j]) {
                std::cout << "Error: There is are repititions\n";
                return false;
            }
        }
    }
    
    for (int i = 0; i < size; ++i) {
        if (!isalpha(word[i])) {
            std::cout << "Error: There is nonletter character\n";
            return false;
        }
    }
    return true;
}

void shuffle(std::string word, const int& size) {
    if (0 == size) {
        ++count;
        std::cout << word << std::endl;
        return;
    } 
    
    for (int i = 0; i < size; ++i) {
        shuffle(word, size - 1);
        char tmp = word[size - 1];
        word[size - 1] = word[(size % 2) * i];
        word[(size % 2) * i] = tmp;
    }
}

int getCount() {
    return count;
}
