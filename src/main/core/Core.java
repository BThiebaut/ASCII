package main.core;

import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import main.utils.Utils;

public class Core {
	
	static String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ?";

	public static void main(String[] args) {
		// Affiche en console ou par une JFrame
		boolean console = false;
        String text = Utils.askDialog("Phrase à afficher ?", null);
        text = text.toUpperCase();
        // Taille du tableau pour recherche
		int width = 4;
		int height = 5;
		
		ArrayList<String> ascii = new ArrayList<String>();
		
		ascii.add(" #  ##   ## ##  ### ###  ## # # ###  ## # # #   # # ###  #  ##   #  ##   ## ### # # # # # # # # # # ### ###  ");
		ascii.add("# # # # #   # # #   #   #   # #  #    # # # #   ### # # # # # # # # # # #    #  # # # # # # # # # #   #   #  ");
		ascii.add("### ##  #   # # ##  ##  # # ###  #    # ##  #   ### # # # # ##  # # ##   #   #  # # # # ###  #   #   #   ##  ");
		ascii.add("# # # # #   # # #   #   # # # #  #  # # # # #   # # # # # # #    ## # #   #  #  # # # # ### # #  #  #        ");
		ascii.add("# # ##   ## ##  ### #    ## # # ###  #  # # ### # # # #  #  #     # # # ##   #  ###  #  # # # #  #  ###  #  ");
		
		ArrayList<Integer> indexes = new ArrayList<Integer>();
		for(char c : text.toCharArray()) {
			if(c < 'A' || c > 'Z') indexes.add(26); // Si la lettre n'est pas entre A et Z, on remplace par "?"
			else { // Sinon on récupère l'index du charactère dans un tableau
				for(char letter : alphabet.toCharArray()) {
					if(c == letter) {
						indexes.add(alphabet.indexOf(letter));
					}
				}
			}
		}
		String message = "";
		for(int j = 0; j < height; j++) { // Colonnes
			for(int k = 0; k < indexes.size(); k++) { // Lignes
				// On récupère le caractère à l'index * longueur pour obtenir le début + la longueur pour la fin du caractère en cours
				message += ascii.get(j).substring(indexes.get(k)*width, indexes.get(k)*width + width);
				//System.out.print(ascii.get(j).substring(indexes.get(k)*width, indexes.get(k)*width + width));
			}
			//System.out.println("");
			message += "\n";
		}
		
		if (console){
			System.out.print(message);
		}else {
			// Double les espaces pour plus de lisibilité
			message = message.replace(" ", "  ");
			// Ouvre tes chakra et tu verra le text (ou plisse les yeux, ça récupère mal les espace ...)
			Utils.infoBox(message, "Resultats");
		}
	}
	
}

