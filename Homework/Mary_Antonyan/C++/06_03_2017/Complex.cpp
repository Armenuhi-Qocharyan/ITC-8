#include <iostream>
#include <cmath>

void showComplex(const double& m_re, const double& m_im) {
    if (0 != m_re) {
        if (0 < m_im) {
            std::cout << m_re << " + i*" << m_im << std::endl;
        } else if ( 0 > m_im) {
            std::cout << m_re << " - i*" << fabs(m_im) << std::endl;
        } else {
            std::cout << m_re << std::endl;
        }
    } else { 
        if ( 0 < m_im) {  
            std::cout <<  "i*" << m_im << std::endl;
        } else if ( 0 > m_im) { 
            std::cout << "- i*" << fabs(m_im) << std::endl;
        } else {
            std::cout << 0 << std::endl;
        }
    }
}

void solution(double a, double b, double c) {
    if (0 == a) {
        if (0 == b) {
            if (0 != c) {
                std::cout << "No solution" << std::endl;
            } else {
                std::cout << "Any real number is a solution" << std::endl;
            }
        } else {
            std::cout << "x = " << c / b << std::endl;
        }
    } else {
        double discriminant = b * b - 4 * a * c;
        if ( 0 <= discriminant) {
            double x1 = (-b - sqrt(discriminant)) / (2 * a);
            double x2 = (-b + sqrt(discriminant)) / (2 * a);
            if (x1 == x2) {
            	if (0 == x1) {
					std::cout << 0 << std::endl;
				} else {
                	std::cout << "x= " << x1 << std::endl;
                }
            } else {
                std::cout << "x1= " << x1 << "\tx2= " << x2 << std::endl;
            }
        } else {
            showComplex(-b / (2 * a), -sqrt(fabs(discriminant))/ (2 * a));
            showComplex(-b / (2 * a), sqrt(fabs(discriminant)) / (2 * a));
        }
    }
}

int main() {
    double a;
    std::cout << "Enter a: ";
    std::cin >> a;

    double b;
    std::cout << "Enter b: ";
    std::cin >> b;

    double c;
    std::cout << "Enter c: ";
    std::cin >> c;

    solution(a, b, c);

    return 0;
}

