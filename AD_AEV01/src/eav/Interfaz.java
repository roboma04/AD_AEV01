package eav;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import java.awt.TextField;

/**
 * Classe Interfície que representa la interfície d'usuari principal.
 */
public class Interfaz extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JList<String> list;
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();

	/**
     * Punt d'entrada principal de l'aplicació.
     *
     * @param args Arguments de la línia de comandos.
     */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interfaz frame = new Interfaz();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
     * Constructor de la classe Interfície que crea la interfície d'usuari.
     */
	public Interfaz() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 881, 451);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 128, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		// Etiqueta que indica "*Directori"
		JLabel lblDirec = new JLabel("Directori:");
		lblDirec.setForeground(new Color(216, 216, 235));
		lblDirec.setBounds(104, 7, 69, 39);
		lblDirec.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblDirec);

		// Camp de text per a ingressar directori
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField.setColumns(10);
		textField.setBounds(183, 10, 397, 34);
		contentPane.add(textField);

		// Botó per a realitzar la cerca en el directori
		JButton btnBuscador = new JButton("Buscar");
		btnBuscador.setBackground(new Color(73, 73, 148));
		btnBuscador.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnBuscador.setBounds(602, 10, 107, 35);
		contentPane.add(btnBuscador);

		// Botó per a fusionar arxius seleccionats
		JButton btnFusionar = new JButton("Fusionar");
		btnFusionar.setBackground(new Color(73, 73, 148));
		btnFusionar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnFusionar.setBounds(730, 10, 107, 35);
		contentPane.add(btnFusionar);

		// Panell per a seleccionar l'ordre ascendent o descendent
		Panel panel_1 = new Panel();
		panel_1.setLayout(null);
		panel_1.setBounds(33, 176, 151, 64);
		contentPane.add(panel_1);

		// Opció per a ordenar de manera ascendent
		JRadioButton rdbtnAscendent = new JRadioButton("Ascendent");
		rdbtnAscendent.setForeground(new Color(216, 216, 235));
		buttonGroup.add(rdbtnAscendent);
		rdbtnAscendent.setSelected(true);
		rdbtnAscendent.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnAscendent.setBackground(new Color(128, 128, 192));
		rdbtnAscendent.setBounds(19, 6, 126, 23);
		panel_1.add(rdbtnAscendent);

		// Opció per a ordenar de manera descendent
		JRadioButton rdbtnDescendent = new JRadioButton("Descendent");
		rdbtnDescendent.setForeground(new Color(216, 216, 235));
		buttonGroup.add(rdbtnDescendent);
		rdbtnDescendent.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnDescendent.setBackground(new Color(128, 128, 192));
		rdbtnDescendent.setBounds(19, 33, 126, 23);
		panel_1.add(rdbtnDescendent);

		// Panell per a seleccionar el tipus d'ordenació
		Panel panel = new Panel();
		panel.setLayout(null);
		panel.setBackground(new Color(128, 128, 192));
		panel.setBounds(33, 271, 151, 92);
		contentPane.add(panel);

		// Opció per a ordenar per nom
		JRadioButton rdbtnNom = new JRadioButton("Nom");
		rdbtnNom.setForeground(new Color(216, 216, 235));
		buttonGroup_1.add(rdbtnNom);
		rdbtnNom.setSelected(true);
		rdbtnNom.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnNom.setBackground(new Color(128, 128, 192));
		rdbtnNom.setBounds(22, 6, 75, 23);
		panel.add(rdbtnNom);

		// Opció per a ordenar per grandària
		JRadioButton rdbtnGrandaria = new JRadioButton("Grandaria");
		rdbtnGrandaria.setForeground(new Color(216, 216, 235));
		buttonGroup_1.add(rdbtnGrandaria);
		rdbtnGrandaria.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnGrandaria.setBackground(new Color(128, 128, 192));
		rdbtnGrandaria.setBounds(22, 31, 111, 23);
		panel.add(rdbtnGrandaria);

		// Opció per a ordenar per data de modificació
		JRadioButton rdbtnModificacio = new JRadioButton("Modificacio");
		rdbtnModificacio.setForeground(new Color(216, 216, 235));
		buttonGroup_1.add(rdbtnModificacio);
		rdbtnModificacio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnModificacio.setBackground(new Color(128, 128, 192));
		rdbtnModificacio.setBounds(22, 56, 111, 23);
		panel.add(rdbtnModificacio);
		
		// Panell amb barra de desplaçament per a mostrar la llista d'arxius
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(216, 145, 575, 242);
		contentPane.add(scrollPane);

		// Llista per a mostrar informació d'arxius
		list = new JList<>();
		scrollPane.setViewportView(list);

		// Camp de text per a ingressar la paraula a buscar
		TextField textField_1 = new TextField();
		textField_1.setFont(new Font("Dialog", Font.PLAIN, 14));
		textField_1.setBounds(194, 72, 357, 31);
		contentPane.add(textField_1);

		// Botó per a iniciar la cerca de coincidències
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBackground(new Color(73, 73, 148));
		btnBuscar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnBuscar.setBounds(602, 72, 107, 35);
		contentPane.add(btnBuscar);

		// Etiqueta que mostra "*Coincidències:"
		JLabel lblCoincidenci = new JLabel("Coincidències:");
		lblCoincidenci.setForeground(new Color(216, 216, 235));
		lblCoincidenci.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblCoincidenci.setBounds(77, 117, 107, 31);
		contentPane.add(lblCoincidenci);

		// Etiqueta que mostra el nombre de coincidències
		JLabel lblCoincidencies = new JLabel("0");
		lblCoincidencies.setForeground(new Color(216, 216, 235));
		lblCoincidencies.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblCoincidencies.setBounds(188, 117, 39, 31);
		contentPane.add(lblCoincidencies);

		// Etiqueta que indica "Introdueix una paraula:"
		JLabel lblIntroPalabra = new JLabel("Introdueix una paraula:");
		lblIntroPalabra.setForeground(new Color(216, 216, 235));
		lblIntroPalabra.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblIntroPalabra.setBounds(10, 72, 174, 39);
		contentPane.add(lblIntroPalabra);

		// ActionListener per al botó "Buscar" en la secció de cerca de coincidències.
		btnBuscador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String directori = textField.getText();
				DefaultListModel<String> listModel = new DefaultListModel<>();
				File directoriSeleccionat = new File(directori);

				if (directoriSeleccionat.isDirectory()) {
					File[] arxius = directoriSeleccionat.listFiles(new FilenameFilter() {
						public boolean accept(File dir, String name) {
							return name.endsWith(".txt");
						}
					});

					if (arxius != null) {
						ArrayList<String> infoArxius = new ArrayList<>();

						for (File arxiu : arxius) {
							String nom = arxiu.getName();
							long grandaria = arxiu.length();
							long modificacio = arxiu.lastModified();

							SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
							String dataModificacio = sdf.format(new Date(modificacio));
							String extensió = obtenirExtensio(nom);

							String infoArxiu = "Nom: " + nom + " --- Extensió: " + extensió + " --- Grandaria: "
									+ grandaria + " bytes --- Última modificació: " + dataModificacio;

							infoArxius.add(infoArxiu);
						}

						if (rdbtnAscendent.isSelected()) {
							Collections.sort(infoArxius);
						} else if (rdbtnDescendent.isSelected()) {
							Collections.sort(infoArxius, Collections.reverseOrder());
						}

						for (String infoArxiu : infoArxius) {
							listModel.addElement(infoArxiu);
						}
					}
				}

				list.setModel(listModel);
			}
		});

		// ActionListener per al botó "Fusionar" que fusiona arxius seleccionats.
		btnFusionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String selectedItem = list.getSelectedValue();

				if (selectedItem == null) {
					JOptionPane.showMessageDialog(contentPane, "Selecciona un arxiu per fusionar.", "Error",
							JOptionPane.ERROR_MESSAGE);
					return;
				}

				String nuevoNombre = JOptionPane.showInputDialog(contentPane,
						"Introdueix un nom per a l'arxiu fusionat:", "Nom de l'arxiu", JOptionPane.PLAIN_MESSAGE);

				if (nuevoNombre == null || nuevoNombre.isEmpty()) {
					return;
				}

				File directorio = new File(textField.getText());
				File archivoFusionado = new File(directorio, nuevoNombre + ".txt");

				if (archivoFusionado.exists()) {
					int confirmacion = JOptionPane.showConfirmDialog(contentPane,
							"L'arxiu ja existeix. Vols sobreescriure'l?", "Sobreescriure arxiu",
							JOptionPane.YES_NO_OPTION);
					if (confirmacion != JOptionPane.YES_OPTION) {
						return;
					}
				}

				String nombreArchivo = selectedItem.substring(5, selectedItem.indexOf(" --- Extensió"));

				File archivoSeleccionado = new File(directorio, nombreArchivo);

				try (FileWriter fileWriter = new FileWriter(archivoFusionado);
						BufferedReader bufferedReader = new BufferedReader(new FileReader(archivoSeleccionado))) {
					String line;
					while ((line = bufferedReader.readLine()) != null) {
						fileWriter.write(line);
						fileWriter.write("\n");
					}

					JOptionPane.showMessageDialog(contentPane, "La fusión de archivos se completó con éxito.", "Éxito",
							JOptionPane.INFORMATION_MESSAGE);
				} catch (IOException ex) {
					JOptionPane.showMessageDialog(contentPane, "Error al fusionar archivos: " + ex.getMessage(),
							"Error", JOptionPane.ERROR_MESSAGE);
					ex.printStackTrace();
				}
			}
		});

		// ActionListener per al botó "Buscar" en la secció de cerca de coincidències.
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String textCerca = textField_1.getText();

				DefaultListModel<String> listModel = new DefaultListModel<>();
				File directoriSeleccionat = new File(textField.getText());

				if (directoriSeleccionat.isDirectory()) {
					File[] arxius = directoriSeleccionat.listFiles(new FilenameFilter() {
						public boolean accept(File dir, String name) {
							return name.endsWith(".txt");
						}
					});

					if (arxius != null) {
						for (File arxiu : arxius) {
							int coincidencies = cercarCoincidenciesEnArxiu(arxiu, textCerca);
							String nomArxiu = arxiu.getName();
							listModel.addElement(nomArxiu + " -> " + coincidencies + " coincidencies");
						}
					}
				}

				list.setModel(listModel);

				lblCoincidencies.setText(String.valueOf(listModel.size()));
			}
		});

	}
	
	/**
     * Busca coincidències en un arxiu.
     *
     * @param arxiu     L'arxiu en el qual es busca coincidències.
     * @param textCerca La cadena de text que es busca.
     * @return El nombre de coincidències trobades.
     */
	private int cercarCoincidenciesEnArxiu(File arxiu, String textCerca) {
		int coincidencies = 0;

		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(arxiu))) {
			String linea;
			while ((linea = bufferedReader.readLine()) != null) {
				coincidencies += comptarCoincidencies(linea, textCerca);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return coincidencies;
	}
	
	/**
     * Compte les coincidències d'una cadena en una línia.
     *
     * @param linea     La línia en la qual es busca.
     * @param textCerca La cadena que es busca.
     * @return El nombre de coincidències en la línia.
     */
	private int comptarCoincidencies(String linea, String textCerca) {
		int coincidencies = 0;
		int index = 0;
		while ((index = linea.indexOf(textCerca, index)) != -1) {
			coincidencies++;
			index += textCerca.length();
		}
		return coincidencies;
	}
	
	/**
     * Obté l'extensió d'un nom d'arxiu.
     *
     * @param nomArxiu El nom d'arxiu del qual es vol obtindre l'extensió.
     * @return L'extensió de l'arxiu o una cadena buida si no té extensió.
     */
	private String obtenirExtensio(String nomArxiu) {
		int lastIndex = nomArxiu.lastIndexOf(".");
		if (lastIndex == -1) {
			return "";
		}
		return nomArxiu.substring(lastIndex + 1);
	}
}
