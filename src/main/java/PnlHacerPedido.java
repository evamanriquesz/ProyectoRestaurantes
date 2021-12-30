package main.java;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**Clase del panel que se genera cuando se desea hacer el pedido de comida por adelantado al realizar la reserva*/

public class PnlHacerPedido extends JPanel implements ActionListener
{
    JButton btnAceptar, btnCancelar;
    JComboBox pnlPrincipal, pnlSecundario, pnlPostre, pnlBebida;
    JCheckBox pago;

    /**Constructor del panel que muestra las opciones de los platos a pedir*/
    public PnlHacerPedido()
    {

        this.setLayout(null);
        //this.setBounds(0, 0, getMaximumSize().width, 1000);
        this.setBackground(new Color(221, 234, 245, 202));

        JLabel lblprimero, lblsegundo, lblpostre, lblbebida,lblpago;

        lblprimero = new JLabel("Seleccionar primer plato: ");
        lblprimero.setFont(new Font("Lirio", Font.BOLD, 19));
        lblprimero.setForeground(Color.BLACK);
        lblprimero.setHorizontalTextPosition( SwingConstants.CENTER );
        lblprimero.setVerticalTextPosition( SwingConstants.BOTTOM );
        lblprimero.setBackground(new Color(133, 177, 204, 182));
        lblprimero.setBounds(60,150,300,50);
        this.add(lblprimero);


        pnlPrincipal=new JComboBox(PrimerPlato.values());
        pnlPrincipal.setBackground(new Color(133, 177, 204, 182));
        pnlPrincipal.setFont(new Font("Lirio", Font.ITALIC, 15));
        pnlPrincipal.setForeground(Color.BLACK);
        pnlPrincipal.setBackground(new Color(133, 177, 204, 182));
        pnlPrincipal.setBounds(400,150,150,50);
        this.add(pnlPrincipal);

        lblsegundo = new JLabel("Seleccionar segundo plato: ");
        lblsegundo.setFont(new Font("Lirio", Font.BOLD, 19));
        lblsegundo.setForeground(Color.BLACK);
        lblsegundo.setHorizontalTextPosition( SwingConstants.CENTER );
        lblsegundo.setVerticalTextPosition( SwingConstants.BOTTOM );
        lblsegundo.setBackground(new Color(133, 177, 204, 182));
        lblsegundo.setBounds(60,250,300,50);
        this.add(lblsegundo);


        pnlSecundario=new JComboBox(SegundoPlato.values());
        pnlSecundario.setBackground(new Color(133, 177, 204, 182));
        pnlSecundario.setFont(new Font("Lirio", Font.ITALIC, 15));
        pnlSecundario.setForeground(Color.BLACK);
        pnlSecundario.setBackground(new Color(133, 177, 204, 182));
        pnlSecundario.setBounds(400,250,150,50);
        this.add(pnlSecundario);

        lblpostre = new JLabel("Seleccionar Postre: ");
        lblpostre.setFont(new Font("Lirio", Font.BOLD, 19));
        lblpostre.setForeground(Color.BLACK);
        lblpostre.setHorizontalTextPosition( SwingConstants.CENTER );
        lblpostre.setVerticalTextPosition( SwingConstants.BOTTOM );
        lblpostre.setBackground(new Color(133, 177, 204, 182));
        lblpostre.setBounds(60,350,300,50);
        this.add(lblpostre);


        pnlPostre=new JComboBox(Postre.values());
        pnlPostre.setBackground(new Color(133, 177, 204, 182));
        pnlPostre.setFont(new Font("Lirio", Font.ITALIC, 15));
        pnlPostre.setForeground(Color.BLACK);
        pnlPostre.setBackground(new Color(133, 177, 204, 182));
        pnlPostre.setBounds(400,350,150,50);
        this.add(pnlPostre);

        lblbebida = new JLabel("Seleccionar bebida: ");
        lblbebida.setFont(new Font("Lirio", Font.BOLD, 19));
        lblbebida.setForeground(Color.BLACK);
        lblbebida.setHorizontalTextPosition( SwingConstants.CENTER );
        lblbebida.setVerticalTextPosition( SwingConstants.BOTTOM );
        lblbebida.setBackground(new Color(133, 177, 204, 182));
        lblbebida.setBounds(60,450,300,50);
        this.add(lblbebida);


        pnlBebida=new JComboBox(Bebida.values());
        pnlBebida.setBackground(new Color(133, 177, 204, 182));
        pnlBebida.setFont(new Font("Lirio", Font.ITALIC, 15));
        pnlBebida.setForeground(Color.BLACK);
        pnlBebida.setBackground(new Color(133, 177, 204, 182));
        pnlBebida.setBounds(400,450,150,50);
        this.add(pnlBebida);

        pago=new JCheckBox("Hacer pago por adelantado.");
        pago.setFont(new Font("Lirio", Font.BOLD, 18));
        pago.setForeground(Color.BLACK);
        pago.setBackground(new Color(221, 234, 245, 202));
        pago.setBounds(60,550,400,30);
        this.add(pago);

        btnAceptar = new JButton("Aceptar");
        btnAceptar.setFont(new Font("Lirio", Font.BOLD, 25));
        btnAceptar.setForeground(Color.BLACK);
        btnAceptar.setBackground(new Color(133, 177, 204, 182));
        btnAceptar.setBounds(150, 600, 150, 50);
        btnAceptar.addActionListener(this);
        this.add(btnAceptar);


        btnCancelar = new JButton("Cancelar");
        btnCancelar.setFont(new Font("Lirio", Font.BOLD, 25));
        btnCancelar.setForeground(Color.BLACK);
        btnCancelar.setBackground(new Color(133, 177, 204, 182));
        btnCancelar.setBounds(350, 600, 150, 50);
        btnCancelar.addActionListener(this);
        this.add(btnCancelar);

    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource()==btnAceptar)
        {
            PrimerPlato pp = PrimerPlato.valueOf(pnlPrincipal.getSelectedItem().toString());
            SegundoPlato sp = SegundoPlato.valueOf(pnlSecundario.getSelectedItem().toString());
            Postre pos =Postre.valueOf(pnlPostre.getSelectedItem().toString());
            Bebida b = Bebida.valueOf(pnlBebida.getSelectedItem().toString());
            Pagado pag;
            if (pago.isSelected())
            {
                pag=Pagado.pagado;
            }else{
                pag=Pagado.noPagado;
            }

            Pedido p= new Pedido(pp,sp,pos,b,pag);

            JPanelRellenarReserva.reservaFinal.setPedido(p);
        }

        if(e.getSource()==btnCancelar)
        {
            JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
            topFrame.dispose();
        }

    }
}
