package com.xtpeach.tiny.id.base.exception;

/**
 * @author xtpeach
 */
public class TinyIdSysException extends RuntimeException {

    public TinyIdSysException() {
        super();
    }

    public TinyIdSysException(String message) {
        super(message);
    }

    public TinyIdSysException(String message, Throwable cause) {
        super(message, cause);
    }

    public TinyIdSysException(Throwable cause) {
        super(cause);
    }
}
