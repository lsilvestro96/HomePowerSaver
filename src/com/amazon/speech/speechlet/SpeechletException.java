/**
    Copyright 2014-2015 Amazon.com, Inc. or its affiliates. All Rights Reserved.

    Licensed under the Apache License, Version 2.0 (the "License"). You may not use this file except in compliance with the License. A copy of the License is located at

        http://aws.amazon.com/apache2.0/

    or in the "license" file accompanying this file. This file is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.
 */

package com.amazon.speech.speechlet;

/**
 * Defines a general exception that a {@code Speechlet} can throw when encountering difficulty while
 * processing a request.
 *
 * @see Speechlet
 */
@SuppressWarnings("serial")
public class SpeechletException extends Exception {
    /**
     * Constructs a new exception with null as its detail message. The cause is not initialized.
     */
    public SpeechletException() {
    }

    /**
     * Constructs a new exception with the specified detail message. The cause is not initialized.
     *
     * @param message
     *            the detail message
     */
    public SpeechletException(final String message) {
        super(message);
    }

    /**
     * Constructs a new exception with the specified cause and a detail message of
     * {@code (cause==null ? null : cause.toString())} (which typically contains the class and
     * detail message of cause). This constructor is useful for exceptions that are little more than
     * wrappers for other throwables.
     *
     * @param cause
     *            the cause. A {@code null} value is permitted, and indicates that the cause is
     *            nonexistent or unknown
     */
    public SpeechletException(final Throwable cause) {
        super(cause);
    }

    /**
     * Constructs a new exception with the specified detail message and cause. Note that the detail
     * message associated with cause is not automatically incorporated in this exception's detail
     * message.
     *
     * @param message
     *            the detail message
     * @param cause
     *            the cause. A {@code null} value is permitted, and indicates that the cause is
     *            nonexistent or unknown
     */
    public SpeechletException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
