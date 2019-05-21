/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ENCRIPTACION;

/**
 *
 * @author Kevin
 */
public class PruebasEncriptacion {
    public static void main(String[] args) throws Exception {				
        HashSalt hs = PasswordUtil.getHash("miPassword");
	System.out.println(hs.getHash()); // bWlQYXNzd29yZA==
	System.out.println(hs.getSalt()); // SMB6x5uRy4kIPYN512ibug==
	
	boolean isValid = PasswordUtil.ValidatePass("miPassword", hs.getHash(), hs.getSalt());
	System.out.println(isValid ? "válida" : "no válida"); // no válida
    }
}
