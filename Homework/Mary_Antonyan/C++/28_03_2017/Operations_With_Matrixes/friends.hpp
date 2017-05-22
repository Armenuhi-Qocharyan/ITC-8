#ifndef FRIENDS_HPP
#define FRIENDS_HPP

#include "matrix.hpp"
#include <iostream>

namespace Matrixes {    
    std::ostream& operator<<(std::ostream&, const Matrix&);
    std::istream& operator>>(std::istream&, Matrix&);
}

#endif
