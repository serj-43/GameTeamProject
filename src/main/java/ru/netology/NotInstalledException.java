package ru.netology;

public class NotInstalledException extends RuntimeException {
    public NotInstalledException(String msg) {
        super(msg);
    }
}
