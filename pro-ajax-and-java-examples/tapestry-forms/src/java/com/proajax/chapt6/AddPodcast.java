/*
 * AddPodcast.java
 *
 * Created on March 4, 2006, 12:16 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.proajax.chapt6;

import java.util.Date;
import org.apache.tapestry.IPage;
import org.apache.tapestry.annotations.InjectPage;
import org.apache.tapestry.event.PageBeginRenderListener;
import org.apache.tapestry.event.PageEvent;
import org.apache.tapestry.html.BasePage;

/**
 *
 * @author nate
 */
public abstract class AddPodcast extends BasePage
        implements PageBeginRenderListener {
    
    public abstract Podcast getPodcast();
    public abstract void setPodcast(Podcast podcast);
    
    @InjectPage("ShowPodcast")
    public abstract ShowPodcast getShowPodcast();
    
    public void pageBeginRender(PageEvent event) {
        Podcast podcast = new Podcast();
        podcast.setReleaseDate(new Date());
        
        setPodcast(podcast);
    }
    
    
    public IPage addPodcast() {
        ShowPodcast showPodcast = getShowPodcast();
        
        showPodcast.setPodcast(getPodcast());
        
        return showPodcast;
    }
}
