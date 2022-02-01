package DefiningClassesEx.PokemonTrainer;

/*
You want to be the very best pokemon trainer, like no one ever was, so you set out to catch pokemons. Define a class
Trainer and a class Pokemon. The trainer has a name, number of badges, and a collection of pokemon. Pokemon
has a name, an element, and health, all values are mandatory. Every Trainer starts with 0 badges.
From the console you will receive an unknown number of lines until you receive the command "Tournament", each
line will carry information about a pokemon and the trainer who caught it in the format "{TrainerName}
{PokemonName} {PokemonElement} {PokemonHealth}" where TrainerName is the name of the Trainer who
caught the pokemon, names are unique there cannot be 2 trainers with the same name. After receiving the
command &quot;Tournament&quot; an unknown number of lines containing one of three elements "Fire", "Water",
"Electricity" will follow until the command "End" is received. For every command you must check if a trainer
has at least 1 pokemon with the given element, if he does, he receives 1 badge, otherwise, all his pokemon lose 10
health, if a pokemon falls to 0 or less health he dies and must be deleted from the trainer’s collection. After the
command "End" is received you should print all trainers sorted by the amount of badges they have in descending
order (if two trainers have the same amount of badges they should be sorted by order of appearance in the input) in
the format "{TrainerName} {Badges} {NumberOfPokemon}".
 */

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, Trainer> trainerMap = new LinkedHashMap<>();

        String input = scan.nextLine();

        while (!input.equals("Tournament")) {
            String[] data = input.split("\\s+");

            String trainerName = data[0];
            Pokemon pokemon = readPokemonData(data);

            if (!trainerMap.containsKey(trainerName)) {
                Trainer trainer = new Trainer(trainerName, 0);
                trainerMap.put(trainerName, trainer);
            }

            trainerMap.get(trainerName).addPokemonToCollection(pokemon);

            input = scan.nextLine();
        }

        input = scan.nextLine();

        while (!input.equals("End")) {
            for (Map.Entry<String, Trainer> entry : trainerMap.entrySet()) {
                if (entry.getValue().isElementInCollection(input)) {
                    entry.getValue().setNumberOfBadges(entry.getValue().getNumberOfBadges() + 1);
                } else {
                    entry.getValue().takeHealthFromCollection();
                }
            }

            input = scan.nextLine();
        }

        printOutput(trainerMap);
    }

    public static void printOutput(Map<String, Trainer> trainerMap) {
        Set<Trainer> trainers = new LinkedHashSet<>();

        for (Map.Entry<String, Trainer> entry : trainerMap.entrySet()) {
            trainers.add(entry.getValue());
        }

        trainers.stream()
                        .sorted(Comparator.comparing(Trainer::getNumberOfBadges).reversed())
                                .forEach(trainer -> System.out.println(trainer.getName() + " "
                                        + trainer.getNumberOfBadges() + " "
                                        + trainer.getPokemonCollection().size()));
    }

    public static Pokemon readPokemonData(String[] data) {
        String name = data[1];
        String element = data[2];
        int health = Integer.parseInt(data[3]);

        return new Pokemon(name, element, health);
    }
}
