/*
 * FileTreeContentProvider.java
 *
 * Created on May 7, 2006, 2:28 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.proajax.chapt6;

import java.io.File;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import net.sf.tacos.model.ITreeContentProvider;

/**
 * @author phraktle
 */
public class FileTreeContentProvider implements ITreeContentProvider {

    private final String rootPath;

    /**
     * Creates a new tree
     * @param rootPath
     */
    public FileTreeContentProvider(String rootPath)
    {
        this.rootPath = rootPath;
    }

    /**
     *
     * {@inheritDoc}
     */
    public List getElements()
    {
        return Arrays.asList(new File(rootPath).listFiles());
    }

    /**
     *
     * {@inheritDoc}
     */
    public Collection getChildren(Object parentElement)
    {
        File f = (File)parentElement;
        if (f.isDirectory()) { return Arrays.asList(f.listFiles()); }
        return Collections.EMPTY_LIST;
    }

    /**
     *
     * {@inheritDoc}
     */
    public Object getParent(Object childElement)
    {
        return ((File)childElement).getParentFile();
    }

    /**
     *
     * {@inheritDoc}
     */
    public boolean hasChildren(Object parentElement)
    {
        File f = (File)parentElement;
        return f.isDirectory();
    }

}