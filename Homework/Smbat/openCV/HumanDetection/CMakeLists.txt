project(HumanDetection)
cmake_minimum_required(VERSION 2.8)
find_package(OpenCV REQUIRED)
add_executable(HumanDetection main.cpp)
target_link_libraries(HumanDetection ${OpenCV_LIBS})

