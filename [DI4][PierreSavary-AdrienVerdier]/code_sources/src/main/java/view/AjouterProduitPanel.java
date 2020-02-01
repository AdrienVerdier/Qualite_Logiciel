package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import controler.gestionProduit;

/**
 * Cette classe représente le panel qui permet d'ajouter un produit
 * @author Pierre Savary & Adrien Verdier
 *
 */
public class AjouterProduitPanel extends JPanel implements ActionListener {
	
	private static final long serialVersionUID = 11L;
	private JButton returnButton, applyButton;
	private JFrame frame;
	private JLabel textLabel1, textLabel2, textLabel3, textLabel4, label, validateLabel;
	private JTextField textZone1, textZone2, textZone3, textZone4;
	private boolean isChefMagasin;
	private int idUser;
	private String police = "Arial";
	private boolean isAdd;
	private int idRayon;
	private int idProduit;

	/**
	 * Cette méthode crée tous les objets qui vont être affiché sur la fenêtre
	 * @param frame la frame sur laquelle doit s'afficher le panel
	 * @param idUser l'identifiant de l'utilisateur qui est connecté à l'application
	 * @param isChefMagasin booléen précisant si l'utilisateur connecté est un chef de magasin ou non
	 * @param idRayon identifiant du rayon ou se trouve le produit
	 * @param isAdd booléen précisent si on ajoute ou modifie le produit
	 * @param aModifier identifiant du produit à modifier (-1 si ajout)
	 */
	public AjouterProduitPanel(JFrame frame, int idUser, boolean isChefMagasin, int idRayon, boolean isAdd, int aModifier) {
		this.isChefMagasin = isChefMagasin;
		this.idUser = idUser;
		this.isAdd = isAdd;
		this.frame = frame;
		this.idRayon = idRayon;
		this.idProduit = aModifier;
		
		this.setLayout(null);
		this.frame.setContentPane(this);

		label = new JLabel("Ajout/Modification d'un produit");
		label.setLayout(null);
		label.setFont(new Font(police, Font.BOLD, 20));
		label.setBounds(25, 0, 300, 40);
		this.add(label);
		
		textLabel4 = new JLabel("Nom", SwingConstants.CENTER);
		textLabel4.setLayout(null);
		textLabel4.setFont(new Font(police, Font.BOLD, 20));
		textLabel4.setBounds(appInterface.windowsSizeX - 800, appInterface.windowsSizeY - 700, 300, 50);
		textLabel4.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		textLabel4.setBackground(Color.LIGHT_GRAY);
		textLabel4.setOpaque(true);
		this.add(textLabel4);

		textZone4 = new JTextField();
		textZone4.setFont(new Font(police, Font.BOLD, 20));
		textZone4.setLayout(null);
		textZone4.setBounds(appInterface.windowsSizeX - 500, appInterface.windowsSizeY - 700, 300, 50);
		this.add(textZone4);
		textZone4.setHorizontalAlignment(SwingConstants.CENTER);
		if(!isAdd) {
			textZone4.setText(gestionProduit.getNom(aModifier));
		}

		textLabel1 = new JLabel("Description", SwingConstants.CENTER);
		textLabel1.setLayout(null);
		textLabel1.setFont(new Font(police, Font.BOLD, 20));
		textLabel1.setBounds(appInterface.windowsSizeX - 800, appInterface.windowsSizeY - 600, 300, 50);
		textLabel1.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		textLabel1.setBackground(Color.LIGHT_GRAY);
		textLabel1.setOpaque(true);
		this.add(textLabel1);

		textZone1 = new JTextField();
		textZone1.setFont(new Font(police, Font.BOLD, 20));
		textZone1.setLayout(null);
		textZone1.setBounds(appInterface.windowsSizeX - 500, appInterface.windowsSizeY - 600, 300, 50);
		this.add(textZone1);
		textZone1.setHorizontalAlignment(SwingConstants.CENTER);
		if(!isAdd) {
			textZone1.setText(gestionProduit.getDescription(aModifier));
		}

		textLabel2 = new JLabel("Prix", SwingConstants.CENTER);
		textLabel2.setLayout(null);
		textLabel2.setFont(new Font(police, Font.BOLD, 20));
		textLabel2.setBounds(appInterface.windowsSizeX - 800, appInterface.windowsSizeY - 500, 300, 50);
		textLabel2.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		textLabel2.setBackground(Color.LIGHT_GRAY);
		textLabel2.setOpaque(true);
		this.add(textLabel2);
		
		textZone2 = new JTextField();
		textZone2.setFont(new Font(police, Font.BOLD, 20));
		textZone2.setLayout(null);
		textZone2.setBounds(appInterface.windowsSizeX - 500, appInterface.windowsSizeY - 500, 300, 50);
		textZone2.setHorizontalAlignment(SwingConstants.CENTER);
		this.add(textZone2);
		if(!isAdd) {
			textZone2.setText("" + gestionProduit.getPrix(aModifier));
		}

		textLabel3 = new JLabel("Quantite", SwingConstants.CENTER);
		textLabel3.setLayout(null);
		textLabel3.setFont(new Font(police, Font.BOLD, 20));
		textLabel3.setBounds(appInterface.windowsSizeX - 800, appInterface.windowsSizeY - 400, 300, 50);
		textLabel3.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		textLabel3.setBackground(Color.LIGHT_GRAY);
		textLabel3.setOpaque(true);
		this.add(textLabel3);

		textZone3 = new JTextField();
		textZone3.setFont(new Font(police, Font.BOLD, 20));
		textZone3.setLayout(null);
		textZone3.setBounds(appInterface.windowsSizeX - 500, appInterface.windowsSizeY - 400, 300, 50);
		textZone3.setHorizontalAlignment(SwingConstants.CENTER);
		this.add(textZone3);
		if(!isAdd) {
			textZone3.setText("" + gestionProduit.getQuantite(aModifier));
		}

		applyButton = new JButton("APPLIQUER");
		applyButton.setBounds(appInterface.windowsSizeX - 600, appInterface.windowsSizeY - 150, 175, 50);
		applyButton.setFont(new Font(police, Font.BOLD, 20));
		applyButton.setForeground(Color.BLACK);
		applyButton.setBackground(Color.LIGHT_GRAY);
		this.add(applyButton);
		applyButton.addActionListener(this);

		returnButton = new JButton("RETOUR");
		returnButton.setBounds(appInterface.windowsSizeX - 225, appInterface.windowsSizeY - 125, 175, 50);
		returnButton.setFont(new Font(police, Font.BOLD, 20));
		returnButton.setForeground(Color.BLACK);
		returnButton.setBackground(Color.LIGHT_GRAY);
		this.add(returnButton);
		returnButton.addActionListener(this);

		validateLabel = new JLabel();
		validateLabel.setLayout(null);
		validateLabel.setForeground(Color.green.darker());
		validateLabel.setFont(new Font(police, Font.BOLD, 20));
		validateLabel.setBounds(appInterface.windowsSizeX - 650, appInterface.windowsSizeY - 100, 400, 40);
		this.add(validateLabel);

	}

