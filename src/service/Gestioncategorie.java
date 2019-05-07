/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import Entities.Categories;
import Entities.Services;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Safsaf
 */
public class Gestioncategorie {
   public Gestioncategorie(){
       
   } 
    public ArrayList<Categories> getAllservice()
    {
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/FIX1/web/app_dev.php/service/affichetout");
        con.setPost(false);
        
        ArrayList<Categories> annonces = new ArrayList<>();
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                String json = new String(con.getResponseData());
                JSONParser j = new JSONParser();
                
                try {
                    
                    Map<String, Object> an = j.parseJSON(new CharArrayReader(json.toCharArray()));
                    
                    List<Map<String, Object>> list = (List<Map<String, Object>>) an.get("root");
                    // Map<String,Object> dateDes=(Map<String,Object>)(an.get("date"));
//                      int temp=(int)Float.parseFloat(dateDes.get("timestamp").toString());
//                Date mydate=new Date(temp*1000L);
//                System.out.println(mydate);
                    for(Map<String, Object> ann : list )
                    {
                        Categories a = new  Categories();
                        // System.out.println(ann);
                        a.setId((int) Float.parseFloat(ann.get("id").toString()));
                        a.setLibelle(ann.get("libelle").toString());
             
                        annonces.add(a);
                        System.out.println(a);
                    }
                    
                } catch (IOException ex) {ex.printStackTrace();}
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        
        return annonces;
    }
}
