# 俄罗斯方块

使用Swing实现的经典俄罗斯方块游戏。具有下降方块、消除行、计分和多种难度级别。

## 功能

- 经典俄罗斯方块游戏玩法
- 多种难度级别（乌龟、正常、快速、递增）
- 计分跟踪
- 时间显示
- 下一个方块预览
- 暂停和重新开始功能
- 方块移动和旋转的键盘控制

## 要求

- Java开发工具包（JDK）8或更高版本

## 安装和运行

1. 确保系统上安装了JDK。
2. 导航到项目目录。
3. 编译源代码：
   ```
   javac -d bin src/Tetris/*.java
   ```
4. 运行游戏：
   ```
   java -cp bin Tetris.Game
   ```

## 如何玩

- 使用A/D或左/右箭头水平移动方块
- 使用S或下箭头加速方块下降
- 使用W或上箭头旋转方块（O形除外）
- 清除完整行以获得分数
- 当方块到达顶部时游戏结束

## 控制

- START：开始游戏
- PAUSE/CONTINUE：暂停或恢复游戏
- RESTART：开始新游戏
- A/左：左移
- D/右：右移
- S/下：加速
- W/上：旋转

## 项目结构

- `src/Tetris/Game.java`：主游戏逻辑和初始化
- `src/Tetris/Window.java`：主游戏窗口和控制
- `src/Tetris/Blocks.java`：方块形状和移动逻辑
- `src/Tetris/Map_grid.java`：游戏网格组件
- `src/Tetris/ProcessControl.java`：游戏流程控制
- `src/Tetris/Shapes.java`：方块形状定义
- `src/Tetris/Timer_game.java`：游戏计时
- `src/Tetris/Refresh.java`：显示刷新逻辑
- `bin/`：编译的类文件

## 贡献

欢迎贡献！欢迎提交问题和拉取请求以添加新功能或改进。