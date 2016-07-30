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

package com.acme;

import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

/**
 * MockUserTransaction
 *
 *.
 */
public class MockUserTransaction implements UserTransaction
{

    public void begin() throws NotSupportedException, SystemException
    {
    }

    public void commit() throws HeuristicMixedException,
            HeuristicRollbackException, IllegalStateException,
            RollbackException, SecurityException, SystemException
    {
    }

    public int getStatus() throws SystemException
    {
        return 0;
    }

    public void rollback() throws IllegalStateException, SecurityException,
            SystemException
    {
    }

    public void setRollbackOnly() throws IllegalStateException, SystemException
    {
    }

    public void setTransactionTimeout(int arg0) throws SystemException
    {
    }

}
