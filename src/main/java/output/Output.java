package output;

import team.Team;

import agent.Agent;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Output {

    private static Scanner x;

    public static void updateResultsFile(int blueTeamWins, List<Agent> players, int victoryType, int turnNb, int greenReturned, int redToBlue, int blueToRed) {
        String filePath = "results/results.csv";

        //Get red and blue teams
        List<String> blueTeam = new ArrayList<>();
        List<String> redTeam = new ArrayList<>();
        for (Agent a: players) {
            if(a.getTeam() == Team.BLUE){
                blueTeam.add(a.getClass().getSimpleName());
            } else {
                redTeam.add(a.getClass().getSimpleName());
            }
        }

        edit(filePath, blueTeamWins, blueTeam, redTeam, victoryType, turnNb, greenReturned, redToBlue, blueToRed);
    }

    private static void edit(String filePath, int blueTeamWins, List<String> blueTeam, List<String> redTeam,
                             int victoryType, int turnNb, int greenReturned, int redToBlue, int blueToRed){

        try
        {
            FileWriter fileWriter = new FileWriter(filePath, true);
            BufferedWriter bw = new BufferedWriter(fileWriter);
            PrintWriter pw = new PrintWriter(bw);

            pw.println(blueTeamWins + ";" + blueTeam + ";" + redTeam + ";" + victoryType +
                    ";" + turnNb + ";" + greenReturned + ";" + redToBlue + ";" + blueToRed);

            pw.flush();
            pw.close();
        }
        catch (Exception e)
        {
            System.out.println("Error" + e);
        }
    }
}
