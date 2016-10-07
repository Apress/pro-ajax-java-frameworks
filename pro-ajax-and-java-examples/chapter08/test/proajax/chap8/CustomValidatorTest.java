/*
 * CustomValidatorTest.java
 *
 * Created on April 8, 2006, 10:40 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package proajax.chap8;

import junit.framework.TestCase;

/**
 *
 * @author nate
 */
public class CustomValidatorTest extends TestCase {
    private CustomValidator validator = new CustomValidator();
    
    /** Creates a new instance of CustomValidatorTest */
    public CustomValidatorTest() {
    }
    
    public void testIsInvalidNameWithX() {
        assertTrue(validator.isInvalidName("Fox"));
    }
    
    public void testIsInvalidNameValid() {
        assertFalse(validator.isInvalidName("Foo"));
    }

    public void testIsInvalidNameWithEmpty() {
        assertFalse(validator.isInvalidName(""));
    }
}
