package HamsterGame;

public class GameMap {
    private static final char WALL = '#';
    private static final char STAR = '*';
    private static final char[] DIRECTIONS = {'<', '^', '>', 'v'};

    private char[][] worldMap = {
            {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},
            {'#', ' ', ' ', ' ', ' ', '*', ' ', ' ', ' ', ' ', ' ', ' ', '#'},
            {'#', ' ', '*', ' ', ' ', '#', ' ', ' ', '*', ' ', ' ', ' ', '#'},
            {'#', ' ', ' ', '#', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', '#'},
            {'#', ' ', '*', ' ', '#', '#', ' ', ' ', ' ', '*', ' ', '*', '#'},
            {'#', ' ', ' ', '*', ' ', '#', ' ', '*', ' ', ' ', '*', ' ', '#'},
            {'#', ' ', '<', ' ', ' ', ' ', ' ', ' ', ' ', '*', ' ', ' ', '#'},
            {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'}
    };

    public int[] getCurrentPosition() {
        for (int i = 0; i < worldMap.length; i++) {
            for (int j = 0; j < worldMap[i].length; j++) {
                for (char direction : DIRECTIONS) {
                    if (worldMap[i][j] == direction) {
                        return new int[]{i, j};
                    }
                }
            }
        }
        return new int[]{-1, -1};
    }

    public char getHamsterSymbol() {
        int[] pos = getCurrentPosition();
        return (pos[0] != -1) ? worldMap[pos[0]][pos[1]] : ' ';
    }

    public void printWorldMap() {
        for (char[] row : worldMap) {
            System.out.println(new String(row));
        }
    }

    private int[] getPositionAhead(char direction) {
        int[] position = getCurrentPosition();
        int row = position[0];
        int column = position[1];

        return switch (direction) {
            case '<' -> new int[]{row, column - 1};
            case '>' -> new int[]{row, column + 1};
            case '^' -> new int[]{row - 1, column};
            case 'v' -> new int[]{row + 1, column};
            default -> position;
        };
    }

    public boolean checkIsWallAhead(char direction) {
        int[] nextPos = getPositionAhead(direction);
        return worldMap[nextPos[0]][nextPos[1]] == WALL;
    }

    public boolean checkIsStarAhead(char direction) {
        int[] nextPos = getPositionAhead(direction);
        return worldMap[nextPos[0]][nextPos[1]] == STAR;
    }

    public void updatePosition(int[] newPosition, char newDirection) {
        int[] oldPosition = getCurrentPosition();
        worldMap[oldPosition[0]][oldPosition[1]] = ' ';
        worldMap[newPosition[0]][newPosition[1]] = newDirection;
    }
}