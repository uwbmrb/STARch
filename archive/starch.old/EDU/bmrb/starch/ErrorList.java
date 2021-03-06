/*
 * ErrorList.java
 *
 * Created on December 20, 2002, 3:08 PM
 *
 * This software is copyright (c) 2002 Board of Regents, University of Wisconsin.
 * All Rights Reserved.
 *
 * FILE:        $Source: /cvs_archive/cvs/starch/EDU/bmrb/starch/ErrorList.java,v $
 * 
 * AUTHOR:      $Author: dmaziuk $
 * DATE:        $Date: 2003/12/12 23:24:09 $
 * 
 * UPDATE HISTORY:
 * ---------------
 * $Log: ErrorList.java,v $
 * Revision 1.3  2003/12/12 23:24:09  dmaziuk
 * Updated to Java 2 collections, added pool of unique string as backing storage
 *
 * Revision 1.2  2003/01/06 22:45:55  dmaziuk
 * Bugfix release
 *
 * Revision 1.1  2002/12/30 22:22:38  dmaziuk
 * major rewrite of data structure
 *
 *
 */

package EDU.bmrb.starch;

/**
 * List of error messages.
 * @author  dmaziuk
 * @version 1
 */
public class ErrorList {
    /** vector of messages */
    private java.util.List fErrs = null;
    /** verbose flag */
    private boolean fVerbose = false;
    /** message buffer */
    private StringBuffer fBuf = null;
//*******************************************************************************
    /** Creates new ErrorList */
    public ErrorList() {
        fErrs = new java.util.ArrayList();
        fBuf = new StringBuffer();
    } //*************************************************************************
    /** Creates new ErrorList.
     * @param verbose verbose flag
     */
    public ErrorList( boolean verbose ) {
        fErrs = new java.util.ArrayList();
        fVerbose = verbose;
        fBuf = new StringBuffer();
    } //*************************************************************************
    /** Sets verbose flag.
     * @param verbose boolean
     * @see #addWarning( String )
     */
    public void setVerbose( boolean verbose ) {
        fVerbose = verbose;
    } //*************************************************************************
    /** Returns verbose flag.
     * @return boolean verbose flag
     * @see #addWarning( String )
     */
    public boolean getVerbose() {
        return fVerbose;
    } //*************************************************************************
    /** Adds error message.
     * This method adds String to the list of conversion error/warning messages.
     * Unlike addWarning(), this method ignores verbose flag.
     * @param msg String message
     * @see #addWarning( String )
     * @see Converter#read( BufferedReader )
     */
    public void addError(String msg) {
        fBuf.setLength( 0 );
        fBuf.append( "ERR:" );
        fBuf.append( msg );
        fErrs.add( fBuf.toString() );
    } //*************************************************************************
    /** Adds warning message.
     * This method adds String to the list of conversion error/warning messages.
     * If verbose flag is false, message is not added.
     * @param msg String message
     */
    public void addWarning(String msg) {
        if( ! fVerbose ) return;
        fBuf.setLength( 0 );
        fBuf.append( "WARN:" );
        fBuf.append( msg );
        fErrs.add( fBuf.toString() );
    } //*************************************************************************
    /** Adds error message.
     * This method adds String to the list of conversion error/warning messages.
     * Unlike addWarning(), this method ignores verbose flag.
     * @param linenum line number
     * @param msg String message
     * @see #addWarning( String )
     */
    public void addError(int linenum, String msg) {
        fBuf.setLength( 0 );
        fBuf.append( "ERR:" );
        fBuf.append( linenum );
        fBuf.append( ":" );
        fBuf.append( msg );
        fErrs.add( fBuf.toString() );
    } //*************************************************************************
    /** Adds warning message.
     * This method adds String to the list of conversion error/warning messages.
     * If verbose flag is false, message is not added.
     * @param linenum line number
     * @param msg String message
     */
    public void addWarning(int linenum, String msg) {
        if( ! fVerbose ) return;
        fBuf.setLength( 0 );
        fBuf.append( "WARN:" );
        fBuf.append( linenum );
        fBuf.append( ":" );
        fBuf.append( msg );
        fErrs.add( fBuf.toString() );
    } //*************************************************************************
    /** Adds error message.
     * This method adds formatted error message to the list of conversion
     * error/warning messages. Unlike addWarning(), this method ignores verbose
     * flag.
     * @param seqcode sequence code
     * @param label residue label
     * @param msg String message
     * @see #addWarning( String )
     */
    public void addError(String seqcode, String label, String msg) {
        fBuf.setLength( 0 );
        fBuf.append( "ERR::" );
        fBuf.append( seqcode );
        fBuf.append( ":" );
        fBuf.append( label );
        fBuf.append( ":" );
        fBuf.append( msg );
        fErrs.add( fBuf.toString() );
    } //*************************************************************************
    /** Adds warning message.
     * This method adds formatted message to the list of conversion error/warning
     * messages. If verbose flag is false, message is not added.
     * @param seqcode sequence code
     * @param label residue label
     * @param msg String message
     */
    public void addWarning(String seqcode, String label, String msg) {
        if( ! fVerbose ) return;
        fBuf.setLength( 0 );
        fBuf.append( "WARN::" );
        fBuf.append( seqcode );
        fBuf.append( ":" );
        fBuf.append( label );
        fBuf.append( ":" );
        fBuf.append( msg );
        fErrs.add( fBuf.toString() );
    } //*************************************************************************
    /** Adds error message.
     * This method adds formatted error message to the list of conversion
     * error/warning messages. Unlike addWarning(), this method ignores verbose
     * flag.
     * @param linenum line number
     * @param seqcode sequence code
     * @param label residue label
     * @param msg String message
     * @see #addWarning( String )
     */
    public void addError(int linenum, String seqcode, String label, String msg) {
        fBuf.setLength( 0 );
        fBuf.append( "ERR:" );
        fBuf.append( linenum );
        fBuf.append( ":" );
        fBuf.append( seqcode );
        fBuf.append( ":" );
        fBuf.append( label );
        fBuf.append( ":" );
        fBuf.append( msg );
        fErrs.add( fBuf.toString() );
    } //*************************************************************************
    /** Adds warning message.
     * This method adds formatted message to the list of conversion error/warning
     * messages. If verbose flag is false, message is not added.
     * @param linenum line number
     * @param seqcode sequence code
     * @param label residue label
     * @param msg String message
     */
    public void addWarning(int linenum, String seqcode, String label, String msg) {
        if( ! fVerbose ) return;
        fBuf.setLength( 0 );
        fBuf.append( "WARN:" );
        fBuf.append( linenum );
        fBuf.append( ":" );
        fBuf.append( seqcode );
        fBuf.append( ":" );
        fBuf.append( label );
        fBuf.append( ":" );
        fBuf.append( msg );
        fErrs.add( fBuf.toString() );
    } //*************************************************************************
    /** Returns error count.
     * Returns number of messages in the list of conversion errors/warnings.
     * Application should check this number after Converter.read() has returned,
     * regardless of the return value: Converter.read() returns false on critical
     * errors only.
     * @return int message count
     */
    public int size() {
        return fErrs.size();
    } //*************************************************************************
    /** Returns error message at specified index.
     * Returns message from the list of conversion errors/warnings.
     * @param index int message index
     * @return String message or null
     */
    public String errorAt(int index) {
        if( (index < 0) || (index >= fErrs.size()) ) return null;
        return (String) fErrs.get( index );
    } //*************************************************************************
    /** Clears list of conversion errors/warnings. */
    public void clear() {
        fErrs.clear();
    } //*************************************************************************
    /** Prints out error messages.
     * @param out output stream
     */
    public void printErrors(java.io.PrintStream out) {
        if( out == null ) return;
        for( int i = 0; i < fErrs.size(); i++ ) 
            out.println( fErrs.get( i ) );
        out.flush();
    } //*************************************************************************
    /** Returns error messages as one (possibly huge) String.
     * Use printErrors() instead.
     * @return String error messages
     */
    public String toString() {
        fBuf.setLength( 0 );
        for( int i = 0; i < fErrs.size(); i++ )
            fBuf.append( (String) fErrs.get( i ) + "\n" );
        return fBuf.toString();
    } //*************************************************************************
}
