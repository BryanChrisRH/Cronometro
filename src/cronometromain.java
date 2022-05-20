import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class cronometromain{

    JFrame ventana;
    JLabel lblTime;
    JButton BInicio,BStop,BSPause,BSReanudar;
    Thread h1;
    maintestrunner h;

    public cronometromain(){

        ventana=new JFrame("CRONOMETRO");
        lblTime=new JLabel("0");
        BInicio=new JButton("iniciar");
        BStop=new JButton("parar");
        BSPause=new JButton("Pausar");
        BSReanudar=new JButton("Reanudar");

        lblTime.setFont(new Font("Agency FB", Font.BOLD, 50));
        ventana.add(lblTime, BorderLayout.CENTER);
        JPanel panelBotones=new JPanel(new FlowLayout());
        panelBotones.add(BInicio);
        panelBotones.add(BStop);
        panelBotones.add(BSPause);
        panelBotones.add(BSReanudar);
        BStop.setEnabled(false);
        BSPause.setEnabled(false);
        BSReanudar.setEnabled(false);

        ventana.add(panelBotones,BorderLayout.SOUTH);

        BInicio.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                h=new maintestrunner(lblTime);
                h1=new Thread(h);
                h1.start();
                BInicio.setEnabled(false);
                BStop.setEnabled(true);
                BSPause.setEnabled(true);

            }

        });

        BStop.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                h.parar();
                BStop.setEnabled(false);
                BSReanudar.setEnabled(false);
                BSPause.setEnabled(false);
                BInicio.setEnabled(true);
            }
        });

        BSPause.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                h.pausarhilo();
                BSPause.setEnabled(false);
                BStop.setEnabled(true);
                BInicio.setEnabled(true);
                BSReanudar.setEnabled(true);
            }

        });

        BSReanudar.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                h.renaudarhilo();
                BInicio.setEnabled(false);
                BSReanudar.setEnabled(false);
            }

        });

        ventana.setSize(400,400);
        ventana.setVisible(true);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }


    public static void main(String[] args) {

        new cronometromain();
    }
}
