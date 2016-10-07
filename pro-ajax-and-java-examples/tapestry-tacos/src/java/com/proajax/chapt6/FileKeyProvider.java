/*
 * FileKeyProvider.java
 *
 * Created on May 7, 2006, 2:30 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.proajax.chapt6;

import java.io.File;
import java.io.Serializable;

import net.sf.tacos.model.IKeyProvider;

/**
 * @author phraktle
 */
public class FileKeyProvider implements IKeyProvider {

    public final static FileKeyProvider INSTANCE = new FileKeyProvider();

    /**
     * 
     * {@inheritDoc}
     */
    public Serializable getKey(Object value)
    {
        return ((File)value).getAbsolutePath();
    }

}