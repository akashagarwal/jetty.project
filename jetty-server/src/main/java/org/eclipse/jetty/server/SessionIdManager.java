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

package org.eclipse.jetty.server;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.eclipse.jetty.util.component.LifeCycle;

/** Session ID Manager.
 * Manages session IDs across multiple contexts.
 */
public interface SessionIdManager extends LifeCycle
{
    /**
     * @param id The session ID without any cluster node extension
     * @return True if the session ID is in use by at least one context.
     */
    boolean idInUse(String id);
    
    /**
     * Add a session to the list of known sessions for a given ID.
     * @param session The session
     */
    void addSession(HttpSession session);
    
    /**
     * Remove session from the list of known sessions for a given ID.
     * @param session the session to remove
     */
    void removeSession(HttpSession session);
    
    /**
     * Call {@link HttpSession#invalidate()} on all known sessions for the given id.
     * @param id The session ID without any cluster node extension
     */
    void invalidateAll(String id);
    
    /**
     * Create a new Session ID.
     * 
     * @param request the request with the sesion
     * @param created the timestamp for when the session was created
     * @return the new session id
     */
    String newSessionId(HttpServletRequest request,long created);
    
    
    
    String getWorkerName();
    
    
    /* ------------------------------------------------------------ */
    /** Get a cluster ID from a node ID.
     * Strip node identifier from a located session ID.
     * @param nodeId the node id
     * @return the cluster id
     */
    String getClusterId(String nodeId);
    
    /* ------------------------------------------------------------ */
    /** Get a node ID from a cluster ID and a request
     * @param clusterId The ID of the session
     * @param request The request that for the session (or null)
     * @return The session ID qualified with the node ID.
     */
    String getNodeId(String clusterId,HttpServletRequest request);
    
    
    /* ------------------------------------------------------------ */
    /** Change the existing session id.
    * 
    * @param oldClusterId the old cluster id
    * @param oldNodeId the old node id
    * @param request the request containing the session
    */
    void renewSessionId(String oldClusterId, String oldNodeId, HttpServletRequest request);    

    
}
