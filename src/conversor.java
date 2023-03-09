import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;


public class conversor extends JFrame {
    private JComboBox selecConversion;
    private JTextField caja1;
    private JButton convertir1;
    private JButton limpiarButton;
    private JLabel resultados;
    private JLabel queDeseaConvertirLabel;
    private JComboBox convDe;
    private JComboBox convA;
    private JPanel Cpanel;
    //private Container panel1;
    double resultado;
//Conversion de temperatura
    private double celsiusToFahrenheit(double celsius) {
        return celsius * 1.8 + 32  ;
    }

    private double celsiusToKelvin(double celsius) {
        return celsius + 273.15;
    }

    private double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) / 1.8;
    }

    private double fahrenheitToKelvin(double fahrenheit) {
        return (fahrenheit + 459.67) / 1.8;
    }

    private double kelvinToCelsius(double kelvin) {
        return kelvin - 273.15;
    }

    private double kelvinToFahrenheit(double kelvin) {
        return kelvin * 1.8 - 459.67;
    }
//Conversion de la moneda
    private double dolarToEuro(double dolar) {
        return dolar / 1.21;
    }
    private double dolarToBoliviano(double dolar) {
        return dolar * 6.97;
    }
    private double euroToDolar(double euro) {
        return euro * 1.21;
    }
    private double euroToBoliviano(double euro) {
        return euro * 7.47;
    }
    private double bolivianoToDolar(double boliviano) {
        return boliviano / 6.97;
    }
    private double bolivianoToEuro(double boliviano) {
        return boliviano / 7.47;
    }

public conversor() {

    selecConversion.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String seleccion = (String)selecConversion.getSelectedItem();
            convDe.removeAllItems();
            convA.removeAllItems();
            switch(seleccion) {
                case "Temperatura":
                    convDe.addItem("Celsius");
                    convDe.addItem("Fahrenheit");
                    convDe.addItem("Kelvin");
                    convA.addItem("Celsius");
                    convA.addItem("Fahrenheit");
                    convA.addItem("Kelvin");
                    break;
                case "Moneda":
                    convDe.addItem("USA");
                    convDe.addItem("EUR");
                    convDe.addItem("BOL");
                    convA.addItem("USA");
                    convA.addItem("EUR");
                    convA.addItem("BOL");
                    break;
                default:
                    break;
            }
        }
    });

    convertir1.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            double entrada = Double.parseDouble(caja1.getText());
            double salida = 0;
//Operaciones para la conversion de temperatura
            if (convDe.getSelectedItem().equals("Celsius") && convA.getSelectedItem().equals("Fahrenheit")) {
                salida = Math.round(celsiusToFahrenheit(entrada) * 100.0) / 100.0;
                resultados.setText("El resultado es: " + salida + "°F");
            } else if (convDe.getSelectedItem().equals("Celsius") && convA.getSelectedItem().equals("Kelvin")) {
                salida = Math.round(celsiusToKelvin(entrada) * 100.0) / 100.0;
                resultados.setText("El resultado es: " + salida + "K");
            } else if (convDe.getSelectedItem().equals("Fahrenheit") && convA.getSelectedItem().equals("Celsius")) {
                salida = Math.round(fahrenheitToCelsius(entrada) * 100.0) / 100.0;
                resultados.setText("El resultado es: " + salida + "°C");
            } else if (convDe.getSelectedItem().equals("Fahrenheit") && convA.getSelectedItem().equals("Kelvin")) {
                salida = Math.round(fahrenheitToKelvin(entrada) * 100.0) / 100.0;
                resultados.setText("El resultado es: " + salida + "K");
            } else if (convDe.getSelectedItem().equals("Kelvin") && convA.getSelectedItem().equals("Celsius")) {
                salida = Math.round(kelvinToCelsius(entrada) * 100.0) / 100.0;
                resultados.setText("El resultado es: " + salida + "°C");
            } else if (convDe.getSelectedItem().equals("Kelvin") && convA.getSelectedItem().equals("Fahrenheit")) {
                salida = Math.round(kelvinToFahrenheit(entrada) * 100.0) / 100.0;
                resultados.setText("El resultado es: " + salida + "°F");
            } else if (convDe.getSelectedItem().equals("Celsius") && convA.getSelectedItem().equals("Celsius")) {
                salida = entrada;
                resultados.setText("El resultado es: " + salida + "°C");
            } else if (convDe.getSelectedItem().equals("Fahrenheit") && convA.getSelectedItem().equals("Fahrenheit")) {
                salida = entrada;
                resultados.setText("El resultado es: " + salida + "°F");
            } else if (convDe.getSelectedItem().equals("Kelvin") && convA.getSelectedItem().equals("Kelvin")) {
                salida = entrada;
                resultados.setText("El resultado es: " + salida + "K");
//Operarionces para la conversion de monedas
            } else if (convDe.getSelectedItem().equals("USA") && convA.getSelectedItem().equals("EUR")) {
                salida = Math.round(dolarToEuro(entrada) * 100.0) / 100.0;
                resultados.setText("El resultado es: " + salida + "€");
            } else if (convDe.getSelectedItem().equals("USA") && convA.getSelectedItem().equals("BOL")) {
                salida = Math.round(dolarToBoliviano(entrada) * 100.0) / 100.0;
                resultados.setText("El resultado es: " + salida + "Bs");
            } else if (convDe.getSelectedItem().equals("EUR") && convA.getSelectedItem().equals("USA")) {
                salida = Math.round(euroToDolar(entrada) * 100.0) / 100.0;
                resultados.setText("El resultado es: " + salida + "$");
            } else if (convDe.getSelectedItem().equals("EUR") && convA.getSelectedItem().equals("BOL")) {
                salida = Math.round(euroToBoliviano(entrada) * 100.0) / 100.0;
                resultados.setText("El resultado es: " + salida + "Bs");
            } else if (convDe.getSelectedItem().equals("BOL") && convA.getSelectedItem().equals("USA")) {
                salida = Math.round(bolivianoToDolar(entrada) * 100.0) / 100.0;
                resultados.setText("El resultado es: " + salida + "$");
            } else if (convDe.getSelectedItem().equals("BOL") && convA.getSelectedItem().equals("EUR")) {
                salida = Math.round(bolivianoToEuro(entrada) * 100.0) / 100.0;
                resultados.setText("El resultado es: " + salida + "€");
            } else if (convDe.getSelectedItem().equals("USA") && convA.getSelectedItem().equals("USA")) {
                salida = entrada;
                resultados.setText("El resultado es: " + salida + "$");
            } else if (convDe.getSelectedItem().equals("EUR") && convA.getSelectedItem().equals("EUR")) {
                salida = entrada;
                resultados.setText("El resultado es: " + salida + "€");
            } else if (convDe.getSelectedItem().equals("BOL") && convA.getSelectedItem().equals("BOL")) {
                salida = entrada;
                resultados.setText("El resultado es: " + salida + "Bs");

            }
            //resultados.setText("Resultado: " + salida);
        }
    });

    limpiarButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            convDe.removeAllItems();
            convA.removeAllItems();
            caja1.setText(" ");
            resultados.setText(" ");
            selecConversion.setSelectedIndex(0);
        }
    });
}
    public static void main(String[] args) {
        JFrame frame = new JFrame("Conversor de Temperatura y Moneda");
        frame.setContentPane(new conversor().Cpanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setSize(690, 180);
    }
}