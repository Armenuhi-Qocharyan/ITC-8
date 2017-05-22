#ifndef GRAPHIC_H
#define GRAPHIC_H 1

//Draw-functions
void drawLine(const unsigned int&);
void drawTriangle(const unsigned int&);
void drawRectangle(const unsigned int&, const unsigned int&);
void drawSquare(const unsigned int&);

//Get-functions
unsigned int getLine();
unsigned int getTriangle();
unsigned int getRectangle();
unsigned int getSquare();

//Other
void manager();
void drawColoumns();

#endif
