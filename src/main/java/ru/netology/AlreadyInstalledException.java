package ru.netology;


public class AlreadyInstalledException extends RuntimeException {
    public AlreadyInstalledException(String msg) {
        super(msg);
    }
}
