import java.util.HashMap;
import java.util.Map;

public class GameHelper {
    private Map<String, String[]> grid = new HashMap<>();

    public static void main(String[] args) {
        GameHelper game = new GameHelper();
        game.placeCountry("India");
        System.out.println(game.checkUserGuess("a4", "India")); // Example usage
    }

    public void placeCountry(String country) {
        String[] cells = new String[3];
        if (country.equals("India")) {
            cells = new String[]{"a4", "a5", "a6"};
        } else if (country.equals("Israel")) {
            cells = new String[]{"c2", "d2", "e2"};
        } else if (country.equals("Japan")) {
            cells = new String[]{"b4", "b5", "b6"};
        }
        grid.put(country, cells);
    }

    public String checkUserGuess(String userInput, String country) {
        String result = "miss";
        String[] location = grid.get(country);
        for (String cell : location) {
            if (userInput.equals(cell)) {
                result = "hit";
                break;
            }
        }

        if (result.equals("hit")) {
            if (allCellsHit(country)) {
                result = "kill";
            }
        }
        return result;
    }

    private boolean allCellsHit(String country) {
        boolean allHit = true;
        String[] location = grid.get(country);
        for (String cell : location) {
            if (!cell.equals("hit")) {  // This should check for "hit" status in a more sophisticated game
                allHit = false;
                break;
            }
        }
        return allHit;
    }
}

