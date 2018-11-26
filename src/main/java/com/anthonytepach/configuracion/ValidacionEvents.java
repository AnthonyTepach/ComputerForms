/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anthonytepach.configuracion;

import java.awt.event.KeyEvent;
import javax.swing.JFrame;

public class ValidacionEvents extends JFrame {

    public void esDigito(KeyEvent evt) {
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
            getToolkit().beep();
            evt.consume();
        }
    }

    public void esLetra(KeyEvent evt) {
        char c = evt.getKeyChar();
        if (!(Character.isLetter(c) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE) || (c == KeyEvent.VK_SPACE))) {
            getToolkit().beep();
            evt.consume();
        }
    }

}
