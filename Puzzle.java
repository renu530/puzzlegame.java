import java.util.ArrayList;

public class Puzzle {

    private ArrayList<String> countryList = new ArrayList<>();
    private ArrayList<String> guessedCountries = new ArrayList<>();
    private GameHelper helper = new GameHelper();

    public static void main(String[] args) {
        Puzzle game = new Puzzle();
        System.out.println("Game started!");
        game.placeCountries();
        game.startPlaying();
    }

    public void placeCountries() {
        // Define countries
        countryList.add("India");
        countryList.add("Israel");
        countryList.add("Japan");

        // Place countries in the grid using GameHelper
        helper.placeCountry("India");
        helper.placeCountry("Israel");
        helper.placeCountry("Japan");
    }

    public void startPlaying() {
        // Your game logic here
    }

    public String checkGuess(String userInput) {
        String result = "miss";
        for (String country : countryList) {
            result = helper.checkUserGuess(userInput, country);
            if (result.equals("hit")) {
                break;
            } else if (result.equals("kill")) {
                guessedCountries.add(country);
                countryList.remove(country);
                break;
            }
        }
        return result;
    }

    public boolean allCountriesGuessed() {
        return guessedCountries.size() == countryList.size();
    }
}

