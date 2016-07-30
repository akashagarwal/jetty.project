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

package org.eclipse.jetty.websocket.common.test;

import java.io.IOException;
import java.net.SocketException;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.eclipse.jetty.io.ByteBufferPool;
import org.eclipse.jetty.websocket.api.extensions.Frame;
import org.eclipse.jetty.websocket.common.Parser;

public interface IBlockheadServerConnection
{
    void close() throws IOException;

    void close(int statusCode) throws IOException;

    void write(Frame frame) throws IOException;

    List<String> upgrade() throws IOException;

    void disconnect();

    IncomingFramesCapture readFrames(int expectedCount, int timeoutDuration, TimeUnit timeoutUnit) throws IOException, TimeoutException;
    void write(ByteBuffer buf) throws IOException;
    List<String> readRequestLines() throws IOException;
    String parseWebSocketKey(List<String> requestLines);
    void respond(String rawstr) throws IOException;
    String readRequest() throws IOException;
    List<String> regexFind(List<String> lines, String pattern);
    void echoMessage(int expectedFrames, int timeoutDuration, TimeUnit timeoutUnit) throws IOException, TimeoutException;
    void setSoTimeout(int ms) throws SocketException;
    ByteBufferPool getBufferPool();
    int read(ByteBuffer buf) throws IOException;
    Parser getParser();
    IncomingFramesCapture getIncomingFrames();
    void flush() throws IOException;
    void write(int b) throws IOException;
    void startEcho();
    void stopEcho();
    
    /**
     * Add an extra header for the upgrade response (from the server). No extra work is done to ensure the key and value are sane for http.
     * @param rawkey the raw key
     * @param rawvalue the raw value
     */
    void addResponseHeader(String rawkey, String rawvalue);
}