project(CustomGrey)
cmake_minimum_required(VERSION 2.8)
find_package(OpenCV REQUIRED)
add_executable(CustomGrey main.cpp)
target_link_libraries(CustomGrey ${OpenCV_LIBS})
