package DefiningClassesEx.PokemonTrainer;

import java.util.ArrayList;

public class Trainer {
    private String name;
    private int numberOfBadges;
    private ArrayList<Pokemon> pokemonCollection;

    public Trainer(String name, int numberOfBadges) {
        this.name = name;
        this.numberOfBadges = numberOfBadges;
        this.pokemonCollection = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfBadges() {
        return numberOfBadges;
    }

    public void setNumberOfBadges(int numberOfBadges) {
        this.numberOfBadges = numberOfBadges;
    }

    public ArrayList<Pokemon> getPokemonCollection() {
        return pokemonCollection;
    }

    public void addPokemonToCollection(Pokemon pokemon) {
        this.pokemonCollection.add(pokemon);
    }

    public boolean isElementInCollection(String element) {
        for (Pokemon pokemon : pokemonCollection) {
            if (pokemon.getElement().equals(element)) {
                return true;
            }
        }
        return false;
    }

    public void takeHealthFromCollection() {
        for (Pokemon pokemon : pokemonCollection) {
            pokemon.setHealth(pokemon.getHealth() - 10);
        }

        pokemonCollection.removeIf(pokemon -> pokemon.getHealth() <= 0);
    }
}
