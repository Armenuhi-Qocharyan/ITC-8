#ifndef SOLDIER_HPP
#define SOLDIER_HPP

#include <iostream>
#include <string>

struct Soldier {
    private:
        std::string m_name;
        std::string m_weapon;
    public:
        //Constructors
        Soldier();
        Soldier(const std::string&, const std::string&);

        //Destructor
        ~Soldier();

        //Set methods
        void setName(const std::string&);
        void setWeapon(const std::string&);

        //Get methods
        std::string getName() const;
        std::string getWeapon() const;

        //Method
        void fight(const Soldier&);
};

#endif
