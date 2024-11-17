Tic Tac Toe Game
This is a classic Tic Tac Toe game built using Java. The game allows two players to take turns placing their marks (X and O) on a 3x3 grid. The first player to align three of their marks horizontally, vertically, or diagonally wins the game.

Features
2-player gameplay
Simple graphical user interface (GUI)
Win condition check for horizontal, vertical, and diagonal alignments
Highlight winning combination
Customizable images for X and O
Requirements
Java 8 or higher
Java Development Kit (JDK) installed on your system
IDE (e.g., IntelliJ IDEA, Eclipse, or VSCode) for running the project
Installation
Clone the repository:

bash
Copiar código
git clone https://github.com/pedrocappelini/tic-tac-toe.git
Navigate to the project directory:

bash
Copiar código
cd tic-tac-toe
Compile and run the project:

If you're using a terminal or command prompt, navigate to the project folder and run:
bash
Copiar código
javac Gameplay.java
java Gameplay
Start playing:

The game will launch with a simple window where you can click on the tiles to place your marks (X or O).
Players take turns, and the game will automatically detect and highlight the winning combination once someone wins.
How to Play
The game starts with an empty 3x3 grid.
Players take turns to click on a cell to place either an X or an O.
The first player to align three marks horizontally, vertically, or diagonally wins the game.
If all cells are filled and there is no winner, the game ends in a draw.
Game Logic
The board is a 3x3 grid, where each cell is represented by an integer value:
1: Empty cell
0: Player X's mark
2: Player O's mark
3: Highlighted cells for the winning combination
The game checks for winning conditions after each move.
Winning combinations include horizontal, vertical, and diagonal alignments.
Game Flow
Players alternate between X (represented by 0) and O (represented by 2).
The game checks for a winner after each move. If a player wins, the winning combination is highlighted.
