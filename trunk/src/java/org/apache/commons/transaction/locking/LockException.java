/*
 * $Header: /home/jerenkrantz/tmp/commons/commons-convert/cvs/home/cvs/jakarta-commons//transaction/src/java/org/apache/commons/transaction/locking/LockException.java,v 1.2 2005/01/09 15:12:11 ozeigermann Exp $
 * $Revision: 1.2 $
 * $Date: 2005/01/09 15:12:11 $
 *
 * ====================================================================
 *
 * Copyright 1999-2002 The Apache Software Foundation 
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package org.apache.commons.transaction.locking;

/**
 * Exception displaying a lock problem.
 * 
 * @version $Revision: 1.2 $
 * @since 1.1
 */
public class LockException extends RuntimeException {

    /**
     * Thread has been interrupted while waiting for lock.
     */
    public static final int CODE_INTERRUPTED = 1;

    /**
     * Maximum wait time for a lock has been exceeded.
     */
    public static final int CODE_TIMED_OUT = 2;

    /**
     * Locking request canceled because of deadlock.
     */
    public static final int CODE_DEADLOCK_VICTIM = 3;

    protected Object resourceId;

    protected String reason;

    protected int code;

    public LockException(String reason, int code, Object resourceId) {
        this.reason = reason;
        this.code = code;
        this.resourceId = resourceId;
    }

    /**
     * Returns the formal reason for the exception.
     * 
     * @return one of {@link #CODE_INTERRUPTED},{@link #CODE_TIMED_OUT}or
     *         {@link #CODE_DEADLOCK_VICTIM}.
     */
    public int getCode() {
        return code;
    }

    /**
     * Returns the resource the lock was tried on.
     * 
     * @return the resource or <code>null</code> if not applicable
     */
    public Object getResourceId() {
        return resourceId;
    }

    /**
     * Returns the verbose for the exception.
     * 
     * @return the reason message
     */
    public String getReason() {
        return reason;
    }
}