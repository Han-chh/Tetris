# Tetris

A complete Java desktop Tetris loop with falling pieces, movement, rotation, line clearing, score, timing, difficulty, and next-piece preview.

[中文说明](README_zh.md)

## Overview

The project models tetromino generation and transformation on a grid, validates movement and rotation against boundaries and landed blocks, clears completed rows, and coordinates score, timer, pause, restart, and difficulty state.

## Demo

![Animated Tetris walkthrough showing falling pieces, movement, rotation, pause, and restart](assets/visual-demos/tetris-falling-blocks.gif)

[Full-resolution MP4 demo](assets/visual-demos/tetris-falling-blocks.mp4)

The video is recorded directly from the native Swing application and covers speed selection, start, movement, rotation, soft drop, next-piece preview, pause, restart, timing, and game-over state.

## Screenshot

![A Tetris playfield with a falling purple piece, landed blocks, score, and next-piece preview](assets/screenshots/tetris-gameplay.png)

## Features

- Falling tetrominoes with left/right/down movement
- Rotation and collision checks
- Completed-row clearing
- Score and elapsed-time feedback
- Difficulty choices
- Pause, restart, and next-piece preview

## Controls

- Move: Left/Right or A/D
- Soft drop: Down or S
- Rotate: Up or W

## Run

The committed JAR was verified with Java 25:

```bash
java -jar Tetris.jar
```

## Current limitations

No deterministic piece seed or automated gameplay test is included.
