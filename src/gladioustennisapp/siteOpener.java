/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gladioustennisapp;

import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author salga
 */
public class siteOpener {
    public void OpenWebsite (String sitelink)
    {
        try
        {
           Process P;
           P= Runtime.getRuntime().exec("cmd /c start " + sitelink);
        }
        catch (IOException e)
        {
            JOptionPane.showMessageDialog (null, "Error: "+ e);
        }
    }
}
