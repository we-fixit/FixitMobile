package GUI;

import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.Dialog;
import com.codename1.ui.util.Resources;


public class GuiComponent extends Form  {
    public GuiComponent(com.codename1.ui.util.Resources resourceObjectInstance) {
        initGuiBuilderComponents(resourceObjectInstance);
    }

//-- DON'T EDIT BELOW THIS LINE!!!
    protected com.codename1.ui.Button gui_ok = new com.codename1.ui.Button();


// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        setLayout(new com.codename1.ui.layouts.LayeredLayout());
        setInlineStylesTheme(resourceObjectInstance);
        setScrollableY(true);
        setUIID("btn");
                setInlineStylesTheme(resourceObjectInstance);
        setInlineAllStyles("font:native:MainBold native:MainBold; bgColor:feae23; alignment:center;");
        setTitle("GuiComponent");
        setName("GuiComponent");
        addComponent(gui_ok);
        gui_ok.setPreferredSizeStr("90.21164mm inherit");
        gui_ok.setText("ok");
                gui_ok.setInlineStylesTheme(resourceObjectInstance);
        gui_ok.setInlineAllStyles("font:12.0mm native:MainBold native:MainBold; opacity:255; bgType:gradient_radial; bgImage:Check-Box_Press.png; alignment:center;");
        gui_ok.setName("ok");
        ((com.codename1.ui.layouts.LayeredLayout)gui_ok.getParent().getLayout()).setInsets(gui_ok, "auto 31.010796% 14.646767% auto").setReferenceComponents(gui_ok, "-1 -1 -1 -1").setReferencePositions(gui_ok, "0.0 0.0 0.0 0.0");
    }// </editor-fold>
//-- DON'T EDIT ABOVE THIS LINE!!!
}
