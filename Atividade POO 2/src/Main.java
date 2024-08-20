package br.pucpr.poo.Estacionamento;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    private JPanel pnlMain;
    private JPanel pnlHour;
    private JTextField txtIniHour;
    private JTextField txtIniMin;
    private JTextField txtEndHour;
    private JTextField txtEndMin;
    private JButton btnCalc;
    private JLabel lblCalc;

    public Main() {
        btnCalc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                HourMinute iniHour= new HourMinute();
                HourMinute endHour= new HourMinute();

                iniHour.hour=Integer.parseInt(txtIniHour.getText());
                iniHour.minute=Integer.parseInt(txtIniMin.getText());
                endHour.hour=Integer.parseInt(txtEndHour.getText());
                endHour.minute=Integer.parseInt(txtEndMin.getText());

                HourMinute dif = iniHour.calcHourMinuteDif(endHour);
                JOptionPane.showMessageDialog(null, "Diferença: " +dif.toString());

                float pricehour;
                if (dif.hour == 0){
                    pricehour=(float) 0.0;
                    lblCalc.setText("Custo: R$ " +pricehour * dif.hour);
                }
                else if (dif.hour!=0 && dif.hour<3){
                    pricehour=(float) 10.0;
                    lblCalc.setText("Custo: R$ " +pricehour * dif.hour);
                }
                else if (dif.hour>2 && dif.hour<5) {
                    pricehour = (float) 7.50;
                    lblCalc.setText("Custo: R$ " + pricehour * dif.hour);
                }
                else if (dif.hour>4) {
                    pricehour = (float) 5.0;
                    lblCalc.setText("Custo: R$ " + pricehour * dif.hour);
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Main");
        frame.setContentPane(new Main().pnlMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
