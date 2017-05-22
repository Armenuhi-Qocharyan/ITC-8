#include "hashtable.hpp"
#include <iostream>

int main() {
    Hash::HashTable hashTable;
    int key = 1;
    int value = 10;
    hashTable.insert(key, value);

    key = 3; 
    value = 30;
    hashTable.insert(key, value);

    key = 2; 
    value = 50;
    hashTable.insert(key, value);

    key = 11; 
    value = 50;
    hashTable.insert(key, value);

    hashTable.print();

    if (hashTable.containsKey(3)) {
        std::cout << "Contains key 3" << std::endl;
    } else {
        std::cout << "Does not contain key 3" << std::endl;
    }

    if (hashTable.containsKey(2)) {
        std::cout << "Contains key 2" << std::endl;
    } else {
        std::cout << "Does not contain key 2" << std::endl;
    }

    if (hashTable.containsValue(50)) {
        std::cout << "Contains value 60" << std::endl;
    } else {
        std::cout << "Does not contain value 60" << std::endl;
    }
    if (hashTable.containsValue(60)) {
        std::cout << "Contains value 60" << std::endl;
    } else {
        std::cout << "Does not contain value 60" << std::endl;
    }

    return 0;
}
