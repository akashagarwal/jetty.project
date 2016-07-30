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
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.util.concurrent.TimeUnit;

import org.eclipse.jetty.toolchain.test.EventQueue;
import org.eclipse.jetty.websocket.common.WebSocketFrame;

/**
 * Interface for BlockheadClient.
 */
public interface IBlockheadClient extends AutoCloseable
{
    void addExtensions(String xtension);

    void addHeader(String header);

    boolean awaitDisconnect(long timeout, TimeUnit unit) throws InterruptedException;

    void close();

    void close(int statusCode, String message);

    void connect() throws IOException;

    void disconnect();

    void expectServerDisconnect();

    HttpResponse expectUpgradeResponse() throws IOException;

    InetSocketAddress getLocalSocketAddress();

    String getProtocols();

    InetSocketAddress getRemoteSocketAddress();

    EventQueue<WebSocketFrame> readFrames(int expectedFrameCount, int timeoutDuration, TimeUnit timeoutUnit) throws Exception;

    HttpResponse readResponseHeader() throws IOException;

    void sendStandardRequest() throws IOException;

    void setConnectionValue(String connectionValue);

    void setProtocols(String protocols);

    void setTimeout(int duration, TimeUnit unit);

    void write(WebSocketFrame frame) throws IOException;

    void writeRaw(ByteBuffer buf) throws IOException;

    void writeRaw(ByteBuffer buf, int numBytes) throws IOException;

    void writeRaw(String str) throws IOException;

    void writeRawSlowly(ByteBuffer buf, int segmentSize) throws IOException;
}