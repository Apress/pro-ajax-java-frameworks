/*
 * TacosTree.java
 *
 * Created on May 7, 2006, 2:11 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.proajax.chapt6;

import java.io.File;
import java.util.Set;
import java.util.Stack;
import net.sf.tacos.ajax.AjaxWebRequest;
import net.sf.tacos.model.IKeyProvider;
import net.sf.tacos.model.ITreeContentProvider;
import net.sf.tacos.tree.ITreeManager;
import net.sf.tacos.tree.TreeManager;
import org.apache.tapestry.IRequestCycle;
import org.apache.tapestry.html.BasePage;

/**
 *
 * @author nate
 */

public abstract class TacosTree extends BasePage {
        
    private final static String PROP_FSROOT =
            "net.sf.tacos.demo-filesystem-root";
    
    private final static ITreeContentProvider
            CONTENT_PROVIDER = new FileTreeContentProvider(getRootPath());
    
    /**
     * Gets the content provider
     * @return
     */
    public ITreeContentProvider getContentProvider() {
        return CONTENT_PROVIDER;
    }
    
    /**
     * Gets the key provider
     * @return
     */
    public IKeyProvider getKeyProvider() {
        return FileKeyProvider.INSTANCE;
    }
    
    /**
     * Selects a file
     * @param cycle
     */
    public void select(IRequestCycle cycle) {
        String path = (String)cycle.getListenerParameters()[0];
        if (!path.startsWith(getRootPath())) {
            throw new IllegalArgumentException(
                    "Path has to be relative to root " + getRootPath());
        }
        File f = new File(path);
        ensurePreviousRefresh(f);
        setSelectedFile(f);
    }
    
    /**
     * Makes sure that the previously selected file is
     * refreshed to ensure the selected css class is updated.
     *
     * @param newFile
     */
    private void ensurePreviousRefresh(File newFile) {
        if (getSelectedFile() != null
                && getAjaxWebRequest().isValidRequest()) {
            AjaxWebRequest ajax = getAjaxWebRequest();
            File selFile = getSelectedFile();
            
            File pfile = getIntersectingParent(newFile, selFile);
            
            if (pfile != null) {
                ajax.getUpdateComponents().remove(newFile.getPath());
                ajax.getUpdateComponents().remove(selFile.getPath());
                ajax.getUpdateComponents().add(pfile.getPath());
                return;
            } else {
                ajax.getUpdateComponents().add(selFile.getPath());
            }
        }
    }
    
    /**
     * If specified files are both contained by a parent file,
     * that isn't the file returned from {@link #getRootPath()}
     * this method returns that file.
     *
     * @param f1
     * @param f2
     * @return The nearest intersecting parent node, if any.
     */
    protected File getIntersectingParent(File f1, File f2) {
        // For cases where it's the same file
        if (f1.getPath().equals(f2.getPath())) {
            if (f1.getParentFile() != null
                    && !f1.getParentFile().getPath().equals(getRootPath())) return f1
                            .getParentFile();
            else return f1;
        }
        
        Stack s1 = new Stack();
        Stack s2 = new Stack();
        
        // Now build our list of parents
        File parent = f1.getParentFile();
        while(parent != null && !parent.getPath().equals(getRootPath())) {
            // For cases where newFile is a child of selFile and
            // not a sibling node or sibling node's child
            if (parent.getPath().equals(f2.getPath())) return parent;
            s1.push(parent);
            parent = parent.getParentFile();
        }
        
        parent = f2.getParentFile();
        while(parent != null && !parent.getPath().equals(getRootPath())) {
            s2.push(parent);
            parent = parent.getParentFile();
        }
        
        // Iterate over first stack looking for a shared
        // parent
        if (s1.size() <= 0) return null;
        // File pfile = (File)s1.pop();
        while(!s1.isEmpty()) {
            File pfile = (File)s1.pop();
            
            if (s2.contains(pfile)) return pfile;
            
        }
        
        return null;
    }
    
    /**
     * Makes all nodes visible
     * @param cycle
     */
    public void expandAll(IRequestCycle cycle) {
        getTreeManager().expandAll();
    }
    
    /**
     * Collapses all nodes
     * @param cycle
     */
    public void collapseAll(IRequestCycle cycle) {
        getTreeManager().collapseAll();
    }
    
    /**
     * Reveals a particular node
     * @param cycle
     */
    public void revealSelected(IRequestCycle cycle) {
        getTreeManager().reveal(getSelectedFile());
    }
    
    /**
     * The ree manager
     * @return
     */
    public ITreeManager getTreeManager()
    {
        return new TreeManager(getFileState(), getContentProvider(),
                getKeyProvider());
    }

    /** get file */
    public abstract File getSelectedFile();
    /** sets file */
    public abstract void setSelectedFile(File file);
    /** the tree state */
    public abstract Set getFileState();
    /** The global root file path */
    private static String getRootPath()
    {
        String fsRoot = System.getProperty(PROP_FSROOT);
        if (fsRoot == null) {
            fsRoot = System.getProperty("user.dir");
        }
        return fsRoot;
    }

    /** Injected ajax request */
    public abstract AjaxWebRequest getAjaxWebRequest();
}
