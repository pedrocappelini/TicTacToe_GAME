<h1>Tic Tac Toe Game</h1>

<p>This is a classic Tic Tac Toe game built using Java. The game allows two players to take turns placing their marks (X and O) on a 3x3 grid. The first player to align three of their marks horizontally, vertically, or diagonally wins the game.</p>

<h2>Features</h2>
<ul>
  <li>2-player gameplay</li>
  <li>Simple graphical user interface (GUI)</li>
  <li>Win condition check for horizontal, vertical, and diagonal alignments</li>
  <li>Highlight winning combination</li>
  <li>Customizable images for X and O</li>
</ul>

<h2>Requirements</h2>
<ul>
  <li>Java 8 or higher</li>
  <li>Java Development Kit (JDK) installed on your system</li>
  <li>IDE (e.g., IntelliJ IDEA, Eclipse, or VSCode) for running the project</li>
</ul>

<h2>Installation</h2>
<ol>
  <li><strong>Clone the repository:</strong>
    <pre><code>git clone https://github.com/pedrocappelini/tic-tac-toe.git</code></pre>
  </li>
  <li><strong>Navigate to the project directory:</strong>
    <pre><code>cd tic-tac-toe</code></pre>
  </li>
  <li><strong>Compile and run the project:</strong>
    <ul>
      <li>If you're using a terminal or command prompt, navigate to the project folder and run:
        <pre><code>javac Gameplay.java
java Gameplay</code></pre>
      </li>
    </ul>
  </li>
  <li><strong>Start playing:</strong>
    <ul>
      <li>The game will launch with a simple window where you can click on the tiles to place your marks (X or O).</li>
      <li>Players take turns, and the game will automatically detect and highlight the winning combination once someone wins.</li>
    </ul>
  </li>
</ol>

<h2>How to Play</h2>
<ol>
  <li>The game starts with an empty 3x3 grid.</li>
  <li>Players take turns to click on a cell to place either an X or an O.</li>
  <li>The first player to align three marks horizontally, vertically, or diagonally wins the game.</li>
  <li>If all cells are filled and there is no winner, the game ends in a draw.</li>
  <li>If the games ends in a win or a draw, press backspace for reseting.</li>
</ol>

<h2>Game Logic</h2>
<p>The board is a 3x3 grid, where each cell is represented by an integer value:</p>
<ul>
  <li><code>1</code>: Empty cell</li>
  <li><code>0</code>: Player X's mark</li>
  <li><code>2</code>: Player O's mark</li>
  <li><code>3</code>: Highlighted cells for the winning combination</li>
</ul>
<p>The game checks for winning conditions after each move.</p>
<p>Winning combinations include horizontal, vertical, and diagonal alignments.</p>

<h2>Game Flow</h2>
<ul>
  <li>Players alternate between X (represented by <code>0</code>) and O (represented by <code>2</code>).</li>
  <li>The game checks for a winner after each move. If a player wins, the winning combination is highlighted.</li>
</ul>
