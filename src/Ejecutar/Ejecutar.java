/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejecutar;

import Inicio.ControladorLogin;
import Inicio.Login;

/**
 *
 * @author rodri
 */
public class Ejecutar {
        public static void main(String[] args) {
        Login l = new Login();
        ControladorLogin c = new ControladorLogin(l);
        l.ConectaControlador(c);
    }
}
