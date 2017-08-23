project(EdgeDetection)
cmake_minimum_required(VERSION 2.8)
find_package(OpenCV REQUIRED)
add_executable(EdgeDetection main.cpp)
target_link_libraries(EdgeDetection ${OpenCV_LIBS})

