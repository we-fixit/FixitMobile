/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entities.Services;
import com.codename1.components.ImageViewer;
import com.codename1.ui.Button;
import static com.codename1.ui.Component.CENTER;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.URLImage;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.util.Resources;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import service.Gestionservice;

/**
 *
 * @author Safsaf
 */
public class Serviceprestataire extends Form{
    private ImageViewer imge;
    private Image im;

    public Serviceprestataire(Resources theme) {
        setTitle("Liste d'offres");
        getToolbar().addCommandToLeftBar("Back", theme.getImage("back-command.png"), e -> {
            ServiceHome s = new ServiceHome(theme);
            s.show();
        });

        Gestionservice ser = new Gestionservice();
        ArrayList<Services> annonces = ser.getMyservice(Addservice.current_user);

        //Container container = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        Container c = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        
        for (Services annonce : annonces) {
            
            Container c1 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
            Container c2 = new Container(new BoxLayout(BoxLayout.X_AXIS));
            Container c3 = new Container(new FlowLayout(CENTER));
            
            
            Button mod = new Button("Modifier");
            Button supp = new Button("Supprimer");
            imge = new ImageViewer();
       //     EncodedImage placeholder = EncodedImage.createFromImage(Image.createImage(getWidth(), getHeight() / 5, 0xffff0000), true);
       //     URLImage background = URLImage.createToStorage(placeholder, "http://localhost/FIX1/web/uploads/images/" + annonce.getImage(),
       //             "http://localhost/FIX1/web/uploads/images/" + annonce.getImage(), URLImage.RESIZE_SCALE_TO_FILL);
       //     background.fetch();
            
         EncodedImage palceHolder = EncodedImage.createFromImage(theme.getImage("logo.png"), false);
            URLImage urlImage = URLImage.createToStorage(palceHolder, annonce.getImage(), "http://localhost/FIX1/web/uploads/images/" + annonce.getImage());   
            imge.setImage(urlImage);
            
            //"http://localhost/FIX1/web/uploads/images/"+annonce.getImage()

            c2.add(imge);
            c1.add(new Label("Titre: \n"));
            c1.add(annonce.getTitre());
                    c1.add(new Label("Description: \n" ));
                    c1.add(annonce.getDescription());
                     DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String strDate = dateFormat.format(annonce.getDate());
                 c1.add(new Label("Date debut: \n"+strDate))
                    ;
            c1.setScrollableX(true);
                      c3.add(mod).add(supp);
            c2.add(c1);
c.add(c2);
c.add(c3);
c.add("_________________________________________________________");
c.setScrollableY(true);
c.setScrollableX(true);

            //   container.add(new Label(("Telephone: ")+annonce.getTelephone())).
            //   add(new Label("Description: \n" +annonce.getDescription())).add(new Label("Date debut: \n"+annonce.getDate()))
            //           .add(mod).add(supp);
            //   c1.add(c);
            //   c1.add(container);
            //   add(c1);
            mod.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {

                    System.out.println(annonce);
                    if (Dialog.show("Modifier", "Are you sure you want to update this service", "OK", "Cancel")) {
                        Updateservice x = new Updateservice(theme, annonce);
                        x.show();
                    }
                }
            });
            supp.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    Gestionservice r = new Gestionservice();
                    if (Dialog.show("Supprimer", "Are you sure you want to delete this service", "OK", "Cancel")) {
                        r.deleteAnnonce(annonce.getId());
                        GUIService p = new GUIService(theme);
                        p.show();
                    }
                }
            });
            //   container.setScrollableY(true);
            //   container.setScrollableX(true);
//            c.add("_________________________________________________________________________");
//            c.add(container);
//            add(c);
//          
        }
        add(c);

        show();
    }

    
}
