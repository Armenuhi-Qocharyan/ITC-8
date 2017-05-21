#include "soldier.hpp"

//Constructors
Soldier::Soldier() {}

Soldier::Soldier(const std::string& name, const std::string& weapon) 
    : m_name(name)
    , m_weapon(weapon) 
{ }

//Destructor
Soldier::~Soldier() { }

//Set methods
void Soldier::setName(const std::string& name) {
    m_name = name;
}

void Soldier::setWeapon(const std::string& weapon) {
    m_weapon = weapon;
}

//Get methods
std::string Soldier::getName() const {
    return m_name;
}

std::string Soldier::getWeapon() const {
    return m_weapon;
}

//Method
void Soldier::fight(const Soldier& enemy) {
    std::cout << "\n----------FIGHT----------\n";
    for (int i = 0; 5 > i; ++i) {
        std::cout << "....." << std::endl;
        
    }
    std::cout << m_name << " killed " << enemy.getName() << std::endl; 
}
