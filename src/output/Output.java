package output;

import agent.Agent;

import java.io.*;
import java.util.List;
import java.util.Scanner;

public class Output {

    public static void updateResultsFile(Boolean blueTeamWins, List<Agent> players) {
        String filePath = "results.txt";

        edit(filePath, blueTeamWins, players);
    }

    private static Scanner x;

    private static void edit(String filePath, Boolean blueTeamWins, List<Agent> players){
        String editPartyNb = "nbParty";
        String editBlue = "blueWin";
        String editRed = "redWin";

        String tempFile = "temp.txt";
        File oldFile = new File(filePath);
        File newFile = new File(tempFile);

        String ID = "";
        String occ = "";

        try
        {
            FileWriter fileWriter = new FileWriter(tempFile, true);
            BufferedWriter bw = new BufferedWriter(fileWriter);
            PrintWriter pw = new PrintWriter(bw);

            x = new Scanner(new File(filePath));
            x.useDelimiter("[,\n]");

            while (x.hasNext())
            {
                ID = x.next();
                occ = x.next();

                if(ID.equals(editPartyNb)){
                    int nb = Integer.parseInt(occ);
                    occ = String.valueOf(nb + 1);

                    pw.println(ID + "," + occ);
                } else if (ID.equals(editBlue) && blueTeamWins){
                    int nb = Integer.parseInt(occ);
                    occ = String.valueOf(nb + 1);

                    pw.println(ID + "," + occ);
                } else if (ID.equals(editRed) && !blueTeamWins) {
                    int nb = Integer.parseInt(occ);
                    occ = String.valueOf(nb + 1);

                    pw.println(ID + "," + occ);
                }else{
                    pw.println(ID + "," + occ);
                }
            }

            x.close();
            pw.flush();
            pw.close();
            oldFile.delete();
            File dump = new File(filePath);
            newFile.renameTo(dump);
        }
        catch (Exception e)
        {
            System.out.println("Error");
        }
    }
}
