#ifndef SOLDIER_HPP
#define SOLDIER_HPP

#include <iostream>
#include <string>

struct Soldier {
    private:
        std::string m_name;
        std::string m_weapon;
        int m_cartridge;
        int m_reserved;
        bool m_isProtected;

    public:
        //Constructors
        Soldier();
        Soldier(const std::string&, const std::string&, const int&, const int&, const bool);


        //Destructor
        ~Soldier();

        //Set methods
        void setName(const std::string&);
        void setWeapon(const std::string&);
        void setCartridge(const int&);
        void setReserved(const int&);
        void setIsProtected(const bool); 

        //Get methods
        std::string getName() const;
        std::string getWeapon() const;

        //Method
        bool isProtected() const;
        void gunFight(const Soldier&) const;
        void handFight() const;
        void fight(const Soldier&) const; 
};

#endif
