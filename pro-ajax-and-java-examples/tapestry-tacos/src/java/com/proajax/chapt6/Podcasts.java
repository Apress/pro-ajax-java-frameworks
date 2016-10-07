/*
 * Podcasts.java
 *
 * Created on March 4, 2006, 12:16 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.proajax.chapt6;

import java.util.Date;
import org.apache.tapestry.IRequestCycle;
import org.apache.tapestry.event.PageBeginRenderListener;
import org.apache.tapestry.event.PageEvent;
import org.apache.tapestry.html.BasePage;

/**
 *
 * @author nate
 */
public abstract class Podcasts extends BasePage
        implements PageBeginRenderListener {
    
    public abstract Podcast getPodcast();
    public abstract void setPodcast(Podcast podcast);
    
    public void pageBeginRender(PageEvent event) {
        Podcast podcast = new Podcast();
        podcast.setReleaseDate(new Date());

        setPodcast(podcast);
    }
    
    public void addPodcast(IRequestCycle cycle) {
    }
}