	/**
	 * Cette méthode regroupe toutes les actions qui vont s'effectuer si l'utilisateur appuie sur un bouton
	 */
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == applyButton) {

			if (textZone1.getText().equals("") || (textZone2.getText().equals("")) || (textZone3.getText().equals("")) || textZone4.getText().equals("")) {
				if (textZone1.getText().equals(""))
					textZone1.setBorder(new LineBorder(Color.red, 1));
				else
					textZone1.setBorder(new LineBorder(Color.GRAY, 1));

				if (textZone2.getText().equals(""))
					textZone2.setBorder(new LineBorder(Color.red, 1));
				else
					textZone2.setBorder(new LineBorder(Color.GRAY, 1));
				
				if (textZone3.getText().equals(""))
					textZone3.setBorder(new LineBorder(Color.red, 1));
				else
					textZone3.setBorder(new LineBorder(Color.GRAY, 1));
				
				if (textZone4.getText().equals(""))
					textZone4.setBorder(new LineBorder(Color.red, 1));
				else
					textZone4.setBorder(new LineBorder(Color.GRAY, 1));

				validateLabel.setText("Certain champs ne sont pas rempli");
				validateLabel.setForeground(Color.red.darker());
			} 
			else {
				validateLabel.setText("");
			}

			if(Integer.parseInt(textZone2.getText()) < 0 || Integer.parseInt(textZone3.getText()) < 0) {
				if (textZone2.getText().equals(""))
					textZone2.setBorder(new LineBorder(Color.red, 1));
				else
					textZone2.setBorder(new LineBorder(Color.GRAY, 1));
				
				if (textZone3.getText().equals(""))
					textZone3.setBorder(new LineBorder(Color.red, 1));
				else
					textZone3.setBorder(new LineBorder(Color.GRAY, 1));
				
				validateLabel.setText("La quantite et/ou le prix ne peut pas être négatif");
				validateLabel.setForeground(Color.red.darker());
			}
			else if (!(textZone1.getText().equals("")) && (!(textZone2.getText().equals(""))) && (!(textZone3.getText().equals(""))) && !(textZone4.getText().equals(""))) {
				validateLabel.setText("La scène a été ajouté");
				validateLabel.setForeground(Color.green.darker());

				if(isAdd) {
					gestionProduit.ajouterProduit(textZone4.getText(), textZone1.getText(), Integer.parseInt(textZone2.getText()), Integer.parseInt(textZone3.getText()), idRayon);
					validateLabel.setText("L'Utilisateur a été créé");
					validateLabel.setForeground(Color.green.darker());
				}
				else {
					gestionProduit.modifierProduit(idProduit,textZone4.getText(), textZone1.getText(), Integer.parseInt(textZone2.getText()), Integer.parseInt(textZone3.getText()), idRayon);
					validateLabel.setText("L'Utilisateur a été créé");
					validateLabel.setForeground(Color.green.darker());
				}
				
			}
		}

		if (e.getSource() == returnButton) {
			JPanel AffichageProduitPanel = new AffichageProduitPanel(frame, idUser, isChefMagasin, idRayon);
			frame.repaint();
			frame.revalidate();
		}
	}

}
