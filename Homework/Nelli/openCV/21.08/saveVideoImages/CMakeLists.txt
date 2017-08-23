cmake_minimum_required(VERSION 2.8)
set(CMAKE_CXX_STANDARD 11) # C++11...
set(CMAKE_CXX_STANDARD_REQUIRED ON) #...is required...
set(CMAKE_CXX_EXTENSIONS OFF) #...without compiler extensions like gnu++11
project( saveImages )
find_package( OpenCV REQUIRED )
add_executable( saveImages main.cpp )
target_link_libraries( saveImages  ${OpenCV_LIBS} )
