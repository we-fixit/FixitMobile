/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entities.Services;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextArea;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;
import service.Gestionservice;

/**
 *
 * @author Safsaf
 */
public class Updateservice extends Form{
    
    public Updateservice(Resources theme,Services s){
        setTitle("Modifier service");
        getToolbar().addCommandToLeftBar("Back", null , e->{
             Serviceprestataire x = new Serviceprestataire(theme);
             x.show();
          
        });
         Container container = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        
        Label Name = new Label("Titre:");
        TextArea nameTxt = new TextArea();
        
        nameTxt.setText(s.getTitre());
        container.add(Name);
        container.add(nameTxt);
        Label desc = new Label("Description:");
        TextArea descTxt = new TextArea();
        descTxt.setText(s.getDescription());
        container.add(desc);
        container.add(descTxt);
        Label tel = new Label("Telephone:");
        TextArea tel1 = new TextArea();
        
        tel1.setText(s.getTelephone());
        container.add(tel);
        container.add(tel1);
        Button sub = new Button("Submit");
        container.add(sub);
        sub.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
            
                Gestionservice p = new Gestionservice();
                p.updateAnnonce(s.getId(),nameTxt.getText() , descTxt.getText(), tel1.getText(), 3,11);
            
            if(Dialog.show("Success", "You have updated successfully your service", "OK", null))
                {
                    
                }
            
            }
        });
        add(container);
        
        
        
        
        
    }
    
    
    
    
    
}
