/*
 *Purpose : Class is implemented for handling file not found exception and its extends to Exception class
 *
 * @author Dinesh Kumar Peddakotla
 * @version 1.0
 * @since 06-07-2021
 */
package com.datadrivenframework.utility;

public class FileNotFoundException extends Exception {

    public FileNotFoundException(String message) {
        super(message);
    }
}
