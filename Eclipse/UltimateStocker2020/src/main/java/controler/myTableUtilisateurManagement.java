package controler;

import java.util.Iterator;

import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

import model.ChefRayon;

/**
 * Cette classe contient les méthode qui vont permettre de remplis la JTable pour afficher les utilisateurs
 * @author Pierre Savary & Adrien Verdier
 *
 */
public class myTableUtilisateurManagement extends AbstractTableModel {
	
	private static final long serialVersionUID = 3L;
	private String[] columnNames;
	private JTable table;

	public myTableUtilisateurManagement(String[] columnNames) {
		this.columnNames = columnNames;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	public int getColumnCount() {
		return columnNames.length;
	}

	public int getRowCount() {
		return gestionUtilisateur.nombreChefRayon();
	}

	@Override
	public String getColumnName(int col) {
		return columnNames[col];
	}

	public void removeRow(int row) {
		gestionUtilisateur.supprimerChefRayon((Integer) table.getValueAt(row, 0));
		
		this.fireTableDataChanged();
	}

	public Object getValueAt(int row, int col) {

		if (gestionUtilisateur.nombreChefRayon() != 0) {
			Iterator<ChefRayon> iterator = gestionUtilisateur.getChefRayon().iterator();

			for (int i = 0; i < row; i++)
				iterator.next();

			ChefRayon utilisateurSelected = iterator.next();

			switch (col) {
			case 0:
				return utilisateurSelected.getIDChefRayon();
			case 1:
				return utilisateurSelected.getNom();
			case 2:
				return utilisateurSelected.getPrenom();
			case 3:
				return utilisateurSelected.getIDRayon().getIDRayon();
			default:
				return "";
			}
		}
		return null;
	}

	@Override
	public Class<? extends Object> getColumnClass(int c) {
		if (getValueAt(0, c) != null)
			return getValueAt(0, c).getClass();
		else
			return null;
	}

}
