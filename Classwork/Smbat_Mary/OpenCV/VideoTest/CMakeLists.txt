project(VideoTest)
cmake_minimum_required(VERSION 2.8)
find_package(OpenCV REQUIRED)
add_executable(VideoTest main.cpp)
target_link_libraries(VideoTest ${OpenCV_LIBS})

