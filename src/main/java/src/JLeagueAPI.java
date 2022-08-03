package src;

import src.core.GetChampionsMastery;

import java.io.IOException;
import java.util.Scanner;

public class JLeagueAPI {

    public static void main(String[] args) throws IOException {
        String choice;
        String summonerName;

        Scanner sc = new Scanner(System.in);

        System.out.println("Bem vindo ao JLeague API");
        System.out.println("Selecione o que deseja fazer:");
        System.out.println("1 - Descobrir as maestrias dos campeoes da conta");

        choice = sc.nextLine();
        switch (choice) {
            case "1":
                System.out.println("Digite o nome de invocador");
                summonerName = sc.nextLine();
                GetChampionsMastery getMastery = new GetChampionsMastery();
                getMastery.getChampionsMastery(summonerName);

                break;
            default:
                System.out.println("Selecione o que deseja fazer:");
                System.out.println("1 - Descobrir as maestrias dos campeoes da conta");

                choice = sc.nextLine();

        }
    }

}
