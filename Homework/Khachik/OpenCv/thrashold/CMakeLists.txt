cmake_minimum_required(VERSION 2.8)
project( thrashold )
find_package( OpenCV REQUIRED )
add_executable( thrashold main.cpp )
target_link_libraries( thrashold ${OpenCV_LIBS} )
