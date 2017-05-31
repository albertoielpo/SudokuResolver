# SudokuResolver

A Java program that solve the sudoku game 

author: Alberto Ielpo
website: www.ielpo.net
version: 1.0
date: 22.05.2017

The sudoku game can be inserted in the program by:
1) a config file
2) the standard input

In the 1) case the config file has to be formed as the "sudoku.example" file present in the main directory
In the 2) case the sudoku game has to be inserted by row.

# HOW TO USE
> java -jar sudoku.jar [MODE]
MODE 0:DEFAULT, 1:SPECIFY_PATH, 2:INPUT_STREAM

0) Using the "DEFAULT" mode the config file (sudoku.csv) has to be in the same directory of the jar executable file (sudoku.jar).
1) Using the "SPECIFY_PATH "mode, you can indicate the path location of the configuration file and it can be name as you wish.
2) Using the "INPUT_STREAM" mode, the sudoku input has to be inserted by row. An example of a input row can be: 1,0,2,4,0,0,0,0

NB: 
- in the config file the sudoku cells must be separed by ","
- in the config file 0 can be used as convention to define a blank cell. The program permit also to use any characted that is not included into "1-9" range.

# NB
This software is open source
"Sudoku Resolver" is licensed under the GPL v3 or later. 

For futher info, bug report or whatever, drop an email to: alberto@ielpo.net
