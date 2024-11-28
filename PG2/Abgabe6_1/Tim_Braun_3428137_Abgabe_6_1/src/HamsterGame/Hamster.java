package HamsterGame;
public class Hamster {
    private GameMap gameMap;
    private int foodCount = 0;

    public Hamster(GameMap map) {
        this.gameMap = map;
    }

    public void turnLeft() {
        char currentDirection = gameMap.getHamsterSymbol();
        char newDirection = switch (currentDirection) {
            case '<' -> 'v';
            case '>' -> '^';
            case '^' -> '<';
            case 'v' -> '>';
            default -> currentDirection;
        };
        updateHamsterDirection(newDirection);
    }

    public void turnRight() {
        char currentDirection = gameMap.getHamsterSymbol();
        char newDirection = switch (currentDirection) {
            case '<' -> '^';
            case '>' -> 'v';
            case '^' -> '>';
            case 'v' -> '<';
            default -> currentDirection;
        };
        updateHamsterDirection(newDirection);
    }

    private void updateHamsterDirection(char newDirection) {
        int[] currentPosition = gameMap.getCurrentPosition();
        gameMap.updatePosition(currentPosition, newDirection);
    }

    public void walkForward() {
        char currentDirection = gameMap.getHamsterSymbol();
        int[] currentPosition = gameMap.getCurrentPosition();

        if (!gameMap.checkIsWallAhead(currentDirection)) {
            int[] newPosition = calculateNewPosition(currentPosition, currentDirection);

            if (gameMap.checkIsStarAhead(currentDirection)) {
                increaseFoodCount();
            }

            gameMap.updatePosition(newPosition, currentDirection);
        } else {
            printWatchOutWall();
        }
    }

    private int[] calculateNewPosition(int[] currentPosition, char direction) {
        int row = currentPosition[0];
        int column = currentPosition[1];

        return switch (direction) {
            case '<' -> new int[]{row, column - 1};
            case '>' -> new int[]{row, column + 1};
            case '^' -> new int[]{row - 1, column};
            case 'v' -> new int[]{row + 1, column};
            default -> currentPosition;
        };
    }

    public void printWatchOutWall() {
        System.out.println("\n!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        System.out.println("!!  There is a wall in front of you! You have to turn around! !!");
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        pause(5000);
    }

    private void pause(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    public void displayFoodCount() {
        String starText = foodCount == 1 ? "Grain" : "Grains";
        System.out.println("Currently you have eaten " + foodCount + " " + starText);
        pause(3000);
    }

    private void increaseFoodCount() {
        foodCount++;
        String starText = foodCount == 1 ? "Grain" : "Grains";
        System.out.println("You just ate a grain! Total: " + foodCount + " " + starText);
        pause(2000);
    }
}