#ifndef RECTANGLE_HPP
#define RECTANGLE_HPP

namespace List {
    class Rectangle {
        public:
            //Constructor
            Rectangle();
            Rectangle(const int area);

            //Destructor
            ~Rectangle();

            //Methods
            int getArea() const;
            void setArea(const int area);

        private:
            int mArea;
    };
}

#endif
