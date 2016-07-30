//  ========================================================================
//  Copyright (c) 1995-2016 Mort Bay Consulting Pty. Ltd.
//  ------------------------------------------------------------------------
//  All rights reserved. This program and the accompanying materials
//  are made available under the terms of the Eclipse Public License v1.0
//  and Apache License v2.0 which accompanies this distribution.
//      The Eclipse Public License is available at
//      http://www.eclipse.org/legal/epl-v10.html
//      The Apache License v2.0 is available at
//      http://www.opensource.org/licenses/apache2.0.php
//  You may elect to redistribute this code under either of these licenses.
//  ========================================================================

package org.eclipse.jetty.http;

/**
 * HTTP constants.
 */
public interface HttpTokens
{
    /** Terminal symbols. */
    byte COLON= (byte)':';
    byte TAB= 0x09;
    byte LINE_FEED= 0x0A;
    byte CARRIAGE_RETURN= 0x0D;
    byte SPACE= 0x20;
    byte[] CRLF = {CARRIAGE_RETURN,LINE_FEED};
    byte SEMI_COLON= (byte)';';

    public enum EndOfContent { UNKNOWN_CONTENT,NO_CONTENT,EOF_CONTENT,CONTENT_LENGTH,CHUNKED_CONTENT }

}

