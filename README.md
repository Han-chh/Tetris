# Tetris

## Description

A classic Tetris game implemented in Java using Swing. Features falling blocks, line clearing, scoring, and multiple difficulty levels.

## Features

- Classic Tetris gameplay
- Multiple difficulty levels (Turtle, Normal, Fast, Increasing)
- Score tracking
- Time display
- Next block preview
- Pause and restart functionality
- Keyboard controls for block movement and rotation

## Requirements

- Java Development Kit (JDK) 8 or higher
- The jar package is packaged with Java 25.

## Run

```bash
java -jar Tetris.jar
```

## How to Play

- Use A/D or Left/Right arrows to move blocks horizontally
- Use S or Down arrow to accelerate block fall
- Use W or Up arrow to rotate blocks (except O-shape)
- Clear complete lines to score points
- Game ends when blocks reach the top

## Controls

- START: Begin the game
- PAUSE/CONTINUE: Pause or resume gameplay
- RESTART: Start a new game
- A/Left: Move left
- D/Right: Move right
- S/Down: Accelerate
- W/Up: Rotate

## Project Structure

- `src/Tetris/Game.java`: Main game logic and initialization
- `src/Tetris/Window.java`: Main game window and controls
- `src/Tetris/Blocks.java`: Block shapes and movement logic
- `src/Tetris/Map_grid.java`: Game grid component
- `src/Tetris/ProcessControl.java`: Game flow control
- `src/Tetris/Shapes.java`: Block shape definitions
- `src/Tetris/Timer_game.java`: Game timing
- `src/Tetris/Refresh.java`: Display refresh logic
- `bin/`: Compiled class files

## Contributing

Contributions are welcome! Feel free to submit issues and pull requests for new features or improvements.