#include "soldier.hpp"

//Constructors
Soldier::Soldier() {}

Soldier::Soldier(const std::string& name, const std::string& weapon, const int& cartridge, const int& reserved, const bool isProtected)  
    : m_name(name)
    , m_weapon(weapon) 
    , m_cartridge(cartridge)
    , m_reserved(reserved)
    , m_isProtected(isProtected)
{}

//Destructor
Soldier::~Soldier() { }

//Set methods
void Soldier::setName(const std::string& name) {
    this->m_name = name;
}

void Soldier::setWeapon(const std::string& weapon) {
    this->m_weapon = weapon;
}

void Soldier::setCartridge(const int& cartridge) {
    this->m_cartridge = cartridge;
} 

void Soldier::setReserved(const int& reserved) {
    this->m_reserved = reserved;
}

void Soldier::setIsProtected(const bool isProtected) {
    this->m_isProtected = isProtected;
}

//Get methods
std::string Soldier::getName() const {
    return this->m_name;
}

std::string Soldier::getWeapon() const {
    return this->m_weapon;
}

//Methods
bool Soldier::isProtected() const {
    return this->m_isProtected;
}

void Soldier::gunFight(const Soldier& enemy) const {
    if(enemy.isProtected()) {
        std::cout << "--Beat enemy--\n" << "--Beat enemy--" << std::endl;
    } else {
        std::cout << "--Beat enemy--" << std::endl;
    }
}

void Soldier::handFight() const {
    std::cout << "--Beat with hands--" << std::endl;
}

void Soldier::fight(const Soldier& enemy) const {
    if (2 <= this->m_cartridge) {
        std::cout << "-----GUN FIGHT-----" << std::endl;
        gunFight(enemy);
    } else if (2 <= this->m_reserved) {
        std::cout << "--Cartridges are over--" << std::endl;
        std::cout << "-----REFILL CARTRIDGES FROM THE STORE-----" << std::endl;
        gunFight(enemy);
    } else {
        std::cout << "--Reserved cartridges are over--" << std::endl;
        std::cout << "-----GO FIGHT WITH HANDS-----" << std::endl;
        handFight();
    }
    std::cout << "\n-----Enemy " << enemy.getName() << " was killed-----" << std::endl;
} 
