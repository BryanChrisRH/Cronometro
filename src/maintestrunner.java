import javax.swing.JLabel;

public class maintestrunner implements Runnable{

    Integer mil;
    Integer segundos;
    Integer minutos;
    Integer hora;
    JLabel refLbl;
    boolean para=false;
    boolean pausa=false;

    public maintestrunner(JLabel lbl){

        refLbl=lbl;
        mil=0;
        segundos=0;
        minutos=0;
        hora=0;
    }

    @Override
    public void run() {
        while (!para){
            try {
                mil++;
                if(mil==100){
                    mil=0;
                    segundos++;
                }
                else if(segundos==60){
                    segundos=0;
                    minutos++;
                }
                else if(minutos==60){
                    minutos=0;
                    hora++;
                }

                synchronized (this){
                    while (pausa){
                        wait();
                    }
                }
                refLbl.setText(hora.toString()+" : "+minutos.toString()+" : "
                        +segundos.toString()+": "+mil.toString());
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void parar(){
        para=true;
    }

    synchronized void pausarhilo(){
        pausa=true;
    }

    synchronized void renaudarhilo(){
        pausa=false;
        notify();
    }
}
